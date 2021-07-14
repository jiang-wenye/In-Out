package com.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import com.entity.Category;
import com.gui.panel.CategoryPanel;
import com.gui.panel.MainPanel;
import com.gui.panel.RecordPanel;
import com.gui.panel.SpendPanel;
import com.service.RecordService;
import com.util.GuiUtil;

public class RecordListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		RecordPanel p = RecordPanel.instance;
		if (0 == p.cbModel.cs.size()	) {
			JOptionPane.showMessageDialog(p, "�������ѣ��޷���ӣ������������ѷ���");
			//��ת����ӽ���
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		//�ж��������Ƿ���Ч
		if (!GuiUtil.checkZero(p.tfSpend, "���ѽ��")) {
			return;
		}
		//���ѽ��
		int spend = Integer.parseInt(p.tfSpend.getText());
		//�������
		Category c = p.getSelectedCategory();
		//��ע
		String comment = p.tfComment.getText();
		//ʱ��
		Date d = p.datepick.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "��ӳɹ�");
		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}
}
