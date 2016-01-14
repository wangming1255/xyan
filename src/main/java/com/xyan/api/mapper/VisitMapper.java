package com.xyan.api.mapper;

import java.util.List;

import com.xyan.api.model.VisitModel;
import com.xyan.core.generic.GenericDao;

/**
 * @author wangming
 * @description VisitMapper
 * @since ctreated at 2015年12月8日 下午1:58:27
 * @update wangming modified at 2015年12月8日 下午1:58:27
 */
public interface VisitMapper extends GenericDao<VisitModel, String>{

	
	/**
	 * @Author:wangming
	 * @Description:批量更新
	 * @param list
	 * @since 2015年12月8日 下午1:58:22
	 */
	public void updateList(List<VisitModel> list);

}
