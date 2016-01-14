package com.xyan.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyan.api.model.UserModel;
import com.xyan.core.util.ApplicationUtils;
import com.xyan.core.util.SecureUtil;
import com.xyan.service.UserService;
import com.xyan.web.core.BaseController;
import com.xyan.web.core.ResponseModel;
import com.xyan.web.core.WebConstants;
import com.xyan.web.core.WebUtil;

/**
 * @author wangming
 * @description (描述这个类的用途)
 * @since 创建于 2015年11月27日 下午1:02:11
 * @update wangming修改于 2015年11月27日 下午1:02:11
 */
@Controller
@RequestMapping(value="user")
public class UserController extends BaseController implements WebConstants{
	
	private static String viewPath="user/";
	
	@Autowired
	private UserService service;
	
	/**
	 * @Author:wangming
	 * @Description:登录
	 * @param user 用户
	 * @param request 请求
	 * @return
	 * @since 2015年11月27日 上午11:13:26
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public ResponseModel login(UserModel user,HttpServletRequest request,String loginCode){
		String reqLoginCode=(String) WebUtil.getAttribute(request,LOGIN_CODE);
		WebUtil.removeAttribute(LOGIN_CODE, 2);
		ResponseModel respn=new ResponseModel();
		if(reqLoginCode==null||!reqLoginCode.equalsIgnoreCase(loginCode)){
			respn.setMessage(ApplicationUtils.getResourceValue("login.error.code",request.getLocale()));
			return respn;
		}
		respn=service.login(user, request,SAFETY_LOGIN_KEY);
		return respn;
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:检查登录状态
	 * @param token 登录标记
	 * @param request
	 * @return
	 * @since 2015年11月27日 下午2:24:05
	 */
	@RequestMapping(value="checkLogin")
	@ResponseBody
	public ResponseModel checkLogin(String token,HttpServletRequest request,HttpServletResponse response){
		UserModel user=WebUtil.getLoginUser(request);
		ResponseModel respn=new ResponseModel();
		if(StringUtils.isBlank(token)){
			token=(String) WebUtil.getAttribute("token");
		}
		if(StringUtils.isBlank(token)||user==null){
			respn.setMessage("请登录");
		}else if(token.equals(SecureUtil.md5(user.getId()+SAFETY_LOGIN_KEY))){
			respn.setMessage("登录成功").setLogin(true).setSuccess(true);
		}else{
			respn.setMessage("请登录");
		}
		return respn;
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:进入登录页面
	 * @return
	 * @since 2015年11月27日 下午1:02:24
	 */
	@RequestMapping(value="toLogin")
	public String toLogin(){
		return viewPath+"login";
	}
	
	/**
	 * @Author:wangming
	 * @Description:退出登录
	 * @return
	 * @since 2015年11月27日 下午1:02:40
	 */
	@RequestMapping(value="out")
	@ResponseBody
	public ResponseModel logOut(){
		ResponseModel respn=new ResponseModel();
		return respn;
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:进入注册
	 * @return
	 * @since 2015年11月27日 下午1:03:05
	 */
	@RequestMapping(value="toRegist")
	public String toRegist(){
		return viewPath+"regist";
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:注册
	 * @return
	 * @since 2015年11月27日 下午1:03:56
	 */
	@RequestMapping(value="regist")
	@ResponseBody
	public ResponseModel regist(){
		ResponseModel respn=new ResponseModel();
		return respn;
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:进入会员信息修改
	 * @return
	 * @since 2015年11月27日 下午1:04:44
	 */
	@RequestMapping(value="toUpdate")
	public String toUpdate(){
		return viewPath+"update";
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:会员信息修改
	 * @return
	 * @since 2015年11月27日 下午1:05:42
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public ResponseModel update(){
		ResponseModel respn=new ResponseModel();
		return respn;
	}
	
}
