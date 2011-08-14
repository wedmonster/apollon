package com.apollon.manager.subject.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public ArrayList selectTest(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectTest", paraHm);
	}

	public ArrayList selectRemaindTests(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlMapClientTemplate.queryForList("selectRemaindTests", paraHm);
	}
}
