package com.apollon.manager;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeService homeService;
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		logger.info("Welcome intro!");
		return "intro";
	}
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(String user, String user_password) {
		logger.info("Welcome login!");
		HashMap<String, String> paraHm = new HashMap<String, String>();
		paraHm.put("user_name", user);
		paraHm.put("user_password", user_password);
		User loginUser = (User) homeService.login(paraHm);
		RedirectView redirectView;
		if(loginUser!=null) {
			sessionService.setAttribute("user", loginUser);
			redirectView = new RedirectView(loginUser.getUser_name()+"/subject.main", true);
		}
		else  redirectView = new RedirectView("login.fail", true);
			
		return new ModelAndView(redirectView);
	}
	
	@RequestMapping(value="/login.fail", method=RequestMethod.GET)
	public String login_fail() {
		logger.info("Welcome login_fail!");
		return "login_fail";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		logger.info("Welcome join!");
		return "join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join_do(String user, String user_password) {
		logger.info("Welcome join_do!");
		HashMap<String, String> paraHm = new HashMap<String, String>();
		paraHm.put("user_name", user);
		paraHm.put("user_password", user_password);
		Integer result = null;
		try{
			result = homeService.join(paraHm);
		}catch(org.springframework.dao.DuplicateKeyException e){
			
		}
		
		RedirectView redirectView;
		if(result!=null)	redirectView = new RedirectView("");		
		else redirectView = new RedirectView("join"); 
		
		return new ModelAndView(redirectView);
	}
	
}

