package com.xyan.blog.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.base.service.impl.GenericServiceImpl;
import com.xyan.blog.service.ArticleService;
import com.xyan.blog.model.ArticleModel;
import com.xyan.blog.dao.ArticleDao;

/**
 *@Description：文章（博客） -- Servcie实现类
 *@Author：wangming
 *@Date:2016-05-16 10:32:51
 */
@Service
@Transactional
public class ArticleServiceImpl extends GenericServiceImpl<ArticleModel, Long> implements ArticleService{

 	
	@Autowired
	private ArticleDao  articleDao;//文章（博客）
	
	
	@Override
	public GenericDao<ArticleModel, Long> getDao() {
		return  articleDao;
	}
}
