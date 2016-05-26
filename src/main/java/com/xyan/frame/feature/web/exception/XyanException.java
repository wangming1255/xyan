package com.xyan.frame.feature.web.exception;

/**
 * @Description  项目业务异常
 * @author wangming
 * @since 2016年3月7日 上午9:44:45
 */
public class XyanException extends Exception {
	
	private static final long serialVersionUID = -8796754156162446652L;
	
	public XyanException() {
		
	}

	public XyanException(String message) {
		super(message);
	}

	public XyanException(String message, Throwable cause) {
		super(message, cause);
	}

	public XyanException(Throwable cause) {
		super(cause);
	}

}
