package com.service;

import java.util.List;

import com.dao.RecordDAO;
import com.entity.Record;
import com.gui.page.SpendPage;
import com.util.DateUtil;

public class SpendService {

	public SpendPage getSpendPage() {
		RecordDAO dao = new RecordDAO();
		// 本月数据
		List<Record> thisMonthRecords = dao.listThisMonth();
		// 今日数据
		List<Record> todayRecords = dao.listToday();
		// 本月总天数
		int thisMonthTotalDay = dao.getTotal();
		int monthSpend = 0;// 本月消费
		int todaySpend = 0;// 今日消费
		int avgSpendPerDay = 0;// 日均消费
		int monthAvailable = 0;// 本月可用
		int dayAvgAvailable = 0;// 每日可用
		int monthLeftDay = 0;// 本月剩余天数
		int usagePercentage = 0;//// 使用比例
		// 预算
		int monthBudget = new ConfigService().getIntBudget();
		// 统计本月消费
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}
		// 统计今日消费
		for (Record record : todayRecords) {
			todaySpend += record.getSpend();
		}
		// 计算日均消费
		avgSpendPerDay = monthSpend / thisMonthTotalDay;
		// 计算本月剩余
		monthAvailable = monthBudget - monthSpend;
		// 距离月末
		monthLeftDay = DateUtil.thisMonthLeftDay();
		// 计算日均可用
		dayAvgAvailable = monthAvailable / monthLeftDay;
		// 计算使用比例
		usagePercentage = monthSpend * 100 / monthBudget;
		 //生成SpendPage对象
		return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
				usagePercentage);
	}

}
