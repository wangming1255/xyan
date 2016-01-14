package com.xyan.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author wangming
 */
public class DateUtil implements UtilConstant{
	private static SimpleDateFormat sf=new SimpleDateFormat(DATE_FORMAT_LONG);
	
	public static String getNowDate(String format){
		//if(Stringu)
		sf.applyPattern(format);
		return sf.format(new Date());
	}
	public static String getNowDate(){
		return sf.format(new Date());
	}
	
	public static long getDiff(Date date1,Date date2){
		return Math.abs(date1.getTime()-date2.getTime());
	}
	public static long getDiffDate2Now(Date date){
		return System.currentTimeMillis()-date.getTime();
	}
	
	public static void main(String[] args) {
		
	}
	/**获得时间戳*/
	public static long getTimestamp(Date date){
		return date==null?new Date().getTime():date.getTime();
	}
}
