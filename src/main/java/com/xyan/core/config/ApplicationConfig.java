package com.xyan.core.config;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.xyan.api.model.TypeModel;

public class ApplicationConfig {
	
	/**管理员登录名*/
	public static String ADMIN_NAME="admin";
	/**没有登录的人名*/
	public static String NO_LOGIN_USERNAME="匿名";
	/**管理员是否需要验证*/
	public static boolean IS_ADMIN=false;
	/**管理员验证码*/
	public static String IS_ADMIN_CODE="2E844CC766776261AE970F53F503B12C";//SecureUtil.md5(SecureUtil.md5("18136442251")+"xyan");
	
	/**私有构造*/
	private ApplicationConfig() {
	
	}
	
	/**同时在线人数*/
	private static Integer ONLINE_NUM=0;
	public static Integer getOnlineNum(){
		return ONLINE_NUM;
	}
	public static synchronized void increaseOnlineNum(){
		ApplicationConfig.ONLINE_NUM++;
	}
	public static synchronized void decreaseOnlineNum(){
		if(ApplicationConfig.ONLINE_NUM<=0){
			ApplicationConfig.ONLINE_NUM=0;
			return ;
		}
		ApplicationConfig.ONLINE_NUM++;
	}
	
	/**项目视图在主机的实际路径*/
	public static String viewPath="";
	public static void setViewPath(String path){
		if(StringUtils.isNotBlank(path)){
			ApplicationConfig.viewPath=path;
		}
	}
	
	/**分类缓存*/
	public static List<TypeModel> typeList=null;
	public static void setTypeList(List<TypeModel> typeList){
		if(CollectionUtils.isNotEmpty(typeList)){
			ApplicationConfig.typeList=typeList;
		}
	}
	
	/**是否防灌水*/
	public static boolean fgs=false;
	public static void setFgs(boolean fgs){
		ApplicationConfig.fgs=fgs;
	}
	
	/**防灌水时间间隔*/
	public static long fgsTime=0;
	public static void setFgsTime(long fgsTime){
		ApplicationConfig.fgsTime=fgsTime;
	}
	
	/**安全倒计时*/
	public static long safetyTime=0;
	public static void decreaseSafetyTime(){
		ApplicationConfig.safetyTime-=1000;
	}
}
