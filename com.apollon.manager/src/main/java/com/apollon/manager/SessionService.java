package com.apollon.manager;

public interface SessionService {
	public User getLoginUser();
	public void setAttribute(String name, Object object);
	public void removeAttribute(String name);
}
