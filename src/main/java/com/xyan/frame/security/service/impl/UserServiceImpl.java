package com.xyan.frame.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.base.service.impl.GenericServiceImpl;
import com.xyan.frame.base.web.ResponseModel;
import com.xyan.frame.security.dao.UserDao;
import com.xyan.frame.security.model.UserModel;
import com.xyan.frame.security.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserModel, Long> implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public GenericDao<UserModel, Long> getDao() {
		return userDao;
	}

	@Override
	public UserModel getUser(String loginName) {
		UserModel model=new UserModel();
		model.setLoginName(loginName);
		List<UserModel> list=userDao.selectByExample(model);
		if(list==null||list.size()<1){
			return null;
		}
		return list.get(0);
	}

	@Override
	public ResponseModel login(UserModel user) {
		return null;
	}

}
