package com.xyan.web.controller.websocket;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.google.gson.GsonBuilder;
import com.xyan.web.core.Message;

/**
 * @author wangming
 * @description WebsocketController  need access Control
 * @since ctreated at 2015年12月4日 上午8:47:23
 * @update wangming modified at 2015年12月4日 上午8:47:23
 */
@Controller
@RequestMapping("websocket")
public class WebsocketController {

	@Resource
	MyWebSocketHandler handler;

	// 跳转到发布广播页面
	@RequestMapping(value = "broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {
		//权限控制
		return new ModelAndView("broadcast");
	}

	// 发布系统广播（群发）
	@ResponseBody
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	public void broadcast(String text) throws IOException {
		Message msg = new Message();
		msg.setDate(new Date());
		msg.setFrom("-1");
		msg.setFromName("系统广播");
		msg.setTo("0");
		msg.setText(text);
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

}