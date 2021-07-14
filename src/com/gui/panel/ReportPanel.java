package com.gui.panel;

import java.awt.*;
import javax.swing.*;
import java.util.List;

import com.entity.Record;
import com.service.ReportService;
import com.util.ChartUtil;
import com.util.DateUtil;
import com.util.GuiUtil;

public class ReportPanel extends WorkingPanel {

//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static ReportPanel instance = new ReportPanel();
	public JLabel l = new JLabel();

	public ReportPanel() {
		this.setLayout(new BorderLayout());
		List<Record> rs = new ReportService().listThisMonthRecords();
		Image i = ChartUtil.getImage(rs,400, 300);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
		this.add(l);
	}

	@Override
	public void updateData() {
		List<Record> rs = new ReportService().listThisMonthRecords();
		Image i = ChartUtil.getImage(rs, 350,250);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
	}

	@Override
	public void addListener() {
		
	}

}