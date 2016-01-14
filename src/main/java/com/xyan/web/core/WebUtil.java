package com.xyan.web.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.xyan.api.model.UserModel;
import com.xyan.core.config.ApplicationConfig;

/**
 * @author wangming
 * @description web工具类
 * @since 创建于 2015年11月27日 上午11:03:34
 * @update wangming修改于 2015年11月27日 上午11:03:34
 */
public final class WebUtil {
	
	/**
	 * @Author:wangming
	 * @Description:当前是否管理员登录
	 * @return
	 * @since 2016年1月12日 下午3:18:50
	 */
	public static boolean isAdmin(){
		UserModel user=getLoginUser();
		if(user==null){
			return false;
		}
		return ApplicationConfig.ADMIN_NAME.equals(user.getLoginName());
	}
	
	/***
	 * @Author:wangming
	 * @Description:获得登录人
	 * @param request
	 * @return
	 * @since 2015年11月27日 上午10:12:38
	 */
	public static UserModel getLoginUser(HttpServletRequest request){
		return (UserModel) request.getSession().getAttribute(WebConstants.LOGIN_USER);
	}
	
	/**
	 * @Author:wangming
	 * @Description:获得登录人
	 * @return
	 * @since 2015年12月11日 上午10:26:55
	 */
	public static UserModel getLoginUser(){
		HttpServletRequest request =ServletContext.getRequest();
		return getLoginUser(request);
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:设置当前登录人
	 * @param request
	 * @param user
	 * @since 2015年11月27日 上午11:03:53
	 */
	public static void setLoginUser(HttpServletRequest request,UserModel user){
		request.getSession().setAttribute(WebConstants.LOGIN_USER,user);
	}
	
	/**
	 * @Author:wangming
	 * @Description:设置当前登陆人，使用拦截器中的请求
	 * @param user
	 * @since 2015年12月1日 下午3:07:33
	 */
	public static void setLoginUser(UserModel user){
		HttpServletRequest request =ServletContext.getRequest();
		setLoginUser(request, user);
	}
	
	/***
	 * @Author:wangming
	 * @Description:移除登陆人
	 * @since 2015年12月1日 下午3:11:33
	 */
	public static void removeLoginUser(){
		HttpServletRequest request =ServletContext.getRequest();
		removeLoginUser(request);
	}
	
	/**
	 * @Author:wangming
	 * @Description:移除登陆人
	 * @param request
	 * @since 2015年12月1日 下午3:11:50
	 */
	public static void removeLoginUser(HttpServletRequest request){
		request.getSession().removeAttribute(WebConstants.LOGIN_USER);
	}
	/**
	 * @Author:wangming
	 * @Description:检查是否登录
	 * @param request 请求
	 * @return
	 * @since 2015年11月27日 上午10:07:46
	 */
	public static boolean isLogin(HttpServletRequest request) {
		UserModel user=(UserModel) request.getSession().getAttribute(WebConstants.LOGIN_USER);
		if(user==null){
			return false;
		}
		if(StringUtils.isBlank(user.getUserName())){
			return false;
		}
		return user==null;
	}
	
	/**
	 * @Author:wangming
	 * @Description:判断当前是否登录
	 * @return
	 * @since 2015年12月1日 下午3:09:33
	 */
	public static boolean isLogin(){
		HttpServletRequest request=ServletContext.getRequest();
		UserModel user=(UserModel) request.getSession().getAttribute(WebConstants.LOGIN_USER);
		if(user==null){
			return false;
		}
		if(StringUtils.isBlank(user.getUserName())){
			return false;
		}
		return user!=null;
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:作用域设置键值
	 * @param name 键
	 * @param value 值
	 * @param rank 范围 2代表session 3代表全局，其它则是request
	 * @since 2015年12月3日 上午10:06:39
	 */
	public static void setAttribute(String name,Object value,int rank){
		HttpServletRequest request=ServletContext.getRequest();
		switch (rank) {
		case 2:
			request.getSession().setAttribute(name, value);
			break;
		case 3:
			request.getSession().getServletContext().setAttribute(name, value);
			break;
		default:
			request.setAttribute(name, value);
			break;
		}
	}
	
	/**
	 * @Author:wangming
	 * @Description:移除作用域属性
	 * @param name 属性名
	 * @param rank 范围 2session 3 全局 其它request
	 * @since 2015年12月11日 上午9:51:09
	 */
	public static void removeAttribute(String name,int rank){
		HttpServletRequest request=ServletContext.getRequest();
		switch (rank) {
		case 2:
			request.getSession().removeAttribute(name);
			break;
		case 3:
			request.getSession().getServletContext().removeAttribute(name);
			break;
		default:
			request.removeAttribute(name);
			break;
		}
	}
	
	/**
	 * @Author:wangming
	 * @Description:按从小到大的范围从作用域取值
	 * @param name 键
	 * @return
	 * @since 2015年12月3日 上午10:11:02
	 */
	public static Object getAttribute(String name){
		Object value=null;
		HttpServletRequest request=ServletContext.getRequest();
		value=request.getAttribute(name);
		if(value==null||StringUtils.isBlank(value.toString())){
			value=request.getSession().getAttribute(name);
			if(value==null||StringUtils.isBlank(value.toString())){
				value=request.getSession().getServletContext().getAttribute(name);
			}
		}
		return value;
	}
	
	/**
	 * @Author:wangming
	 * @Description:从作用域取值
	 * @param name 属性名
	 * @param rank 范围
	 * @return
	 * @since 2015年12月11日 上午10:25:54
	 */
	public static Object getAttribute(String name,int rank){
		Object value=null;
		HttpServletRequest request=ServletContext.getRequest();
		switch (rank) {
		case 2:
			value=request.getSession().getAttribute(name);
			break;
		case 3:
			value=request.getSession().getServletContext().getAttribute(name);
			break;
		default:
			value=request.getAttribute(name);
			break;
		}
		return value;
	}
	
	/**
	 * @Author:wangming
	 * @Description:按从小到大的范围从作用域取值
	 * @param request 请求
	 * @param name 属性名
	 * @return
	 * @since 2015年12月11日 上午10:26:31
	 */
	public static Object getAttribute(HttpServletRequest request,String name){
		Object value=null;
		value=request.getAttribute(name);
		if(value==null||StringUtils.isBlank(value.toString())){
			value=request.getSession().getAttribute(name);
			if(value==null||StringUtils.isBlank(value.toString())){
				value=request.getSession().getServletContext().getAttribute(name);
			}
		}
		return value;
	}
}
