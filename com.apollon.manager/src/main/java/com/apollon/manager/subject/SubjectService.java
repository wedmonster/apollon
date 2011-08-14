package com.apollon.manager.subject;

import java.util.ArrayList;
import java.util.HashMap;

public interface SubjectService {
	public ArrayList<HashMap> selectTerms(HashMap paraHm);
	public ArrayList<HashMap> selectSubjects(HashMap paraHm);
	public ArrayList<HashMap> selectSubjectOrderByTitle(HashMap paraHm);
	public HashMap selectSubjectInformation(HashMap paraHm);
	public HashMap selectSbuejctExtraInformation(HashMap paraHm);
}
