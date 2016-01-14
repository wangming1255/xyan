package com.xyan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyan.api.mapper.TypeMapper;
import com.xyan.api.model.TypeModel;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.service.TypeService;

/**
 * 博客Service实现类
 * @author wangming	
 * @since 2015年11月12日
 */
@Service
public class TypeServiceImpl extends GenericServiceImpl<TypeModel, String> implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public GenericDao<TypeModel, String> getDao() {
        return typeMapper;
    }
    
}
