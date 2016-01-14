package com.xyan.api.mapper;

import java.util.Map;

import com.xyan.api.model.BlogModel;
import com.xyan.core.generic.GenericDao;


/**
 * @author wangming
 * @description BlogMapper
 * @since 创建于 2015年11月27日 下午4:21:58
 * @update wangming修改于 2015年11月27日 下午4:21:58
 */
@SuppressWarnings("rawtypes")
public interface BlogMapper extends GenericDao<BlogModel, String> {

	/**批量更新状态*/
	int batchUpdateStatus(Map map);
	/**上一篇下一篇查询*/
	BlogModel selectOther(Map map);
}