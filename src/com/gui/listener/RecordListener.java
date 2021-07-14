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
			JOptionPane.showMessageDialog(p, "暂无消费，无法添加，请先增加消费分类");
			//跳转到添加界面
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		//判断输入金额是否有效
		if (!GuiUtil.checkZero(p.tfSpend, "花费金额")) {
			return;
		}
		//消费金额
		int spend = Integer.parseInt(p.tfSpend.getText());
		//消费类别
		Category c = p.getSelectedCategory();
		//备注
		String comment = p.tfComment.getText();
		//时间
		Date d = p.datepick.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "添加成功");
		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}
}
