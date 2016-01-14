package com.xyan.web.interceptors;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.api.model.UserModel;
import com.xyan.api.model.VisitModel;
import com.xyan.core.config.ApplicationConfig;
import com.xyan.core.security.SafetyConfig;
import com.xyan.core.util.ApplicationUtils;
import com.xyan.core.util.DateUtil;
import com.xyan.service.VisitService;
import com.xyan.web.core.ServletContext;
import com.xyan.web.core.WebUtil;  
  
public class LogInterceptor implements HandlerInterceptor {  
	 private final Logger log = LoggerFactory.getLogger(LogInterceptor.class);  
  
	 @Autowired
	 private VisitService visitService;
	 
    /** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
        UserModel user=WebUtil.getLoginUser(request);
        String url = request.getRequestURI();    
        String queryString = StringUtils.isBlank(request.getQueryString())?"":request.getQueryString();  
        String rIp=ApplicationUtils.getIpAddr(request);
        Map<String,Object> queryMap=new HashMap<>();
        queryMap.put("ip", rIp);
        queryMap.put("url", url);
        boolean fgsFlag=ApplicationConfig.fgs;//根据配置文件决定是否防止灌水
        if(fgsFlag){
        	List<VisitModel> list= visitService.selectByExample(queryMap);
        	if(list.size()>0){
        		VisitModel historyModel=list.get(0);
        		//访问间隔时间必须大于10秒
        		if(DateUtil.getDiffDate2Now(historyModel.getLastTime())<ApplicationConfig.fgsTime){
        			fgsFlag=false;
        			request.setAttribute("message", "user.error.busy");
        		}
        	}
        }
        VisitModel visitModel=new VisitModel();
        visitModel.setIp(rIp);//mac地址由定时器来更新
        visitModel.setMethod(request.getMethod());
        visitModel.setUrl(url);
        visitModel.setQueryString(queryString);
        visitModel.setLastTime(new Date());
        boolean flag=true;
        if(url.indexOf("admin")>-1){
        	if(user!=null&&ApplicationConfig.ADMIN_NAME.equals(user.getLoginName())){
        		log.info("管理员访问系统后台。。。");
        	}else{
        		log.info("非管理员访问系统后台，请求被拦截。。。");
        		flag=false;
        		request.setAttribute("message", "user.error.illegal");
        		visitModel.setSafetyGrade(SafetyConfig.SAFETY_GRADE_SEVEN);
        	}
        }
        visitModel.setState("1");
        visitService.insert(visitModel);
        ServletContext.setRequest(request);
        ServletContext.setResponse(response);
       /* if(!flag||!fgsFlag){
        	request.setAttribute("mesage","user.error.toLogin");
        	request.setAttribute("callUrl", url);
        	request.getRequestDispatcher("/WEB-INF/views/page/noLogin.jsp").forward(request, response);
        	log.warn("非法请求，跳转到noLogin");
        	return false;
        }*/
        return true;  
    }  
      
    /** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像， 
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个
     * Interceptor或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。 
     */  
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
    }  
  
    /** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
    throws Exception {  
    	ServletContext.removeRequest();
    	ServletContext.removeResponse();
    }  
      
}  