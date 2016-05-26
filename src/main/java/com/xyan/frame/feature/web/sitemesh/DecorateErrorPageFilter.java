package com.xyan.frame.feature.web.sitemesh;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DecorateErrorPageFilter extends com.opensymphony.sitemesh.webapp.SiteMeshFilter{
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		super.doFilter(arg0, arg1, arg2);
	}
}