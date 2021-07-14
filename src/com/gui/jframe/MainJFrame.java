package com.gui.jframe;

import javax.swing.*;
import com.gui.panel.MainPanel;

public class MainJFrame extends JFrame {
	//创建窗口
	public static MainJFrame instance = new MainJFrame();

	private MainJFrame() {
		this.setSize(500, 450);//窗口尺寸
		this.setTitle("In&Out");//窗口名称
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
