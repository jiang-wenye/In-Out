package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.entity.Config;
import com.util.DBUtil;

public class ConfigDAO {
	public int Total() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "select count(*) from config";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next())
				;
			{
				total = rs.getInt(1);
			}
			System.out.println("total:" + total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public void add(Config config) {
		String sql = "insert into config values(null,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
			ps.setString(1, config.getKey());
			ps.setString(2, config.getValue());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();// 获取自增序列
			while (rs.next()) {
				int id = rs.getInt(1);
				config.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "delet from config where id=" + id;
			s.execute(sql);// 执行sql语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Config update(Config config) {
		String sql = "update config set key_= ?,value = ? where id =?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, config.key);// 根据占位符决定顺序
			ps.setString(2, config.value);
			ps.setInt(3, config.id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return config;
	}

	public Config get(int id) {
		Config config = null;
		String sql = "select * from config where id=" + id;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				config = new Config();
				String key = rs.getString("key_");
				String value = rs.getString("value");
				config.key = key;
				config.value = value;
				config.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return config;
	}

	// 分页查询
	public List<Config> list(int start, int count) {
		List<Config> configs = new ArrayList<Config>();
		String sql = "select * fron config order by id desc limit ?,?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Config config = new Config();
				int id = rs.getInt(1);
				String key = rs.getString("key_");
				String value = rs.getString("value");
				config.id = id;
				config.key = key;
				config.value = value;
				configs.add(config);// 将
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return configs;
	}

	public Config getByKey(String key) {
		Config config = null;
		String sql = "select * from config where key_ = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				config = new Config();
				int id = rs.getInt("id");
				String value = rs.getString("value");
				config.key = key;
				config.value = value;
				config.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return config;
	}
}
