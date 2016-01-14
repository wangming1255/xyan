package com.xyan.service;

import javax.servlet.http.HttpServletRequest;

import com.xyan.api.model.UserModel;
import com.xyan.core.generic.GenericService;
import com.xyan.web.core.ResponseModel;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService extends GenericService<UserModel, String> {
	/**登录*/
	public ResponseModel login(UserModel user,HttpServletRequest request,String loginKey);
}
