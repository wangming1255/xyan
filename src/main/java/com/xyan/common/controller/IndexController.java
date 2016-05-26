package com.xyan.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.blog.service.ArticleService;
import com.xyan.frame.base.web.ResponseModel;
import com.xyan.frame.feature.mybatis.intercept.Page;
import com.xyan.frame.security.web.controller.UserController;

/**
 * This controller is system home page.It provides all the common service and home service;
 * @author wangming
 */
@Controller
public class IndexController {
	
	protected Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired 
	private ArticleService articleService;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index").addObject("page", articleService.selectByPage(null, new Page<HashMap<String,Object>>()));
	}
	
	@RequestMapping(value="about",method=RequestMethod.GET)
	public String about(){
		return "aboutMe";
	}
	
	@RequestMapping(value="iconfont",method=RequestMethod.GET)
	public String iconfont(){
		return "iconfont/iconfont";
	}
	
	@RequestMapping(value="ajaxUploadProcess")
	@ResponseBody
	public ResponseModel ajaxUploadProcess(HttpServletRequest request,HttpServletResponse response){
		try {
			MultipartRequest multipartRequest = (MultipartRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			logger.warn("上传文件：\n");
			logger.warn(fileMap);
			return  new ResponseModel(true,"上传成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel(false,"上传失败！");
		}
	}
}
