package com.xyan.service;

import com.xyan.api.model.CommentModel;
import com.xyan.core.generic.GenericService;

/**
 * 博客业务接口
 * @author wangming
 * @since 2015年11月12日
 **/
public interface CommentService extends GenericService<CommentModel, String> {
	public CommentModel insertComment(CommentModel commentModel);
}
