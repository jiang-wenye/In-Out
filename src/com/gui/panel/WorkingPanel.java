package com.gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {
	


	//��Ľ��汣�ֺ����ݿ��ͬ��
	public abstract void updateData();

	//Ϊ�������Ӽ�����
	public abstract void addListener();
}
