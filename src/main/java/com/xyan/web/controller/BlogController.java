package com.xyan.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.api.model.BlogModel;
import com.xyan.core.feature.orm.mybatis.Page;
import com.xyan.service.BlogService;
import com.xyan.web.core.BaseController;
import com.xyan.web.core.WebConstants;

@Controller
@RequestMapping(value="blog")
public class BlogController extends BaseController implements WebConstants{
	
	private static final String viewPath="blog/";
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);  
	
	@Autowired
	private BlogService service;
	
	/**前端首页*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="list")
	public ModelAndView list(){
		log.warn("前端博客首页请求");
		ModelAndView mv=new ModelAndView(viewPath+"list");
		Map queryMap=new HashMap<>();
		Page page=parsePage();
		List<BlogModel> list=service.selectByExample(queryMap,page);
		return mv.addObject("list", list).addObject("page",page);
	}
	
	/**前端分类*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@RequestMapping(value="{type}")
	public ModelAndView edit(@PathVariable String type){
		log.warn("前端博客分类请求："+type);
		ModelAndView mv=new ModelAndView(viewPath+"list");
		Map queryMap=new HashMap<>();
		queryMap.put("typeFlag","1");
		queryMap.put("type", type);
		List<BlogModel> frontList=service.selectByExample(queryMap);
		return mv.addObject("list", frontList);
	}
}
