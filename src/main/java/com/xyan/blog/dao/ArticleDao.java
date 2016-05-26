package com.xyan.blog.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import com.xyan.frame.base.dao.GenericDao;
import com.xyan.frame.feature.mybatis.annotation.MyBatisRepository;


import com.xyan.blog.model.ArticleModel;

/**
 * @description 文章（博客） --dao层接口
 * @author wangming
 * @Date:2016-05-17 13:44:39
 */
@MyBatisRepository
public interface ArticleDao extends GenericDao<ArticleModel, Long>{

	
}