package com.xyan.web.Listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyan.api.model.TypeModel;
import com.xyan.core.config.ApplicationConfig;
import com.xyan.core.util.PropertiesUtil;
import com.xyan.core.util.SpringBeansUtil;
import com.xyan.service.TypeService;

public class Constant implements ServletContextListener{

	private final Logger log = LoggerFactory.getLogger(Constant.class);  
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.warn("项目结束。。。");
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		log.warn("项目开始启动，设置全局属性。。。。");
		//设置项目的部署路径
		ApplicationConfig.setViewPath(sc.getServletContext().getRealPath("/")+"WEB-INF\\views\\");
		String path=sc.getServletContext().getContextPath();
		sc.getServletContext().setAttribute("path", path);
		TypeService typeService=(TypeService) SpringBeansUtil.getBean("typeServiceImpl");
		//加载全局静态变量
		List<TypeModel> typeList=typeService.selectByExample(null);
		ApplicationConfig.setTypeList(typeList);
		//配置文件中的项目属性
		log.warn("配置文件中的项目属性。。。。");
		boolean fgs="1".equals(PropertiesUtil.getProperties("system.fgs"));
		ApplicationConfig.setFgs(fgs);
		long fgsTime=new Long(PropertiesUtil.getProperties("system.fgsTime"));
		ApplicationConfig.setFgsTime(fgsTime);
	}
}
