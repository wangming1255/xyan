package com.xyan.web.controller.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.xyan.api.model.UserModel;
import com.xyan.web.core.WebConstants;



/**
 * @author wangming
 * @description WebSocket establish and complete
 * @since ctreated at 2015年12月3日 下午3:43:48
 * @update wangming modified at 2015年12月3日 下午3:43:48
 */
public class HandShake implements HandshakeInterceptor {
	
	protected Logger logger = Logger.getLogger(HandShake.class);
	
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			// 标记用户
			UserModel user =  (UserModel) session.getAttribute(WebConstants.LOGIN_USER);
			//logger.warn(user.toString());
			if(user!=null){
				attributes.put("user", user);
			}else{
				return false;
			}
		}
		return true;
	}

	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

	}

}
