package com.xyan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyan.api.mapper.RoleMapper;
import com.xyan.api.model.RoleModel;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.service.RoleService;

/**
 * 角色Service实现类
 * @author wangming
 * @since 2015年11月12日
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<RoleModel, String> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<RoleModel, String> getDao() {
        return roleMapper;
    }

}
