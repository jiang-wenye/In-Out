package com.gui.model;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.entity.Category;
import com.service.CategoryService;

public class CategoryTableModel implements TableModel {
	String[] columnNames = { "分类名称", "消费次数" };
	public List<Category> cs = new CategoryService().list();

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return cs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Category h =cs.get(rowIndex);
		if(0==columnIndex)
			return h.name;
		if(1==columnIndex)
			return h.recordNumber;
		return null;
	}

	@Override
	public boolean isCellEditable(int rowindex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {

	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {

	}

}

