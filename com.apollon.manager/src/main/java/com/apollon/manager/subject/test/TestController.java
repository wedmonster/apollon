package com.apollon.manager.subject.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.apollon.manager.HomeController;
import com.apollon.manager.SessionService;
import com.apollon.manager.User;
import com.apollon.manager.subject.SubjectService;
import com.apollon.manager.subject.homework.HomeworkService;
import com.apollon.manager.subject.lecture.LectureService;

@Controller
public class TestController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private HomeworkService homeworkService;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/{user_name}/{s_id}/test.list", method=RequestMethod.GET)
	public ModelAndView test_list(@PathVariable String user_name, @PathVariable String s_id){
		logger.info("Welcome test_list!");
		logger.info("user name = "+user_name);
		logger.info("s_id = "+s_id);
				
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("test/list");
		if(loginUser == null)	{
			RedirectView redirectView = new RedirectView("/", true);
			model.setView(redirectView);
			return model;
		}
		
		HashMap paraHm = new HashMap();
		paraHm.put("u_id", loginUser.getUser_id());
		paraHm.put("s_id", s_id);
		HashMap hm = subjectService.selectSubjectInformation(paraHm);
		model.addObject("s_name", hm.get("title"));
		model.addObject("s_id", s_id);
		
		ArrayList remained = testService.selectRemaindTests(paraHm);
		ArrayList test = testService.selectTest(paraHm);
		model.addObject("remained", remained);
		model.addObject("test", test);
		return model;
	}
}
