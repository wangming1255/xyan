package com.xyan.frame.security.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener{

	@Override
	public void onStart(Session session) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>进入系统");
		System.err.println(session.getHost());
	}

	@Override
	public void onStop(Session session) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>离开系统");
		System.err.println(session.getAttributeKeys());
	}

	@Override
	public void onExpiration(Session session) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>超时");
		System.err.println(session.getAttributeKeys());
	}

}
