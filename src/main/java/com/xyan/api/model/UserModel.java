package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.xyan.api.core.BaseModel;


/**
 * @author wangming
 * @description (描述这个类的用途)
 * @since 创建于 2015年11月27日 上午10:40:10
 * @update wangming修改于 2015年11月27日 上午10:40:10
 */
public class UserModel extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**用户名*/
    private String userName;
    /**登录名*/
    private String loginName;
    /**邮箱(唯一，或者为空)*/
    private String email;
    /**手机号(唯一，或者为空)*/
    private String phone;
    /**密码，数据库二次加密*/
    private String password;
    /**状态 1 可用，0 待审核，-1 黑名单*/
    private String state;
    /**最后登录IP地址*/
    private String lastLoginIp;
	/**最后登录时间*/
    private Date lastLoginDate;
    /**创建时间*/
    private Date createTime;
    
    public String getLastLoginIp() {
    	return lastLoginIp;
    }
    
    public void setLastLoginIp(String lastLoginIp) {
    	this.lastLoginIp = lastLoginIp==null?null:lastLoginIp.trim();
    }
    
    public Date getLastLoginDate() {
    	return lastLoginDate;
    }
    
    public void setLastLoginDate(Date lastLoginDate) {
    	this.lastLoginDate = lastLoginDate;
    }

    public UserModel() {

    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName==null?null:userName.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName==null?null:loginName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	
	@Override
	public String toString() {
		return "UserModel [id="+super.getId()+",userName=" + userName + ", loginName=" + loginName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", state=" + state + ", lastLoginIp=" + lastLoginIp + ", lastLoginDate="
				+ lastLoginDate + ", createTime=" + createTime + "]";
	}

	/**
	 * @Author:wangming
	 * @extOrImpl 继承父类的方法
	 * @Description:数据库层使用
	 * @return
	 * @since 2015年11月27日 上午10:40:12
	 */
	@Override
	public Map<String,Object> toMap() {
		HashMap<String, Object> map=new HashMap<>();
		map.put("id",super.getId());
		map.put("userName", this.userName);
		map.put("loginName", this.loginName);
		map.put("password", this.password);
		map.put("createTime",this.createTime);
		map.put("lastLoginDate", this.lastLoginDate);
		map.put("lastLoginIp", this.lastLoginIp);
		map.put("state",this.state);
		map.put("email",this.email);
		map.put("phone",this.phone);
		return map;
	}

}