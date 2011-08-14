package com.apollon.manager;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HomeServiceImpl implements HomeService{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	public ArrayList testSql(HashMap paraHm) {
		// TODO Auto-generated method stub
		return null;
	}
	public User login(HashMap<String, String> paraHm) {
		// TODO Auto-generated method stub
		return (User) sqlMapClientTemplate.queryForObject("login", paraHm);
	}
	public Integer join(HashMap<String, String> paraHm) {
		// TODO Auto-generated method stub
		return (Integer)sqlMapClientTemplate.insert("join", paraHm);
		
	}

}
