package com.apollon.manager.subject.homework;

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
import com.apollon.manager.subject.lecture.LectureService;

@Controller
public class HomeworkController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private HomeworkService homeworkService;
	
	
	@RequestMapping(value="/{user_name}/{s_id}/homework.list", method=RequestMethod.GET)
	public ModelAndView homework_list(@PathVariable String user_name, @PathVariable String s_id){
		logger.info("Welcome lecture_list!");
		logger.info("user name = "+user_name);
		logger.info("s_id = "+s_id);
				
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("homework/list");
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
		
		ArrayList deadLine = homeworkService.selectDeadlineDate(paraHm);
		ArrayList homework = homeworkService.selectHomeworkOrderByWriteDate(paraHm);
		
		model.addObject("deadLine", deadLine);
		model.addObject("homework", homework);
		
		return model;
	}
	
}
