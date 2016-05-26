package com.xyan.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangming
 *管理员
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public String index(){
		return "admin/main";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "admin/login";
	}
}