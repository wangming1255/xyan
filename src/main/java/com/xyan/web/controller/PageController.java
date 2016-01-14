package com.xyan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyan.web.core.BaseController;
import com.xyan.web.core.WebConstants;


/**
 * @author wangming
 * @description 页面跳转
 * @since ctreated at 2015年12月14日 上午10:21:19
 * @update wangming modified at 2015年12月14日 上午10:21:19
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseController implements WebConstants {
	private final Logger log = LoggerFactory.getLogger(PageController.class);  
    private static final String viewPath="page/";
	
    @RequestMapping("/noLogin")
    public String login(@RequestParam(required=false)Integer flag,@RequestParam(required=false)String callUrl,ModelMap modelMap) {
    	log.warn("转向登录页。。。");
    	if(flag==null){
    		modelMap.addAttribute("message","user.error.toLogin");
    	}else{
    		modelMap.addAttribute("message","user.error.reLogin");
    	}
    	modelMap.addAttribute("callUrl", callUrl);
        return viewPath+"noLogin";
    }

    
    /**
     * @Author:wangming
     * @Description:跳转到404页面
     * @return
     * @since 2015年12月14日 上午10:52:03
     */
    @RequestMapping("/404")
    public String error404() {
    	log.warn("转向404页。。。");
        return viewPath+"404" ;
    }

    
    /**
     * @Author:wangming
     * @Description:跳转到401页面
     * @return
     * @since 2015年12月14日 上午10:52:20
     */
    @RequestMapping("/401")
    public String error401() {
    	log.warn("转向401页。。。");
        return viewPath+"401";
    }

   
    /**
     * @Author:wangming
     * @Description:跳转到500页面
     * @return
     * @since 2015年12月14日 上午10:52:35
     */
    @RequestMapping("/500")
    public String error500() {
    	log.warn("转向500页。。。");
        return viewPath+"500";
    }

}