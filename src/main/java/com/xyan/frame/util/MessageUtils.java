package com.xyan.frame.util;
import org.springframework.context.MessageSource;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-9 下午8:49
 * <p>Version: 1.0
 */
public class MessageUtils {

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringUtil.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }

}