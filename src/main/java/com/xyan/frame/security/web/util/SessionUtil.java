package com.xyan.frame.security.web.util;

import com.xyan.frame.security.model.UserModel;



import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;


/**
 * @Description  Session工具类
 * @author wangming
 * @since 2016年3月8日 下午12:17:18
 */
public class SessionUtil {
	
	public static final String LOGIN_CODE="loginCode";
	public static final String LOGIN_USER = "currentUser";


	 /**
	  * @Author:wangming
	  * @Description:获取当前Session
	  * @param request
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static Session getSession(HttpServletRequest request) {
		return  getSession();
	}
	
	 /**
	  * @Author:wangming
	  * @Description:获取当前Session
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		return  subject.getSession();
	}
	

	
	 /**
	  * @Author:wangming
	  * @Description:获取当前用户
	  * @param request
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static UserModel getSessionUser(HttpServletRequest request) {
		return getShiroSessionUser(request);
	}
	
	/**
	* @Title: getSessionUser 
	* @Description:  shiro方式获取登录用户信息
	* @param @param request
	* @param @return    设定文件 
	* @return Contact    返回类型 
	* @throws
	 */
	public static void setSessionUser(HttpServletRequest request,UserModel currentUser) {
		setShiroSessionUser(request, currentUser);
	}

	
	 /**
	  * @Author:wangming
	  * @Description:获取当前用户
	  * @param request
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static UserModel getShiroSessionUser(HttpServletRequest request) {
		UserModel currentUser = (UserModel)request.getSession().getAttribute(LOGIN_USER);
		return currentUser;
	}
	
	
	 /**
	  * @Author:wangming
	  * @Description:获取ShiroSession中的用户
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static UserModel getShiroSessionUser() {
		Subject subject = SecurityUtils.getSubject();
		UserModel currentUser = null;
		if (subject != null) {
			PrincipalCollection principalCollection = subject.getPrincipals();
			if (principalCollection != null && !principalCollection.isEmpty()) {
				currentUser = (UserModel) principalCollection .getPrimaryPrincipal();
			}
		}
		return currentUser;
	}
	
	/**
	* @Title: getShiroSessionUser 
	* @Description: shiro方式获取登录用户信息
	* @param @return    设定文件 
	* @return Contact    返回类型 
	* @throws
	 */
	public static void setShiroSessionUser(HttpServletRequest request,UserModel currentUser) {
		request.getSession().setAttribute(LOGIN_USER, currentUser);
	}
	
	 /**
	  * @Author:wangming
	  * @Description:设置session
	  * @param key
	  * @param value
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
	
	
	 /**
	  * @Author:wangming
	  * @Description:获取ShiroSession中的用户
	  * @return
	  * @since 2015年12月2日 下午4:10:21
	  */
	public static UserModel getSessionUser(){
		Subject subject = SecurityUtils.getSubject();
		UserModel currentUser = null;
		if (subject != null) {
			PrincipalCollection principalCollection = subject.getPrincipals();
			if (principalCollection != null && !principalCollection.isEmpty()) {
				currentUser = (UserModel) principalCollection
						.getPrimaryPrincipal();
			}
		}
		return currentUser;
	}
}
