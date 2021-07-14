package com.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.service.CategoryService;
import com.entity.Category;
import com.gui.panel.CategoryPanel;

public class CategoryListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.instance;
		JButton b = (JButton) e.getSource();
		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if(name == null){
				return;
			}
			if (0 == name.trim().length()) {
				JOptionPane.showMessageDialog(p, "������Ϣ����Ϊ��");
				return;
			}
			new CategoryService().add(name);
		}
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			String name = JOptionPane.showInputDialog("�޸ķ�������", c.name);
			if(name == null){
				return;
			}
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().update(c.id, name);
			JOptionPane.showMessageDialog(p,"�޸ĳɹ�");
		}
		if (b == p.bDelete) {
			Category c = p.getSelectedCategory();
			if(c.recordNumber == 0){
				if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"ȷ��Ҫɾ��?")){
					return;
				}
			}
			if (0 != c.recordNumber) {
				JOptionPane.showMessageDialog(p, "�������������Ѽ�¼���ڣ�����ɾ��");
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "ȷ��Ҫɾ����")) {
				return;
			}
			new CategoryService().delete(c.id);
		}
		p.updateData();;
	}
}
