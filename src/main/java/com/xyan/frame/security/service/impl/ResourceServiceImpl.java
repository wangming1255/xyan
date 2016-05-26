package com.xyan.frame.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.base.service.impl.GenericServiceImpl;
import com.xyan.frame.security.dao.ResourceDao;
import com.xyan.frame.security.model.ResourceModel;
import com.xyan.frame.security.model.RoleModel;
import com.xyan.frame.security.service.ResourceService;

@Service
public class ResourceServiceImpl extends GenericServiceImpl<ResourceModel, Long> implements ResourceService{

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public GenericDao<ResourceModel, Long> getDao() {
		return resourceDao;
	}

	@Override
	public List<ResourceModel> selectUserResource(Long userId) {
		return resourceDao.selectUserResource(userId);
	}

	@Override
	public boolean check(String url, Long userId) {
		if(userId==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<String> queryRoleResource(List<RoleModel> roles) {
		
		return resourceDao.queryRoleResource(roles);
	}
}
