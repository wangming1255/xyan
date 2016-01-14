package com.xyan.web.core;

import javax.servlet.http.HttpServletRequest;

import com.xyan.core.feature.orm.mybatis.Page;
import com.xyan.core.util.MathUtil;

public class BaseController {
	
	@SuppressWarnings("rawtypes")
	protected Page parsePage(){
		HttpServletRequest req=ServletContext.getRequest();
		int pageNo=MathUtil.str2Int(req.getParameter("pageNo"));
		if(pageNo<1||pageNo>100){
			pageNo=1;
		}
		int pageSize=MathUtil.str2Int(req.getParameter("pageSize"));
		if(pageSize<5||pageSize>500){
			pageSize=10;
		}
		return new Page(pageNo,pageSize);
	}
}
