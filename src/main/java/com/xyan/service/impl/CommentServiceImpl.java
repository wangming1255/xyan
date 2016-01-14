package com.xyan.service.impl;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyan.api.mapper.CommentMapper;
import com.xyan.api.model.CommentModel;
import com.xyan.api.model.UserModel;
import com.xyan.core.config.ApplicationConfig;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.service.CommentService;
import com.xyan.web.core.WebUtil;


/**
 * @author wangming
 * @description  implement the CommentService
 * @since create at  2015年12月1日 下午4:15:17
 * @update wangming modify at 2015年12月1日 下午4:15:17
 */
@Service
public class CommentServiceImpl extends GenericServiceImpl<CommentModel, String> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

	@Override
	public GenericDao<CommentModel, String> getDao() {
		return commentMapper;
	}

	@Override
	public int insert(CommentModel model) {
		UserModel user=WebUtil.getLoginUser();
		if(user!=null){
			model.setUserId(user.getId());
			model.setUserName(user.getUserName());
		}else{
			model.setUserName(ApplicationConfig.NO_LOGIN_USERNAME);
		}
		model.setCommentDate(new Date());
		return super.insert(model);
	}

	@Override
	public CommentModel insertComment(CommentModel model) {
		UserModel user=WebUtil.getLoginUser();
		if(user!=null){
			model.setUserId(user.getId());
			model.setUserName(user.getUserName());
		}else{
			model.setUserName(ApplicationConfig.NO_LOGIN_USERNAME);
		}
		model.setCommentDate(new Date());
		String id=UUID.randomUUID().toString();
		model.setId(id);
		super.insert(model);
		return commentMapper.selectByPrimaryKey(id);
	}
}
