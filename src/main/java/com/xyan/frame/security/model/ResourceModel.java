package com.xyan.frame.security.model;

import com.xyan.frame.base.model.BaseModel;


/**
 * @Description 资源实体类，代表系统中可供访问的所有资源
 * @author wangming
 * @since 2016年3月5日 下午5:33:35
 */
public class ResourceModel extends BaseModel {
	
	private Long pId;//父级资源ID
	private String resourceName;//资源名称
	private String icon;//图标
	private String iconBack;//后面图标
	private String url;//url
	private String permission;//权限字符串
	private String resourceType;//资源类型
	private Long available;//0 不可用 1 可用 默认可用
	private int level;//层级
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ResourceModel() {
		
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		if(pId==null){
			pId=0L;
		}
		this.pId = pId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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

	public String getIconBack() {
		return iconBack;
	}

	public void setIconBack(String iconBack) {
		this.iconBack = iconBack;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
}
