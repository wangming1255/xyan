package com.xyan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyan.web.core.BaseController;
import com.xyan.web.core.WebConstants;

@Controller
@RequestMapping("/work")
public class WorkController extends BaseController implements WebConstants {
	
	private static final String viewPath="work/";
	
	@RequestMapping("list")
	public String toContact(){
		return viewPath+"list";
	}
}
