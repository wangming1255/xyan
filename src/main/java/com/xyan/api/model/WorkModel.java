package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.xyan.api.core.BaseModel;

public class WorkModel extends BaseModel{

	private static final long serialVersionUID = 1062997176132157450L;
	
	/**内容*/
	private String content;
	/**创建时间*/
	private Date createDate;
	/**状态 1可以使用 0 删除*/
	private String status;
	private String type;
	/**状态 1可以使用 0 删除*/
	public String getStatus() {
		return status;
	}
	/**状态 1可以使用 0 删除*/
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Map<String, Object> toMap() {
		HashMap<String,Object> map=new HashMap<String,Object>();
    	map.put("id",super.getId());
    	map.put("content", this.content);
    	map.put("createDate", this.createDate);
    	map.put("status", this.status);
		return map;
	}
}
