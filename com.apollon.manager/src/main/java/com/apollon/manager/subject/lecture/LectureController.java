package com.apollon.manager.subject.lecture;

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

@Controller
public class LectureController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private HomeworkService homeworkService;
	
	@RequestMapping(value="/{user_name}/{s_id}/lecture.list", method=RequestMethod.GET)
	public ModelAndView lecture_list(@PathVariable String user_name, @PathVariable String s_id){
		logger.info("Welcome lecture_list!");
		logger.info("user name = "+user_name);
		logger.info("s_id = "+s_id);
				
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("lecture_list");
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
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<HashMap<String, String>> lectureResult = lectureService.selectLectureInformation(paraHm);
		
		for(HashMap<String, String> tmp : lectureResult){			
			paraHm = new HashMap();
			paraHm.put("u_id", loginUser.getUser_id());
			paraHm.put("l_id", tmp.get("l_id"));
			paraHm.put("lecture_date", tmp.get("lecture_date"));
			ArrayList newHomework = homeworkService.selectHomeworkByLid(paraHm);
			ArrayList handInHomework = homeworkService.selectHomeworkByDeadlineDate(paraHm);
			HashMap<String, Object> totalResult = new HashMap();
			totalResult.put("lecture", tmp);
			totalResult.put("newHomework", newHomework);
			totalResult.put("handInHomework", handInHomework);
			resultList.add(totalResult);			
		}
		
		model.addObject("result", resultList);
		
		
		return model;
	}
	
	@RequestMapping(value="/{user_name}/{s_id}/lecture.insert", method=RequestMethod.GET)
	public ModelAndView lecture_insert(@PathVariable String user_name, @PathVariable String s_id){
		logger.info("Welcome lecture_insert!");
		logger.info("user name = "+user_name);
		logger.info("s_id = "+s_id);
				
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("lecture/lecture_insert");
		if(loginUser == null)	{
			RedirectView redirectView = new RedirectView("/", true);
			model.setView(redirectView);
			return model;
		}
		
		return model;
	}
	
}
