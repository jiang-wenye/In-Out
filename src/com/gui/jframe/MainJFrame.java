package com.gui.jframe;

import javax.swing.*;
import com.gui.panel.MainPanel;

public class MainJFrame extends JFrame {
	//��������
	public static MainJFrame instance = new MainJFrame();

	private MainJFrame() {
		this.setSize(500, 450);//���ڳߴ�
		this.setTitle("In&Out");//��������
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
