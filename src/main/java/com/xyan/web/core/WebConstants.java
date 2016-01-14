package com.xyan.web.core;

import com.xyan.core.util.GenerateUtil;

/**参数接口，存放固定参数*/
public interface WebConstants {
	
	/**登录的User*/
	public static final String LOGIN_USER="login_user";
	/**登录验证码*/
	public static final String LOGIN_CODE="login_code";
	/**评论验证码*/
	public static final String COMMENT_CODE="comment_code";
	/**系统登录状态key*/
	public static final String SAFETY_LOGIN_KEY=GenerateUtil.getSequence(32, GenerateUtil.GENERATE_FORMAT_CHAR_ADN_NUM);
}
