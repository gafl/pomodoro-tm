/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pomodoro.model

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import pomodoro.model.PomodoroModel.PomodoroState.*
import java.util.concurrent.TimeUnit.MINUTES
import java.util.concurrent.TimeUnit.SECONDS

class PomodoroModelTest {

    @Test fun `do one pomodoro`() {
        val model = PomodoroModel(settings(2000, 1000), PomodoroModelState())
        assertThat(model.state, equalTo(STOP))
        assertThat(model.progress, equalTo(0))
        assertThat(model.pomodorosAmount, equalTo(0))

        model.onUserSwitchToNextState(time(0))
        assertThat(model.state, equalTo(RUN))
        assertThat(model.getProgressMax(), equalTo(2))

        model.onTimer(time(updateInterval))
        assertThat(model.progress, equalTo(1))

        model.onTimer(time((updateInterval * 2)))
        assertThat(model.state, equalTo(BREAK))
        assertThat(model.progress, equalTo(0))
        assertThat(model.pomodorosAmount, equalTo(1))
    }

    @Test fun `do several pomodoros`() {
        val model = PomodoroModel(settings(2000, 1000), PomodoroModelState())
        assertThat(model.pomodorosAmount, equalTo(0))

        model.onUserSwitchToNextState(time(0))
        assertThat(model.state, equalTo(RUN))

        model.onTimer(time((updateInterval * 3)))
        assertThat(model.state, equalTo(BREAK))
        assertThat(model.pomodorosAmount, equalTo(1))

        model.onTimer(time((updateInterval * 4)))
        model.onUserSwitchToNextState(time((updateInterval * 4)))
        assertThat(model.state, equalTo(RUN))

        model.onTimer(time((updateInterval * 6)))
        assertThat(model.state, equalTo(BREAK))
        assertThat(model.pomodorosAmount, equalTo(2))
    }

    @Test fun `stop during pomodoro`() {
        val model = PomodoroModel(settings(2000, 1000), PomodoroModelState())
        assertThat(model.state, equalTo(STOP))
        assertThat(model.progress, equalTo(0))
        assertThat(model.pomodorosAmount, equalTo(0))

        model.onUserSwitchToNextState(time(0))

        assertThat(model.state, equalTo(RUN))

        model.onTimer(time(updateInterval))
        assertThat(model.progress, equalTo(1))

        model.onUserSwitchToNextState(time((updateInterval * 2)))

        assertThat(model.state, equalTo(STOP))
        assertThat(model.pomodorosAmount, equalTo(0))
    }

    @Test fun `auto stop after break`() {
        val model = PomodoroModel(settings(1000, 2000), PomodoroModelState())

        assertThat(model.state, equalTo(STOP))
        model.onUserSwitchToNextState(time(0))

        model.onTimer(time(updateInterval))
        assertThat(model.state, equalTo(BREAK))

        model.onTimer(time(updateInterval) * 2)
        assertThat(model.progress, equalTo(1))

        model.onTimer(time(updateInterval) * 3)
        assertThat(model.state, equalTo(STOP))
        assertThat(model.progress, equalTo(2))
    }

    @Test fun `after idea restart continue from saved state and finish pomodoro`() {
        val modelState = PomodoroModelState(RUN, RUN, minute(-24), second(-1))
        val model = PomodoroModel(settings(25), modelState, minute(0))

        assertThat(model.state, equalTo(RUN))
        assertTrue(model.progress > 0)
        assertThat(model.pomodorosAmount, equalTo(0))

        model.onTimer(minute(1))

        assertThat(model.state, equalTo(BREAK))
        assertThat(model.pomodorosAmount, equalTo(1))
    }

    @Test fun `after idea restart should not continue from last state if aLot of time has passed`() {
        // last state was RUN
        var modelState = PomodoroModelState(RUN, RUN, minute(-60), minute(-20))
        var model = PomodoroModel(settings(minute(25), 2000), modelState, minute(0))

        assertThat(model.state, equalTo(STOP))
        assertNull(model.lastState)
        assertThat(model.progress, equalTo(0))
        assertThat(model.pomodorosAmount, equalTo(0))

        // last state was BREAK
        modelState = PomodoroModelState(BREAK, RUN, minute(-60), minute(-20))
        model = PomodoroModel(settings(minute(6), 2000), modelState, time(0))

        assertThat(model.state, equalTo(STOP))
        assertNull(model.lastState)
        assertThat(model.progress, equalTo(0))
        assertThat(model.pomodorosAmount, equalTo(0))
    }

    @Test fun `save pomodoro model state`() {
        val pomodoroStartTime = SECONDS.toMillis(-24)
        val modelState = PomodoroModelState(RUN, RUN, pomodoroStartTime, time(0))
        val model = PomodoroModel(settings(SECONDS.toMillis(24), 2000), modelState, time(0))

        assertThat(model.state, equalTo(RUN))

        model.onTimer(time(updateInterval))

        assertThat(modelState.pomodoroState, equalTo(BREAK))
        assertTrue("model state was updated", modelState.startTime > pomodoroStartTime)
    }

    companion object {
        private val updateInterval = 1100L

        private fun minute(n: Long) = MINUTES.toMillis(n)

        private fun second(n: Long) = SECONDS.toMillis(n)

        private fun time(n: Long) = n

        private fun settings(pomodoroLength: Long): Settings {
            val settings = Settings()
            settings.pomodoroLengthInMinutes = pomodoroLength.toInt()
            return settings
        }

        private fun settings(pomodoroLengthMs: Long, breakLengthMs: Long): Settings {
            return object : Settings() {
                override val pomodoroLengthInMillis = pomodoroLengthMs
                override val breakLengthInMillis = breakLengthMs
            }
        }
    }
}
