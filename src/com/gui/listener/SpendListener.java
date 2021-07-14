package com.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.gui.panel.SpendPanel;

public class SpendListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		SpendPanel.instance.vAvgSpendPerDay.setText("xxxxx");
	}
}

