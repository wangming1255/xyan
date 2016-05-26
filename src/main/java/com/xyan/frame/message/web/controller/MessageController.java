package com.xyan.frame.message.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.frame.base.web.ResponseModel;
import com.xyan.frame.message.model.MessageModel;
import com.xyan.frame.message.service.MessageService;
import com.xyan.frame.security.model.UserModel;
import com.xyan.frame.security.web.util.SessionUtil;

/**
 * @author wangming
 * 消息处理器<p/>
 */
@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	/**
	 *@Auhor:wangming
	 *@Description:进入留言板页面
	 *@return
	 *@Date:2016年4月28日 上午10:20:30
	 */
	@RequestMapping("board")
	public ModelAndView board(){
		List<MessageModel> messageList=messageService.selectByExample(null);
		return new ModelAndView("message/board").addObject("messageList", messageList);
	}
	
	/**
	 *@Auhor:wangming
	 *@Description:新增一条消息
	 *@return
	 *@Date:2016年4月28日 上午10:14:11
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel add(MessageModel message,HttpServletRequest request){
		UserModel user=SessionUtil.getSessionUser(request);
		message.setFrom(user.getId());
		messageService.insert(message);
		return new ResponseModel(true);
	}
}
