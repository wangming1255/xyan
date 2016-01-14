package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;

import com.xyan.api.core.BaseModel;

/**
 * @author wangming
 * @description 评论实体类
 * @since 创建于 2015年11月25日 上午9:31:40
 * @update wangming修改于 2015年11月25日 上午9:31:40
 */
public class CommentModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**评论人ID*/
	private String userId;
	/**评论人名称*/
	private String userName;
	/**内容*/
	private String content;
	/**博客ID*/
	private String blogId;
	/**评论时间*/
	private Date commentDate;
	/**父评论ID*/
	private String pId;
	/**标题（非必须）*/
	private String title; 
	public CommentModel() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	/**
	 * @Author:wangming
	 * @extOrImpl 继承实现父类的方法
	 * @Description:(描述方法的用途)
	 * @return
	 * @since 2015年12月1日 上午10:05:33
	 */
	@Override
	public HashMap<String,Object> toMap() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("id", super.getId());
		map.put("userId", this.userId);
		map.put("userName", this.userName);
		map.put("content", this.content);
		map.put("blogId", this.blogId);
		map.put("commentDate", this.commentDate);
		map.put("pId", this.pId);
		map.put("title", this.title);
		return map;
	}
	
	
}
