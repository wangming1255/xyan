package com.xyan.frame.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.base.service.impl.GenericServiceImpl;
import com.xyan.frame.message.dao.MessageDao;
import com.xyan.frame.message.model.MessageModel;
import com.xyan.frame.message.service.MessageService;

/**
 *@Description： -- Servcie实现类
 *@Author：wangming
 *@Date:2016-04-28 10:07:41
 */
@Service
@Transactional
public class MessageServiceImpl extends GenericServiceImpl<MessageModel, Long> implements MessageService{

 	
	@Autowired
	private MessageDao  messageService;//
	
	
	@Override
	public GenericDao<MessageModel, Long> getDao() {
		return  messageService;
	}
}
