package com.xyan.core.util;

/**
 * @author wangming
 * @description 数学工具
 * @since ctreated at 2015年12月24日 下午4:55:44
 * @update wangming modified at 2015年12月24日 下午4:55:44
 */
public class MathUtil {
	
	/***
	 * @Author:wangming
	 * @Description:字符串转为Long
	 * @param str
	 * @return
	 * @since 2016年1月11日 下午4:08:31
	 */
	public static long str2Long(String str){
		try {
			return new Long(str);
		} catch (Exception e) {
			return Long.MAX_VALUE;
		}
		
	}
	
	/***
	 * @Author:wangming
	 * @Description:字符串转为Integer
	 * @param str
	 * @return
	 * @since 2016年1月11日 下午4:08:31
	 */
	public static int str2Int(String str){
		try {
			return new Integer(str);
		} catch (Exception e) {
			return Integer.MAX_VALUE;
		}
	}
	
	/***
	 * @Author:wangming
	 * @Description:字符串转为Double
	 * @param str
	 * @return
	 * @since 2016年1月11日 下午4:08:31
	 */
	public static double str2Double(String str){
		try {
			return new Double(str);
		} catch (Exception e) {
			return Double.MAX_VALUE;
		}
	}
	
	public static void main(String[] args) {
		String xx="xx";
		System.out.println(str2Long(xx));
	}
}
