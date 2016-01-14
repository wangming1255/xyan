package com.xyan.api.mapper;

import java.util.List;

import com.xyan.api.model.RoleModel;
import com.xyan.core.generic.GenericDao;

/**
 * 角色Dao 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:55:59
 **/
public interface RoleMapper extends GenericDao<RoleModel, String> {
    int countByExample(RoleModel example);

    int deleteByExample(RoleModel example);

    List<RoleModel> selectByExample(RoleModel example);

    RoleModel selectByPrimaryKey(Long id);

}