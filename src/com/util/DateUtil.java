package com.util;

import java.util.Calendar;
import java.util.Date;

 //���ڹ���

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;// 1��ĺ�����

	// ��util����������ת��Ϊsql������������
	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	public static Date today() {
		Calendar c = Calendar.getInstance();// ��ȡCalendar����
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	//�³�
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();

	}

	//��ĩ
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		// ��ʱ���趨Ϊ���������-��-��-Сʱ-����-��
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		// ����Ϊ��ĩ,������һ�쵽�³���Ȼ������һ���µ���һ����,Ȼ���ټ�һ�쵽�ϸ�����ĩ
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	//����һ���ж�����
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	//���»�ʣ������
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}
}

