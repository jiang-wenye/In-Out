package com.gui.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import com.gui.panel.BackupPanel;
import com.gui.panel.ConfigPanel;
import com.gui.panel.MainPanel;
import com.service.ConfigService;
import com.util.MysqlUtil;

public class BackupListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		BackupPanel p = BackupPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if (0 == mysqlPath.length()) {
			JOptionPane.showMessageDialog(p, "备份前请先配置好mysql路径");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("bill.sql"));
		// 选择文件时只显示FileFilter定义了的.sql文件
		fc.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");
			}
			@Override
			public String getDescription() {
				return ".sql";
			}

		});
		int returnVal = fc.showSaveDialog(p);//fc保存p传给returnVal
		File file = fc.getSelectedFile();//返回选择的文件
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if(!file.getName().toLowerCase().endsWith(".sql")) {
				file = new File(file.getParent(),file.getName()+".sql");
			}
			try {
				//调用Util工具进行备份
				MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p,"备份成功 备份文件位于：\r\n"+file.getAbsolutePath());
			}catch(Exception e1) {
				e1.printStackTrace();
				//备份失败返回错误信息
				JOptionPane.showMessageDialog(p, "备份失败\r\n"+e1.getMessage());
			}
			
		}
			
		
	}
}
