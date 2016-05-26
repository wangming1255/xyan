package com.xyan.frame.message.dao;

import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.feature.mybatis.annotation.MyBatisRepository;
import com.xyan.frame.message.model.MessageModel;

/**
 * @description  消息--dao层接口
 * @author wangming
 * @Date:2016-04-28 10:07:41
 */
@MyBatisRepository
public interface MessageDao extends GenericDao<MessageModel, Long>{

	
}