package com.xyan.frame.security.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyan.frame.base.web.ResponseModel;
import com.xyan.frame.security.SecureUtil;
import com.xyan.frame.security.model.UserModel;
import com.xyan.frame.security.service.UserService;
import com.xyan.frame.security.web.util.SessionUtil;
import com.xyan.frame.util.VerifyCodeUtils;

@Controller
@RequestMapping("user")
public class UserController {

	protected Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;// 用户

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request,Model model) {
		 SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		 String url=savedRequest.getRequestUrl();
		 model.addAttribute("backURL", url);
		 logger.warn("登陆之前的url是："+url);
		return "user/login";
	}
	
	@RequestMapping(value = "loginCode", method = RequestMethod.GET)
	public void loginCode(HttpServletRequest request,HttpServletResponse response) {
		 SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		 String url=savedRequest.getRequestUrl();
		 logger.warn("登陆之前的url是："+url);
		try {
			String loginCode=VerifyCodeUtils.generateVerifyCode(4);
			SessionUtil.getSession().setAttribute(SessionUtil.LOGIN_CODE, loginCode);
			VerifyCodeUtils.outputImage(200, 80, response.getOutputStream(), loginCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel login(UserModel user, String code,HttpServletRequest request) {
		ResponseModel responseModel = new ResponseModel();
		/*
		 * 1、验证码
		 */
		String sessionCode=SessionUtil.getSession().getAttribute(SessionUtil.LOGIN_CODE).toString();
		if(!sessionCode.equalsIgnoreCase(code)){
			responseModel.setMessage("验证码输入错误！");
		}else{
			/*
			 * 2.shiro登录验证
			 */
			responseModel = shiroLogin(user, code);
		}
		/*
		 * 3.设置回调链接 如果是空的，返回首页
		 */
		System.out.println(request.getHeader("refer"));
		logger.warn("LoginController login end............................");
		return responseModel;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		Subject user = SecurityUtils.getSubject();
		user.logout();
		return "index";
	}

	/**
	 * @Title: shiroLogin
	 * @Description: shiro验证登录
	 * @param @param vo
	 * @param @return 设定文件
	 * @return ResponseEntity 返回类型
	 * @throws
	 */
	protected ResponseModel shiroLogin(UserModel vo, String code) {
		logger.warn("shiroLogin start ..........");
		ResponseModel responseModel = new ResponseModel();
		UsernamePasswordToken token = null;
		try {
			Subject user = SecurityUtils.getSubject();

			UserModel dbUser = userService.getUser(vo.getLoginName());
			// 前台已经对密码进行了一次MD5加密，后台需要加上盐值再次MD5加密比较
			vo.setPassword(SecureUtil.md5Hex(vo.getPassword()
					+ dbUser.getSalt()));

			token = new UsernamePasswordToken(vo.getLoginName(),
					vo.getPassword());
			user.login(token);
			responseModel.setSuccess(true).setLogin(true).setMessage("登陆成功！");
			UserModel userVo = (UserModel) SessionUtil.getShiroSessionUser();
			SessionUtil.setSession(SessionUtil.LOGIN_USER, userVo);
		} catch (Exception ex) {
			//System.out.println(cause.getMessage());
			responseModel.setSuccess(false).setLogin(false).setReturnCode("200");
			if (ex instanceof IncorrectCredentialsException) {
				responseModel.setMessage("密码错误！");
			}else if(ex instanceof NullPointerException){
				responseModel.setMessage("用户名错误！");
			}else {
				responseModel.setMessage("系统故障，请稍后再试");
			}
		} finally {
			if (token != null)
				token.clear();
		}
		logger.warn("shiroLogin end ..........");
		return responseModel;
	}
}
