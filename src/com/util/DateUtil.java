package com.util;

import java.util.Calendar;
import java.util.Date;

 //日期工具

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;// 1天的毫秒数

	// 将util的日期类型转化为sql的类日期类型
	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	public static Date today() {
		Calendar c = Calendar.getInstance();// 获取Calendar对象
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	//月初
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

	//月末
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		// 将时间设定为今天包含年-月-日-小时-分钟-秒
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		// 设置为月末,先增加一天到月初，然后增加一个月到下一个月,然后再减一天到上个月月末
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	//本月一共有多少天
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	//本月还剩多少天
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}
}

