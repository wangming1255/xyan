package com.xyan.api.model;

import java.util.HashMap;

import com.xyan.api.core.BaseModel;

/**
 * @author wangming
 * @description 角色实体类
 * @since 创建于 2015年11月25日 上午9:32:42
 * @update wangming修改于 2015年11月25日 上午9:32:42
 */
public class RoleModel extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**角色名称*/
    private String roleName;
    /**角色描述*/
    private String description;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public HashMap<String,Object> toMap() {
		return null;
	}

}