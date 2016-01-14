package com.xyan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.xyan.api.mapper.VisitMapper;
import com.xyan.api.model.VisitModel;
import com.xyan.core.generic.GenericDao;
import com.xyan.core.generic.GenericServiceImpl;
import com.xyan.service.VisitService;


/**
 * @author wangming
 * @description  user service implements
 * @since ctreated at 2015年12月3日 上午9:15:19
 * @update wangming modified at 2015年12月3日 上午9:15:19
 */
@Service
public class VisitServiceImpl extends GenericServiceImpl<VisitModel, String> implements VisitService {

    @Resource
    private VisitMapper visitMapper;

	@Override
	public GenericDao<VisitModel, String> getDao() {
		return visitMapper;
	}

	@Override
	public void updateList(List<VisitModel> list) {
		if(CollectionUtils.isNotEmpty(list)){
			visitMapper.updateList(list);
		}
	}

}
