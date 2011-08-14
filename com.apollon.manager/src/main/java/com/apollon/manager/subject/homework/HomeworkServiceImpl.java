package com.apollon.manager.subject.homework;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public ArrayList selectHomeworkByLid(HashMap parahm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectHomeworkByLid", parahm);
	}

	public ArrayList selectHomeworkByDeadlineDate(HashMap parahm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectHomeworkByDeadlineDate", parahm);
	}

	public ArrayList selectDeadlineDate(HashMap parahm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectDeadlineDate", parahm);
	}

	public ArrayList selectHomeworkOrderByWriteDate(HashMap parahm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectHomeworkOrderByWriteDate", parahm);
	}

}
