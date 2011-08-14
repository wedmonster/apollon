/**
 * 
 */
package com.apollon.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author kotaro
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/ibatis/dao-context.xml"})
public class TestSQL {
	@Autowired
	 private SqlMapClientTemplate sqlMapClientTemplate;
	
	@Test
	public void test(){
		HashMap para = new HashMap();
		para.put("user_name", "wedmonster");
					
		ArrayList list = (ArrayList)sqlMapClientTemplate.queryForList("testSqlFromDB", para);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()){
			HashMap tmp = (HashMap) it.next();
			System.out.println(tmp.get("user_id"));
			System.out.println(tmp.get("user_name"));
			System.out.println(tmp.get("user_password"));
		}
	}
}
