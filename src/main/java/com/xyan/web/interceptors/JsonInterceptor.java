package com.xyan.web.interceptors;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class JsonInterceptor implements WebRequestInterceptor {

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
	}

	@Override
	public void preHandle(WebRequest request) throws Exception {

	}

}
