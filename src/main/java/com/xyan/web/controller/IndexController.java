package com.xyan.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.api.model.BlogModel;
import com.xyan.api.model.CommentModel;
import com.xyan.core.util.VerifyCodeUtils;
import com.xyan.service.BlogService;
import com.xyan.service.CommentService;
import com.xyan.web.core.BaseController;
import com.xyan.web.core.ResponseModel;
import com.xyan.web.core.WebConstants;
import com.xyan.web.core.WebUtil;

/**
 * 首页控制器
 * @author wangming
 */
@Controller
public class IndexController extends BaseController implements WebConstants{
	
	//private static final String viewPath="common";
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);  
	@Autowired
	private BlogService service;
	
	@Autowired
	private CommentService commentService;
	
	/**首页数据*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value={"/","/index.html"})
	public ModelAndView index(HttpServletRequest req){
		log.warn("请求首页。。。。");
		Map queryMap=new HashMap<>();
		queryMap.put("typeFlag", 2);
		List<BlogModel> frontList=service.selectByExample(queryMap,null);
		queryMap.put("typeFlag", 1);
		List<BlogModel> backList=service.selectByExample(queryMap,null);
		return new ModelAndView("index")
				.addObject("frontList", frontList)
				.addObject("backList", backList);
	}
	
	/**详细*/
	@RequestMapping(value={"/read/{id}"})
	public ModelAndView index(HttpServletRequest req,@PathVariable String id){
		log.warn("请求博客详情。。。。");
		BlogModel model=service.selectByPrimaryKey(id);
		model.setReadCount(model.getReadCount()+1);
		service.update(model);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("updateDate", model.getUpdateDate());
		map.put("typeFlag",model.getTypeId().startsWith("10")?"1":"2");
		map.put("flag", 1);
		BlogModel preModel=service.selectOther(map);//上一个
		map.put("flag", 2);
		BlogModel nextModel=service.selectOther(map);//下一个
		//评论加载
		Map<String,Object> commentQueryMap=new HashMap<String,Object>();
		commentQueryMap.put("blogId",model.getId());
		List<CommentModel> commentList=commentService.selectByExample(commentQueryMap);
		return new ModelAndView("read")
				.addObject("model", model)
				.addObject("preModel", preModel)
				.addObject("nextModel", nextModel)
				.addObject("commentList", commentList);
	}
	
	
	/**
	 * @Author:wangming
	 * @Description:进入聊天
	 * @param request 请求
	 * @param map 数据
	 * @return
	 * @since 2015年12月10日 上午9:32:50
	 */
	@RequestMapping(value={"toWebsocket"})
	public String toWebSocket(HttpServletRequest request,ModelMap map){
		log.warn("请求聊天页。。。。");
		if(WebUtil.isLogin()){
			return "talk";
		}else{
			map.addAttribute("callUrl", request.getRequestURI());
			return "redirect:page/noLogin";
		}
	}
	
	@RequestMapping(value={"loginImg"})
	public void loginImg(HttpServletResponse response,HttpServletRequest request) throws IOException{
		log.warn("请求登录验证码。。。。");
		 response.setHeader("Pragma", "No-cache");  
	     response.setHeader("Cache-Control", "no-cache");  
	     response.setDateHeader("Expires", 0);  
	     response.setContentType("image/jpeg");  
	     //生成随机字串  
	     String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
	     //存入会话session  
	     HttpSession session = request.getSession(true);  
	     session.setAttribute(LOGIN_CODE, verifyCode.toLowerCase());  
	     //生成图片  ，指定图片大小
	     int w = 200, h = 80;  
	     VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
	}
	
	/**
	 * @Author:wangming
	 * @Description:请求评论验证码
	 * @param response
	 * @param request
	 * @throws IOException
	 * @since 2015年12月10日 上午9:42:53
	 */
	@RequestMapping(value={"commentImg"})
	public void commentImg(HttpServletResponse response,HttpServletRequest request) throws IOException{
		log.warn("请求评论验证码。。。。");
		response.setHeader("Pragma", "No-cache");  
		response.setHeader("Cache-Control", "no-cache");  
		response.setDateHeader("Expires", 0);  
		response.setContentType("image/jpeg");  
		//生成随机字串  
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
		//存入会话session  
		HttpSession session = request.getSession(true);  
		session.setAttribute(COMMENT_CODE, verifyCode.toLowerCase());  
		//生成图片  ，指定图片大小
		int w = 200, h = 80;  
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
	}
	
	/**
	 * @Author:wangming
	 * @Description:保存评论
	 * @param model
	 * @return
	 * @since 2015年12月10日 上午9:34:12
	 */
	@RequestMapping(value="saveComment")
	@ResponseBody
	public ResponseModel saveComment(CommentModel model,String commentCode){
		log.warn("保存评论。。。。");
		String reqCommentCode=(String) WebUtil.getAttribute(COMMENT_CODE);
		if(reqCommentCode==null||!reqCommentCode.equals(commentCode)){
			ResponseModel respn=new ResponseModel();
			respn.setSuccess(false);
			respn.setMessage("评论验证码错误");
			return respn;
		}
		ResponseModel respn=new ResponseModel();
		model=commentService.insertComment(model);
		respn.setSuccess(true);
		respn.setModelData(model);
		return respn;
	}
}
