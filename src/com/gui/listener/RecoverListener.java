package com.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.gui.panel.ConfigPanel;
import com.gui.panel.MainPanel;
import com.gui.panel.RecoverPanel;
import com.service.ConfigService;
import com.util.MysqlUtil;

public class RecoverListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		RecoverPanel p = RecoverPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if (0 == mysqlPath.length()) {
			JOptionPane.showMessageDialog(p, "ª÷∏¥«∞«Îœ»≈‰÷√mysql¬∑æ∂");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("bill.sql"));
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
		int returnVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (!file.getName().toLowerCase().endsWith(".sql")) {
				JOptionPane.showMessageDialog(p, "Œƒº˛∏Ò Ω¥ÌŒÛ");
				return;
			}
			try {
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "ª÷∏¥≥…π¶");
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "ª÷∏¥ ß∞‹\r\n,¥ÌŒÛ:\r\n" + e1.getMessage());
			}
		}
	}

}

