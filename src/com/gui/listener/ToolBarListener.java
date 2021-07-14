package com.gui.listener;

import java.awt.event.*;
import javax.swing.JButton;
import com.gui.panel.*;

//Ϊ����������һ�й��������Ӽ��

public class ToolBarListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		MainPanel p = MainPanel.instance;
		JButton b  = (JButton)e.getSource();
		if(b==p.bSpend) {
			p.workingPanel.show(SpendPanel.instance);;
		}else if(b==p.bReport) {
			p.workingPanel.show(ReportPanel.instance);
		}else if(b==p.bCategory) {
			p.workingPanel.show(CategoryPanel.instance);
		}else if(b==p.bRecord) {
			p.workingPanel.show(RecordPanel.instance);
		}else if(b==p.bBackup) {
			p.workingPanel.show(BackupPanel.instance);
		}else if(b==p.bRecover) {
			p.workingPanel.show(RecoverPanel.instance);
		}else if(b==p.bConfig) {
			p.workingPanel.show(ConfigPanel.instance);
		}
	}
}

