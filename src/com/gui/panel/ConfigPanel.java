package com.gui.panel;

import java.awt.*;
import javax.swing.*;

import com.gui.listener.ConfigListener;
import com.service.ConfigService;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class ConfigPanel extends JPanel{
	static {
		GuiUtil.useLNF();
	}

	public static ConfigPanel instance = new ConfigPanel();
	JLabel IBudget = new JLabel("本月预算（¥）");
	public JTextField tfBudget = new JTextField("1500");// 输入本月预算
	JLabel IMysql = new JLabel("MySql安装目录");
	public JTextField tfMysqlPath = new JTextField("C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5");// 输入mysql安装目录
	JButton bSubmit = new JButton("更新");

	public ConfigPanel() {
		GuiUtil.setColor(ColorUtil.grayColor, IBudget, IMysql);
		GuiUtil.setColor(ColorUtil.blueColor, bSubmit);

		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 1, gap, gap));// 创建一个4行1列,间距为40的网格布局管理器
		pInput.add(IBudget);
		pInput.add(tfBudget);
		pInput.add(IMysql);
		pInput.add(tfMysqlPath);
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		pSubmit.add(bSubmit);
		this.add(pSubmit, BorderLayout.CENTER);
		addListener();
	}

	public void addListener() {
		ConfigListener listener = new ConfigListener();
		bSubmit.addActionListener(listener);
	}

	public void updateData() {
		String budget = new ConfigService().get(ConfigService.budget);
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);
		tfBudget.grabFocus();
	}

	public static void main(String[] args) {
		GuiUtil.showPanel(ConfigPanel.instance);
	}
}

