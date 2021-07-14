package com.service;

import java.util.List;

import com.dao.RecordDAO;
import com.entity.Record;
import com.gui.page.SpendPage;
import com.util.DateUtil;

public class SpendService {

	public SpendPage getSpendPage() {
		RecordDAO dao = new RecordDAO();
		// ��������
		List<Record> thisMonthRecords = dao.listThisMonth();
		// ��������
		List<Record> todayRecords = dao.listToday();
		// ����������
		int thisMonthTotalDay = dao.getTotal();
		int monthSpend = 0;// ��������
		int todaySpend = 0;// ��������
		int avgSpendPerDay = 0;// �վ�����
		int monthAvailable = 0;// ���¿���
		int dayAvgAvailable = 0;// ÿ�տ���
		int monthLeftDay = 0;// ����ʣ������
		int usagePercentage = 0;//// ʹ�ñ���
		// Ԥ��
		int monthBudget = new ConfigService().getIntBudget();
		// ͳ�Ʊ�������
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}
		// ͳ�ƽ�������
		for (Record record : todayRecords) {
			todaySpend += record.getSpend();
		}
		// �����վ�����
		avgSpendPerDay = monthSpend / thisMonthTotalDay;
		// ���㱾��ʣ��
		monthAvailable = monthBudget - monthSpend;
		// ������ĩ
		monthLeftDay = DateUtil.thisMonthLeftDay();
		// �����վ�����
		dayAvgAvailable = monthAvailable / monthLeftDay;
		// ����ʹ�ñ���
		usagePercentage = monthSpend * 100 / monthBudget;
		 //����SpendPage����
		return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
				usagePercentage);
	}

}
