package com.xyan.api.mapper;

import java.util.List;

import com.xyan.api.model.UserModel;
import com.xyan.core.generic.GenericDao;

/**
 * 用户Dao接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:49:57
 **/
public interface UserMapper extends GenericDao<UserModel , String> {

    List<UserModel> selectLikeExample(java.util.HashMap<String,Object> map);

}