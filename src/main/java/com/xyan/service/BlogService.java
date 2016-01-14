package com.xyan.service;

import java.util.Map;

import com.xyan.api.model.BlogModel;
import com.xyan.core.generic.GenericService;

/**
 * 博客业务接口
 * @author wangming
 * @since 2015年11月12日
 **/
public interface BlogService extends GenericService<BlogModel, String> {
	/**批量更新状态*/
	int batchUpdateStatus(Map<String,Object> map);
	/**上一篇下一篇查询*/
	BlogModel selectOther(Map<String,Object> map);
	
}
