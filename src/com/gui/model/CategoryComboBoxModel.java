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

	// ��ĳ����������ӵ�ÿ�θ�������ģ�Ͷ�Ҫ֪ͨ���б�
	public void addListDataListener(ListDataListener l) {

	}

	// ��ĳ����������ÿ�θ�������ģ�Ͷ�Ҫ֪ͨ���б����Ƴ�
	public void removeListDataListener(ListDataListener l) {

	}

}
