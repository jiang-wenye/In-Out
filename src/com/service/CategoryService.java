package com.service;

import java.util.*;

import com.dao.*;
import com.entity.*;
import com.entity.Record;

 //Category面板中功能的实现
public class CategoryService {
	CategoryDAO categoryDAO = new CategoryDAO();
	RecordDAO recordDAO = new RecordDAO();

	public List<Category> list() {
		// 将Category表中的数据取出来,并将id存入Record中
		List<Category> cs = categoryDAO.list();
		for (Category c : cs) {
			List<Record> rs = recordDAO.list(c.id);
			c.recordNumber = rs.size();
		}
		Collections.sort(cs, (c1, c2) -> c2.recordNumber - c1.recordNumber);
		return cs;
	}

	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		categoryDAO.add(c);
	}

	public void update(int id, String name) {
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDAO.update(c);
	}

	public void delete(int id) {
		categoryDAO.delete(id);
	}
}
