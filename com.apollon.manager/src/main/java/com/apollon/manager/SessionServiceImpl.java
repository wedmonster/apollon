package com.apollon.manager;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service("sessionService")
public class SessionServiceImpl implements SessionService{

	public User getLoginUser() {
		// TODO Auto-generated method stub
		User loginUser = (User)RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		if(loginUser == null) return User.GUEST;
		return loginUser;
	}

	public void setAttribute(String name, Object object) {
		// TODO Auto-generated method stub
		RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
		
	}

	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
		
	}

}
