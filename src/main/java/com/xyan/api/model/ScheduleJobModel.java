package com.xyan.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.xyan.api.core.BaseModel;


/**
 * @author wangming
 * @description 计划任务信息
 * @since ctreated at 2015年12月7日 下午2:50:46
 * @update wangming modified at 2015年12月7日 下午2:50:46
 */
public class ScheduleJobModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_RUNNING = "1";
	public static final String STATUS_NOT_RUNNING = "0";
	public static final String CONCURRENT_IS = "1";
	public static final String CONCURRENT_NOT = "0";
	
	private Long jobId;

	private Date createTime;

	private Date updateTime;
	/**
	 * 任务名称
	 */
	private String jobName;
	/**
	 * 任务分组
	 */
	private String jobGroup;
	/**
	 * 任务状态 是否启动任务
	 */
	private String jobStatus;
	/**
	 * cron表达式
	 */
	private String cronExpression;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 任务执行时调用哪个类的方法 包名+类名
	 */
	private String beanClass;
	/**
	 * 任务是否有状态
	 */
	private String isConcurrent;
	/**
	 * spring bean
	 */
	private String springId;
	/**
	 * 任务调用的方法名
	 */
	private String methodName;
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		if(!illegalCronExpression(cronExpression)){
			cronExpression="0 15 10 * * ? 2005";//不合法的表达式时设为一个不会执行的时间
		}
		this.cronExpression = cronExpression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}
	public String getIsConcurrent() {
		return isConcurrent;
	}
	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}
	public String getSpringId() {
		return springId;
	}
	public void setSpringId(String springId) {
		this.springId = springId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public Map<String, Object> toMap() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", super.getId());
		map.put("beanClass",this.beanClass);
		map.put("createTime",this.createTime);
		map.put("cronExpression",this.cronExpression);
		map.put("description",this.description);
		map.put("isConcurrent",this.isConcurrent);
		map.put("jobGroup",this.jobGroup);
		map.put("jobId",this.jobId);
		map.put("jobName",this.jobName);
		map.put("jobStatus",this.jobStatus);
		map.put("methodName",this.methodName);
		map.put("springId",this.springId);
		map.put("updateTime",this.updateTime);
		return map;
	}
	
	private boolean  illegalCronExpression(String cronExpression){
		boolean result=true;
		try {
			//CronScheduleBuilder.cronSchedule(cronExpression);
		} catch (Exception e) {
			result=false;
		}
		return result;
	}
	
}
