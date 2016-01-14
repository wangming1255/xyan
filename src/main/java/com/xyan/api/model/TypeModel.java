package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;

import com.xyan.api.core.BaseModel;

/**
 * @author wangming
 * @description 类型实体类
 * @since 创建于 2015年11月25日 上午9:33:17
 * @update wangming修改于 2015年11月25日 上午9:33:17
 */
public class TypeModel extends BaseModel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;//类型名称

    private String pId;//父类型ID
    
    private String pName;//父类型名
    /**值，区分不同的表所需要用的类型 blog 博客*/
    private String value;
    /**值名称*/
    private String valueName;
    private Date createTime;//创建时间
    
    private Date updateDate;//更新时间


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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

	@Override
	public HashMap<String,Object> toMap() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("id",super.getId());
		map.put("name",this.name);
		map.put("pId",this.pId);
		map.put("createTime", this.createTime);
		map.put("pName",this.pName);
		map.put("updateDate", this.updateDate);
		map.put("value", this.value);
		map.put("valueName", this.valueName);
		return map;
	}
    
    
}