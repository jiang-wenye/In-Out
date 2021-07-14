package com.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//���ݿ�ʵ��,���б��ݺͻָ�

public class MysqlUtil {
	/*
	 * ���ݹ���
	 */
	public static void backup(String mysqlPath, String backupfile) throws IOException {
		// �����ļ��ĸ�ʽ
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
			// ��recover����ͨ��new FileInputStream��ȡ�ֽ���,Ȼ���ֽ���ת��Ϊ�ַ�����ȡ
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf-8"));
			while ((inStr = br.readLine()) != null) {
				// append(StringBuffer sb) ��ָ���� StringBuffer ׷�ӵ��������С�
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			// OutputStreamWriter:��ʹ��ָ����charset��Ҫд�����е��ַ�������ֽڣ�
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
			writer.write(outStr);// ��outStrд�뵽out��
			writer.flush();
			out.close();
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		//���ݿ��ַ
		String mysqlPath = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5";
		String file = "C:/Documents and Settings/Administrator/My Documents/billxxx.sql";
		backup(mysqlPath, file);
	}
}
