package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.xyan.api.core.BaseModel;

/**
 * @author wangming
 * @description 访问控制Model
 * @since ctreated at 2015年12月6日 下午7:49:14
 * @update wangming modified at 2015年12月6日 下午7:49:14
 */
public class VisitModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ip;
	private String mac;
	private String url;
	private String queryString;
	/**访问方法*/
	private String method;
	/**状态 1正常访问 0 异常*/
	private String state;
	private Date lastTime;
	/**安全级别*/
	private String safetyGrade;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getIp() {
		return ip;
	}

	public String getSafetyGrade() {
		return safetyGrade;
	}

	public void setSafetyGrade(String safetyGrade) {
		this.safetyGrade = safetyGrade;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public Map<String, Object> toMap() {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id",super.getId());
		map.put("ip",this.ip);
		map.put("mac",this.mac);
		map.put("state",this.state);
		map.put("url",this.url);
		map.put("queryString",this.queryString);
		map.put("lastTime",this.lastTime);
		map.put("method", this.method);
		map.put("safetyGrade", this.safetyGrade);
		return map;
	}

}
