package com.xyan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangming
 *闲言碎语
 */
@Controller
@RequestMapping(value = "/blog/talk")
public class TalkController {
	
	public String index(){
		return "blog/talk/talk";
	}
}
