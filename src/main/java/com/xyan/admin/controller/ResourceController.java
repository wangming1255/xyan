package com.xyan.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.frame.base.web.ResponseModel;
import com.xyan.frame.feature.web.MediaTypes;
import com.xyan.frame.security.model.ResourceModel;
import com.xyan.frame.security.service.ResourceService;

/**
 * @author wangming
 *权限管理--资源管理
 */
@Controller
@RequestMapping("/admin/authority/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView role(){
		ResourceModel model=resourceService.getResourceTree(1L);
		return new ModelAndView("/admin/authority/resource").addObject("resourceList", resourceService.selectByExample(null));
	}
	
	
	@RequestMapping(value="dialog/add",method=RequestMethod.GET)
	public ModelAndView add(ResourceModel model){
		if(model.getpId()!=null){
			model.setLevel(model.getLevel()+1);
		}
		return new ModelAndView("/admin/authority/resourceAdd").addObject("model", model);
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST,produces=MediaTypes.JSON_UTF_8)
	@ResponseBody
	public ResponseModel save(ResourceModel model){
		ResponseModel responseModel=new ResponseModel();
		resourceService.insertOrUpdate(model);
		responseModel.setSuccess(true);
		responseModel.setLogin(true);
		return responseModel;
	}
}


