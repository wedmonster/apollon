package com.apollon.manager.subject;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public ArrayList<HashMap> selectTerms(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList<HashMap>) sqlMapClientTemplate.queryForList("selectTerms", paraHm);
	}

	public ArrayList<HashMap> selectSubjects(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList<HashMap>) sqlMapClientTemplate.queryForList("selectSubjects", paraHm);
	}

	public ArrayList<HashMap> selectSubjectOrderByTitle(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (ArrayList<HashMap>) sqlMapClientTemplate.queryForList("selectSubjectsOrderByTitle", paraHm);
	}

	public HashMap selectSubjectInformation(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (HashMap)sqlMapClientTemplate.queryForObject("selectSubjectInformation", paraHm);
	}

	public HashMap selectSbuejctExtraInformation(HashMap paraHm) {
		// TODO Auto-generated method stub
		return (HashMap)sqlMapClientTemplate.queryForObject("selectSubjectExtraInformation", paraHm);
	}
	
	
}
