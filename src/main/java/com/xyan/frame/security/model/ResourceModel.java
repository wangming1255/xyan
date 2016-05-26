package com.xyan.frame.security.model;

import com.xyan.frame.base.model.BaseModel;


/**
 * @Description 资源实体类，代表系统中可供访问的所有资源
 * @author wangming
 * @since 2016年3月5日 下午5:33:35
 */
public class ResourceModel extends BaseModel {
	
	private Long pId;//父级资源ID
	private String resouceName;//资源名称
	private String icon;//图标
	private String url;//url
	private String permission;//权限字符串
	private Long available;//0 不可用 1 可用 默认可用
	
	public ResourceModel() {
		
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getResouceName() {
		return resouceName;
	}

	public void setResouceName(String resouceName) {
		this.resouceName = resouceName;
	}

	public Long getAvailable() {
		return available;
	}

	public void setAvailable(Long available) {
		if(available==null){
			this.available = 0L;
		}else{
			this.available = available;
		}
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
