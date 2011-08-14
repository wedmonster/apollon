package com.apollon.manager.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
import com.apollon.manager.HomeService;
import com.apollon.manager.SessionService;
import com.apollon.manager.User;

@Controller
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@Autowired
	private SubjectService subjectService;
	
	
	@RequestMapping(value="/{user_name}/subject.main", method=RequestMethod.GET)
	public ModelAndView subject_main(@PathVariable String user_name) {
		logger.info("Welcome subject_list!");
		logger.info("user name = "+user_name);
		
		//session_check
		
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("subject_main");
		if(loginUser == null)	{
			RedirectView redirectView = new RedirectView("/", true);
			model.setView(redirectView);
			return model;
		}
		
		return model;
	}
	
	@RequestMapping(value="/{user_name}/subject.list", method=RequestMethod.GET)
	public ModelAndView subject_list(@PathVariable String user_name) {
		logger.info("Welcome subject_list!");
		logger.info("user name = "+user_name);
		
		//session_check
		
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("subject_list");
		if(loginUser == null)	{
			RedirectView redirectView = new RedirectView("/", true);
			model.setView(redirectView);
			return model;
		}
		HashMap<String, String> paraHm = new HashMap<String, String>();
		paraHm.put("u_id", loginUser.getUser_id());
		
		ArrayList<HashMap> termArray = subjectService.selectTerms(paraHm);
		ArrayList<HashMap> subjectArray = subjectService.selectSubjects(paraHm);
		ArrayList<HashMap> titleArray = subjectService.selectSubjectOrderByTitle(paraHm);
		
		Map<String, ArrayList> resultMap = new HashMap();
		resultMap.put("terms", termArray);
		resultMap.put("subjects", subjectArray);
		resultMap.put("title", titleArray);
		
		
		model.addObject("result", resultMap);
		//resultArray.si
		
		return model;
	}
	
	@RequestMapping(value="/{user_name}/{s_id}/subject.summary", method=RequestMethod.GET)
	public ModelAndView subject_summary(@PathVariable String user_name, @PathVariable String s_id){
		logger.info("Welcome subject_summary!");
		logger.info("user name = "+user_name);
		logger.info("s_id = "+s_id);
				
		User loginUser = sessionService.getLoginUser();
		//logger.info("session = "+loginUser.getUser_name());
		ModelAndView model = new ModelAndView("subject_summary");
		if(loginUser == null)	{
			RedirectView redirectView = new RedirectView("/", true);
			model.setView(redirectView);
			return model;
		}
		HashMap paraHm = new HashMap();
		paraHm.put("u_id", loginUser.getUser_id());
		paraHm.put("s_id", s_id);
		HashMap hm = subjectService.selectSubjectInformation(paraHm);
		HashMap extra = subjectService.selectSbuejctExtraInformation(paraHm);
		model.addObject("s_name", hm.get("title"));
		model.addObject("term", hm.get("term"));
		model.addObject("extra", extra);
		model.addObject("s_id", s_id);
		return model;
	}
}
