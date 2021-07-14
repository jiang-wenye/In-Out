package com.gui.panel;

//消费分类面板
import java.awt.BorderLayout;

import javax.swing.*;

import com.entity.Category;
import com.gui.listener.CategoryListener;
import com.gui.model.CategoryTableModel;
import com.service.CategoryService;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class CategoryPanel extends WorkingPanel {
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static CategoryPanel instance = new CategoryPanel();
	public JButton bAdd = new JButton("添加");
	public JButton bEdit = new JButton("编辑");
	public JButton bDelete = new JButton("删除");
	String[] columNames = new String[] { "分类名称", "消费次数" };
	public CategoryTableModel ctm = new CategoryTableModel();
	public JTable t = new JTable(ctm);

	public CategoryPanel() {
		GuiUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		addListener();
	}

	public void updateData() {
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);
		if (0 == ctm.cs.size()) {
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		} else {
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
	}

	public void addListener() {
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}

	public Category getSelectedCategory() {
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}

	public static void main(String[] args) {
		GuiUtil.showPanel(CategoryPanel.instance);
	}
}