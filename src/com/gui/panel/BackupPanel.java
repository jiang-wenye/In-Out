package com.gui.panel;

import javax.swing.*;
import com.gui.listener.BackupListener;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class BackupPanel extends JPanel{
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static BackupPanel instance = new BackupPanel();
	JButton bBackup = new JButton("±¸·Ý");
	private BackupPanel() {
		GuiUtil.setColor(ColorUtil.blueColor, bBackup);
		this.add(bBackup);
		addListener();
	}
	public void addListener() {
		BackupListener listener = new BackupListener();
		bBackup.addActionListener(listener);
	}
	public static void main(String[] args) {
		GuiUtil.showPanel(BackupPanel.instance);
	}
}
