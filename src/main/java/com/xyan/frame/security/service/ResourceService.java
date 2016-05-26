package com.xyan.frame.security.service;

import java.util.List;

import com.xyan.frame.base.service.GenericService;
import com.xyan.frame.security.model.ResourceModel;
import com.xyan.frame.security.model.RoleModel;

public interface ResourceService extends GenericService<ResourceModel, Long>{
	
	public List<ResourceModel> selectUserResource(Long userId);
	
	public boolean check(String url,Long userId);

	public List<String> queryRoleResource(List<RoleModel> roles);
}
