package com.xyan.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.xyan.api.mapper.UserMapper;
import com.xyan.api.model.UserModel;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.core.util.ApplicationUtils;
import com.xyan.core.util.SecureUtil;
import com.xyan.service.UserService;
import com.xyan.web.core.ResponseModel;
import com.xyan.web.core.WebUtil;


/**
 * @author wangming
 * @description  user service implements
 * @since ctreated at 2015年12月3日 上午9:15:19
 * @update wangming modified at 2015年12月3日 上午9:15:19
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserModel, String> implements UserService {

    @Resource
    private UserMapper userMapper;
	@Override
	public GenericDao<UserModel, String> getDao() {
		return userMapper;
	}

	@Override
	public ResponseModel login(UserModel user, HttpServletRequest request,String loginKey) {
		ResponseModel respn=new ResponseModel();
		user.setPassword(SecureUtil.md5(user.getPassword()));
		List<UserModel> list=userMapper.selectByExample(user.toMap());
		if(CollectionUtils.isEmpty(list)){
			respn.setMessage(ApplicationUtils.getResourceValue("login.error.usernameORpassword", request.getLocale()));
		}else if(list.size()>1){
			respn.setMessage("登录故障，请稍后再试或联系站主");
		}else{
			user=list.get(0);
			user.setLastLoginIp(ApplicationUtils.getIpAddr(request));
			user.setLastLoginDate(new Date());
			userMapper.update(user);
			WebUtil.setLoginUser(request, user);
			String token=SecureUtil.md5(user.getId()+loginKey);
			WebUtil.setAttribute("token", token, 2);
			respn.setLogin(true)
				.setSuccess(true)
				.setStr1(token)
				.setMessage("登录成功");
		}
		return respn;
	}

}
