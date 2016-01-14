package com.xyan.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangming
 * @description ServletContext 放置请求和相应的 容器
 * @since ctreated at 2015年12月8日 下午1:52:06
 * @update wangming modified at 2015年12月8日 下午1:52:06
 */
public class ServletContext {
	
	/**
	 * 请求
	 */
	private static ThreadLocal<HttpServletRequest> req=new ThreadLocal<>();
	
	public static void setRequest(HttpServletRequest req){
		ServletContext.req.set(req);
	}
	public static HttpServletRequest getRequest(){
		return req.get();
	}
	public static void removeRequest(){
		req.remove();
	}
	
	/**
	 * 响应
	 */
	private static ThreadLocal<HttpServletResponse> resp=new ThreadLocal<>();
	
	public static void setResponse(HttpServletResponse resp){
		ServletContext.resp.set(resp);
	}
	
	public static HttpServletResponse getResponse(){
		return resp.get();
	}
	
	public static void removeResponse(){
		resp.remove();
	}
}
