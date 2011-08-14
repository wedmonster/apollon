package com.apollon.manager;

import java.util.ArrayList;
import java.util.HashMap;

public interface HomeService {
	public ArrayList testSql(HashMap paraHm);

	public User login(HashMap<String, String> paraHm);
	public Integer join(HashMap<String, String> paraHm);
}
