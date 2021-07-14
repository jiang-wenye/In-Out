package com.service;

import java.util.Date;
import com.dao.RecordDAO;
import com.entity.Category;
import com.entity.Record;

public class RecordService {
	RecordDAO recordDao  = new RecordDAO();
	public void add(int spend,Category c,String comment,Date date) {
		Record r = new Record();
		r.spend=spend;
		r.cid=c.id;
		r.comment=comment;
		r.date=date;
		recordDao.add(r);
	}
}

