package com.xyan.web.Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyan.core.config.ApplicationConfig;

public class SessionListener implements HttpSessionListener {
	private final Logger log = LoggerFactory.getLogger(SessionListener.class);  
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//同时在线人数统计
		log.warn("有人进入系统了。。。。");
		ApplicationConfig.increaseOnlineNum();//同时在线的人数增加
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		log.warn("有人离开系统了。。。。");
		ApplicationConfig.decreaseOnlineNum();
	}

}
