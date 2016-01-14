package com.xyan.core.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyan.api.model.VisitModel;
import com.xyan.core.util.URLUtil;
import com.xyan.service.VisitService;

/**
 * @author wangming
 * @description 定时任务类
 * @since ctreated at 2015年12月8日 下午1:58:54
 * @update wangming modified at 2015年12月8日 下午1:58:54
 */
@Component("taskJob")
public class TaskJob {
	
	private final Logger log = LoggerFactory.getLogger(TaskJob.class);  
	
	@Autowired 
	private VisitService visitService;
	
	public void run(){
		log.warn("本次定时任务执行时间："+new SimpleDateFormat("YYYY年m月d日 H时M分s秒").format(new Date()));
		List<VisitModel> list=visitService.selectByExample(null);
		List<VisitModel> updateList=new LinkedList<VisitModel>();
		for(VisitModel model:list){
			if(StringUtils.isBlank(model.getMac())){
				model.setMac(URLUtil.getMacAddress(model.getIp()));
				updateList.add(model);
			}
		}
		visitService.updateList(list);
	}
}
