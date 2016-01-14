package com.xyan.service;

import java.util.List;

import com.xyan.api.model.VisitModel;
import com.xyan.core.generic.GenericService;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface VisitService extends GenericService<VisitModel, String> {

	/**
	 * @Author:wangming
	 * @Description:批量更新
	 * @param list
	 * @since 2015年12月8日 下午1:58:03
	 */
	public void updateList(List<VisitModel> list);
}
