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
package pomodoro.settings;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

class SettingsForm {
	public JComboBox pomodoroLengthComboBox;
	public JComboBox breakLengthComboBox;
	public JSlider ringVolumeSlider;
	public JCheckBox popupCheckBox;
	public JCheckBox blockDuringBreak;
	private JPanel rootPanel;
	public JCheckBox showToolWindowCheckbox;
	public JCheckBox showTimeInToolbarWidgetCheckbox;
	public JComboBox longBreakLengthComboBox;
	public JComboBox longBreakFrequencyComboBox;

	public JPanel getRootPanel() {
		return rootPanel;
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		rootPanel = new JPanel();
		rootPanel.setLayout(new GridLayoutManager(2, 2, new Insets(10, 10, 0, 0), -1, -1));
		final Spacer spacer1 = new Spacer();
		rootPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		final Spacer spacer2 = new Spacer();
		rootPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(9, 5, new Insets(0, 0, 0, 0), -1, -1));
		rootPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setText("Pomodoro length:");
		label1.setDisplayedMnemonic('P');
		label1.setDisplayedMnemonicIndex(0);
		panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer3 = new Spacer();
		panel1.add(spacer3, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		pomodoroLengthComboBox = new JComboBox();
		pomodoroLengthComboBox.setEditable(true);
		final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
		defaultComboBoxModel1.addElement("25");
		defaultComboBoxModel1.addElement("30");
		defaultComboBoxModel1.addElement("35");
		defaultComboBoxModel1.addElement("40");
		defaultComboBoxModel1.addElement("45");
		pomodoroLengthComboBox.setModel(defaultComboBoxModel1);
		panel1.add(pomodoroLengthComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setText("minute(s)");
		panel1.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label3 = new JLabel();
		label3.setText("Break length:");
		label3.setDisplayedMnemonic('B');
		label3.setDisplayedMnemonicIndex(0);
		panel1.add(label3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		breakLengthComboBox = new JComboBox();
		breakLengthComboBox.setEditable(true);
		final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
		defaultComboBoxModel2.addElement("5");
		defaultComboBoxModel2.addElement("10");
		defaultComboBoxModel2.addElement("15");
		breakLengthComboBox.setModel(defaultComboBoxModel2);
		panel1.add(breakLengthComboBox, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label4 = new JLabel();
		label4.setText("minute(s)");
		panel1.add(label4, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label5 = new JLabel();
		label5.setText("Ring volume:");
		panel1.add(label5, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		ringVolumeSlider = new JSlider();
		ringVolumeSlider.setMaximum(3);
		ringVolumeSlider.setSnapToTicks(true);
		ringVolumeSlider.setValue(1);
		panel1.add(ringVolumeSlider, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label6 = new JLabel();
		label6.setText("Show popup notification:");
		label6.setToolTipText(ResourceBundle.getBundle("resources/messages").getString("settings.popup.tooltip"));
		panel1.add(label6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		popupCheckBox = new JCheckBox();
		popupCheckBox.setText("");
		popupCheckBox.setToolTipText(ResourceBundle.getBundle("resources/messages").getString("settings.popup.tooltip"));
		panel1.add(popupCheckBox, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label7 = new JLabel();
		label7.setText("Block IDE during break:");
		label7.setToolTipText(ResourceBundle.getBundle("resources/messages").getString("settings.blockCheckbox.tooltip"));
		panel1.add(label7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		blockDuringBreak = new JCheckBox();
		blockDuringBreak.setActionCommand("");
		blockDuringBreak.setDoubleBuffered(true);
		blockDuringBreak.setToolTipText(ResourceBundle.getBundle("resources/messages").getString("settings.blockCheckbox.tooltip"));
		panel1.add(blockDuringBreak, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label8 = new JLabel();
		label8.setText("Show tool window:");
		panel1.add(label8, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		showToolWindowCheckbox = new JCheckBox();
		showToolWindowCheckbox.setText("");
		panel1.add(showToolWindowCheckbox, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label9 = new JLabel();
		label9.setText("Show time in toolbar:");
		panel1.add(label9, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		showTimeInToolbarWidgetCheckbox = new JCheckBox();
		showTimeInToolbarWidgetCheckbox.setText("");
		panel1.add(showTimeInToolbarWidgetCheckbox, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label10 = new JLabel();
		label10.setText("Long break length:");
		label10.setDisplayedMnemonic('L');
		label10.setDisplayedMnemonicIndex(0);
		panel1.add(label10, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		longBreakLengthComboBox = new JComboBox();
		longBreakLengthComboBox.setEditable(true);
		final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
		defaultComboBoxModel3.addElement("15");
		defaultComboBoxModel3.addElement("20");
		defaultComboBoxModel3.addElement("25");
		defaultComboBoxModel3.addElement("30");
		longBreakLengthComboBox.setModel(defaultComboBoxModel3);
		longBreakLengthComboBox.setSelectedIndex(1);
		panel1.add(longBreakLengthComboBox, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label11 = new JLabel();
		label11.setText("minute(s) after");
		panel1.add(label11, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		longBreakFrequencyComboBox = new JComboBox();
		longBreakFrequencyComboBox.setEditable(true);
		final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
		defaultComboBoxModel4.addElement("2");
		defaultComboBoxModel4.addElement("3");
		defaultComboBoxModel4.addElement("4");
		defaultComboBoxModel4.addElement("5");
		defaultComboBoxModel4.addElement("6");
		longBreakFrequencyComboBox.setModel(defaultComboBoxModel4);
		longBreakFrequencyComboBox.setOpaque(false);
		longBreakFrequencyComboBox.setSelectedIndex(2);
		panel1.add(longBreakFrequencyComboBox, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label12 = new JLabel();
		label12.setText("pomodoros");
		panel1.add(label12, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		label1.setLabelFor(pomodoroLengthComboBox);
		label3.setLabelFor(breakLengthComboBox);
		label10.setLabelFor(breakLengthComboBox);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return rootPanel;
	}
}
