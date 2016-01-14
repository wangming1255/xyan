package com.xyan.api.core;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wangming
 * @description 所有实体类抽象父类，其子类必须实现toMap()方法
 * @since 2015年11月25日 上午9:27:05
 */
public abstract class BaseModel implements Serializable{
	
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;
	
	/**ID，本项目采用UUID*/
	private String id;
	
	/**
	 * @Author:wangming
	 * @Description:子类具体实现，查询
	 * @return
	 * @since 2015年11月27日 上午10:33:29
	 */
	public abstract Map<String,Object> toMap();
	
	public BaseModel() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
