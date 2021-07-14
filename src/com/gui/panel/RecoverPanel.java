package com.gui.panel;

import javax.swing.*;

import com.gui.listener.RecoverListener;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class RecoverPanel extends JPanel {
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static RecoverPanel instance = new RecoverPanel();
	JButton bRecover = new JButton("Êý¾Ý»Ö¸´");

	private RecoverPanel() {
		GuiUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);
		addListener();
	}

	public void addListener() {
		RecoverListener listener = new RecoverListener();
		bRecover.addActionListener(listener);
	}

	public static void main(String[] args) {
		GuiUtil.showPanel(RecoverPanel.instance);
	}
}
