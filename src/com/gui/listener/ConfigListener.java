package com.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import com.gui.panel.ConfigPanel;
import com.service.ConfigService;
import com.util.GuiUtil;

public class ConfigListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigPanel p = ConfigPanel.instance;
		if(!GuiUtil.checkNumber(p.tfBudget, "����Ԥ��")) {
			return;
		}
		String mysqlPath = p.tfMysqlPath.getText().trim();
		if(0!=mysqlPath.length()) {
			File commandFile = new File(mysqlPath,"bin/mysql.exe");
			if(!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "mysql·������ȷ");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);
		JOptionPane.showMessageDialog(p, "�����޸ĳɹ�");
		p.updateData();
	}

}
