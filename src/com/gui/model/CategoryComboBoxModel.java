package com.gui.model;

import java.util.*;
import javax.swing.*;
import javax.swing.event.ListDataListener;

import com.entity.*;
import com.service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
	public List<Category> cs = new CategoryService().list();
	public Category c;

	public CategoryComboBoxModel() {
		if (!cs.isEmpty()) {
			c = cs.get(0);
		}
	}

	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;
	}

	@Override
	public Object getSelectedItem() {
		if (!cs.isEmpty()) {
			return c;
		} else {
			return null;
		}
	}

	@Override
	public int getSize() {
		return cs.size();
	}

	public Category getElementAt(int index) {
		return cs.get(index);
	}

	// 将某个监听器添加到每次更改数据模型都要通知的列表
	public void addListDataListener(ListDataListener l) {

	}

	// 将某个监听器从每次更改数据模型都要通知的列表中移除
	public void removeListDataListener(ListDataListener l) {

	}

}
