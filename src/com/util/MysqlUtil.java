package com.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//数据库实例,进行备份和恢复

public class MysqlUtil {
	/*
	 * 备份工具
	 */
	public static void backup(String mysqlPath, String backupfile) throws IOException {
		// 备份文件的格式
		String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
		String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port,
				DBUtil.database, backupfile);
		System.out.println(command);
		Runtime.getRuntime().exec(command);
	}

	public static void recover(String mysqlPath, String recoverfile) throws IOException {
		try {
			String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s %s";
			String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port,
					DBUtil.database);
			Process p = Runtime.getRuntime().exec(command);
			OutputStream out = p.getOutputStream();
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// 将recover文字通过new FileInputStream获取字节流,然后将字节流转换为字符流读取
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf-8"));
			while ((inStr = br.readLine()) != null) {
				// append(StringBuffer sb) 将指定的 StringBuffer 追加到此序列中。
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			// OutputStreamWriter:可使用指定的charset将要写入流中的字符编码成字节，
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
			writer.write(outStr);// 将outStr写入到out中
			writer.flush();
			out.close();
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		//数据库地址
		String mysqlPath = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5";
		String file = "C:/Documents and Settings/Administrator/My Documents/billxxx.sql";
		backup(mysqlPath, file);
	}
}
