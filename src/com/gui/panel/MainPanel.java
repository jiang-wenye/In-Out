package com.gui.panel;

import java.awt.BorderLayout;

import javax.swing.*;
import com.gui.listener.ToolBarListener;
import com.util.CenterPanel;
import com.util.GuiUtil;

public class MainPanel extends JPanel {
	static {
		GuiUtil.useLNF();
	}
	public static MainPanel instance = new MainPanel();
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();// 消费明细
	public JButton bRecord = new JButton();// 支出记录
	public JButton bCategory = new JButton();// 消费分类
	public JButton bReport = new JButton();// 月度报表
	public JButton bConfig = new JButton();// 设置
	public JButton bBackup = new JButton();// 备份
	public JButton bRecover = new JButton();// 恢复

	public CenterPanel workingPanel;

	private MainPanel() {
		GuiUtil.setImageIcon(bSpend, "home.png", "消费明细");
		GuiUtil.setImageIcon(bRecord, "record.png", "记录支出");
		GuiUtil.setImageIcon(bCategory, "category2.png", "消费分类");
		GuiUtil.setImageIcon(bReport, "report.png", "月度报表");
		GuiUtil.setImageIcon(bConfig, "config.png", "设置");
		GuiUtil.setImageIcon(bBackup, "backup.png", "数据备份");
		GuiUtil.setImageIcon(bRecover, "recover.png", "数据恢复");
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		tb.setFloatable(false);
		workingPanel = new CenterPanel(0.8);
		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);
		addListener();
	}

	private void addListener() {
		ToolBarListener listener = new ToolBarListener();
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}
}
