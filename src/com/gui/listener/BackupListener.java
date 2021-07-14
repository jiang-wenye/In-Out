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
			JOptionPane.showMessageDialog(p, "����ǰ�������ú�mysql·��");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("bill.sql"));
		// ѡ���ļ�ʱֻ��ʾFileFilter�����˵�.sql�ļ�
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
		int returnVal = fc.showSaveDialog(p);//fc����p����returnVal
		File file = fc.getSelectedFile();//����ѡ����ļ�
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if(!file.getName().toLowerCase().endsWith(".sql")) {
				file = new File(file.getParent(),file.getName()+".sql");
			}
			try {
				//����Util���߽��б���
				MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p,"���ݳɹ� �����ļ�λ�ڣ�\r\n"+file.getAbsolutePath());
			}catch(Exception e1) {
				e1.printStackTrace();
				//����ʧ�ܷ��ش�����Ϣ
				JOptionPane.showMessageDialog(p, "����ʧ��\r\n"+e1.getMessage());
			}
			
		}
			
		
	}
}
