package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;

import com.xyan.api.core.BaseModel;

/**
 * @author wangming
 * @description 博客实体类
 * @since 创建于 2015年11月25日 上午9:31:09
 * @update wangming修改于 2015年11月25日 上午9:31:09
 */
public class BlogModel extends BaseModel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String typeId;//类型ID
	
	private String introduce;//介绍
	
	private String label;//标签，以‘，’分割

    private String typeName;//类型名称

    private String title;//标题

    private String content;//带格式的内容
    
    public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String contentText;//纯文本内容
    
    private Date createTime;//创建时间
    
    private Date updateDate;//更新时间
    
    private Integer readCount;//阅读次数
    
    private String status;//状态位，1 所有人可见 0 所有人都不可见 -1仅管理员可见  -2
    
	public Integer getReadCount() {
		return readCount;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**1 所有人可见 0 所有人都不可见 -1仅管理员可见 */
	public String getStatus() {
		return status;
	}
	/**1 所有人可见 0 所有人都不可见 -1仅管理员可见 */
	public void setStatus(String status) {
		this.status = status;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    
	public HashMap<String,Object> toMap(){
    	HashMap<String,Object> map=new HashMap<String,Object>();
    	map.put("id",super.getId());
    	map.put("type_id",this.typeId);
    	map.put("type_name",this.typeName);
    	map.put("title", this.title);
    	map.put("content",this.content);
    	map.put("contentText",this.contentText);
    	map.put("createTime", this.createTime);
    	map.put("updateDate", this.updateDate);
    	map.put("readCount", this.readCount);
    	map.put("introduce", this.introduce);
    	return map;
    }
}