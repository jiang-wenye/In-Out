package com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dao.RecordDAO;
import com.entity.Record;
import com.util.DateUtil;

public class ReportService {
	//某天的消费金额
	public int getDaySpend(Date d, List<Record> monthRawData) {
		int daySpend = 0;
		for (Record record : monthRawData) {
			if (record.getDate().equals(d)) {
				daySpend += record.spend;
			}	
		}
		return daySpend;
	}

	// 列出这个月的消费
	public List<Record> listThisMonthRecords() {
		RecordDAO dao = new RecordDAO();
		List<Record> monthRawData = dao.listThisMonth();
		List<Record> result = new ArrayList<Record>();
		Date monthBegin = DateUtil.monthBegin();
		int monthTotalDay = DateUtil.thisMonthTotalDay();
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < monthTotalDay; i++) {
			Record r = new Record();
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date eachDayOfThisMonth = c.getTime();
			int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
			r.spend = daySpend;
			result.add(r);
		}
		return result;
	}

}

