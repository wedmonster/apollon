package com.apollon.manager.subject.lecture;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LectureServiceImpl implements LectureService{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public ArrayList selectLectureInformation(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectLectureInformation", paraHm);
	}

}
