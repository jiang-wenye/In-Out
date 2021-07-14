package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;
import com.entity.Category;

//���ѷ���DAO
public class CategoryDAO {
	// ��ȡ����
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection();
				// ��ȡStatement����
				Statement s = c.createStatement();) {
			String sql = "select count(*) from 	category";// ����category���е�����
			ResultSet rs = s.executeQuery(sql);// ִ��sql���
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("total:" + total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// �������
	public void add(Category category) {
		String sql = "insert into category values(null,?)";// ?��ռλ�����������ݲ�����nullΪ��ӿ�ֵ
		try (Connection c = DBUtil.getConnection();
				//����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ⡣ 				
				//���� IN �����򲻴��� IN ������ SQL ��䶼���Ա�Ԥ���벢�洢�� PreparedStatement ������
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, category.name);
			ps.execute();
			// ���������������Զ����ɵļ�
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				category.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ����idɾ������
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "delete form category where id =" + id;
			s.execute(sql);// ִ��sql���
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ����
	public void update(Category category) {
		String sql = "update category set name = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, category.name);
			ps.setInt(2, category.id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ����id��ȡ����
	public Category get(int id) {
		Category category = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "select * from category whete id=" + id;
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				category = new Category();
				String name = rs.getString(2);
				category.name = name;
				category.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public List<Category>list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Category> list(int start,int count){
		List<Category> categorys = new ArrayList<Category>();
		String sql = "select * from category order by id desc limit ?,?";
		try(Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				int id =rs.getInt(1);
				String name = rs.getString(2);
				category.id=id;
				category.name=name;
				categorys.add(category);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorys;
	}
	
}