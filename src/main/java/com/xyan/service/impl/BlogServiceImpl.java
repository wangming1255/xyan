package com.xyan.service.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyan.api.mapper.BlogMapper;
import com.xyan.api.model.BlogModel;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.service.BlogService;

/**
 * 博客Service实现类
 * @author wangming	
 * @since 2015年11月12日
 */
@Service
public class BlogServiceImpl extends GenericServiceImpl<BlogModel, String> implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public GenericDao<BlogModel, String> getDao() {
        return blogMapper;
    }
    
    @Override
    public int batchUpdateStatus(Map<String,Object> map){
    	return blogMapper.batchUpdateStatus(map);
    };
    
    @Override
    public int insert(BlogModel model) {
    	model.setStatus("1");//默认所有人可见
    	model.setCreateTime(new Date());
    	model.setUpdateDate(new Date());
    	return super.insert(model);
    }
    
    @Override
    public int update(BlogModel model) {
    	model.setUpdateDate(new Date());
    	return super.update(model);
    }

	@Override
	public BlogModel selectOther(Map<String,Object> map) {
		return blogMapper.selectOther(map);
	}
}
