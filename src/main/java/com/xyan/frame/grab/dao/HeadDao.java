package com.xyan.frame.grab.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.feature.mybatis.annotation.MyBatisRepository;


import com.xyan.frame.grab.model.HeadModel;

/**
 * @description  --dao层接口
 * @author wangming
 * @Date:2016-04-14 15:45:43
 */
@MyBatisRepository
public interface HeadDao extends GenericDao<HeadModel, Long>{

	
}