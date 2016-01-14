package com.xyan.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xyan.api.model.BlogModel;
import com.xyan.core.config.ApplicationConfig;
import com.xyan.core.feature.orm.mybatis.Page;
import com.xyan.core.util.DateUtil;
import com.xyan.core.util.UtilConstant;
import com.xyan.service.BlogService;
import com.xyan.web.core.BaseController;
import com.xyan.web.core.ResponseModel;
import com.xyan.web.core.WebConstants;


/**
 * 后台管理
 * 目前还缺少权限控制
 */
@Controller
@RequestMapping(value="admin")
public class AdminController extends BaseController implements WebConstants{
	private final Logger log = LoggerFactory.getLogger(AdminController.class);  
	private static String viewPath="admin/";
	
	@Autowired
	private BlogService service;
	
	/**进入列表*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="list")
	public ModelAndView list(Page page){
		log.warn("请求后台管理列表页。。。");
		ModelAndView mv=new ModelAndView(viewPath+"list");
		List<BlogModel> list=service.selectByExample(null, page);
		int total=service.countByExample(null);
		return mv.addObject("list", list).addObject("page", page.setTotalCount(total));
	}
	
	/**进入新增*/
	@RequestMapping(value="add")
	public ModelAndView add() throws Exception{
		log.warn("请求后台管理新增页。。。");
		ModelAndView mv=new ModelAndView(viewPath+"add");
		return mv.addObject("typeList", ApplicationConfig.typeList);
	}
	
	/**新增保存*/
	@RequestMapping(value="save")
	@ResponseBody
	public ResponseModel save(BlogModel model) throws Exception{
		log.warn("请求后台管理保存。。。");
		ResponseModel respn=new ResponseModel();
		service.insert(model);
		respn.setSuccess(true);
		return respn;
	}
	
	/**更新*/
	@RequestMapping(value="update")
	@ResponseBody
	public ResponseModel update(BlogModel model){
		log.warn("请求后台管理更新。。。");
		ResponseModel respn=new ResponseModel();
		service.update(model);
		respn.setSuccess(true);
		return respn;
	}
	
	/**批量更新状态*/
	@RequestMapping(value="updateStatus")
	@ResponseBody
	public ResponseModel delete(@RequestParam("idList[]") List<String> idList,String status){
		log.warn("请求后台管理删除。。。");
		ResponseModel respn=new ResponseModel();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("idList", idList);
		map.put("status", status);
		int res=service.batchUpdateStatus(map);
		respn.setStr1(res+"");
		respn.setSuccess(true);
		return respn;
	}
	
	/**图片上传*/
	@RequestMapping(value="images/upload")
	public String upload(HttpServletRequest request,HttpServletResponse response,MultipartFile upload) throws IOException{
		log.warn("请求后台管理图片上传。。。");	
		//上传的目录
        String path = request.getSession().getServletContext().getRealPath("/file"); 
        File targetPath=new File(path);
        if(!targetPath.exists()){  
        	targetPath.mkdirs();  
        }  
        //上传的文件名
        String originalFilename = upload.getOriginalFilename();  
        String expandedName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());  //文件扩展名  
        
        response.setCharacterEncoding("utf-8");  
        PrintWriter out = response.getWriter();  
        // CKEditor提交的很重要的一个参数  
        String callback = request.getParameter("CKEditorFuncNum");   
          
        InputStream is = upload.getInputStream();  
        //String uploadPath =request.getServletContext().getRealPath("/img/postImg");  
        String fileName = DateUtil.getNowDate(UtilConstant.DATE_FORMAT_LONG_ZH);  //采用时间的方式随即命名  
        fileName += expandedName;  
        OutputStream os = new FileOutputStream(new File(path, fileName));     
        byte[] buffer = new byte[2048];     
        int length = 0;  
        while ((length = is.read(buffer)) > 0) {     
            os.write(buffer, 0, length);     
        }     
        is.close();  
        os.close();  
          
        // 返回“图像”选项卡并显示图片  
        out.println("<script type=\"text/javascript\">");    
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + request.getContextPath()+ "/file/" + fileName + "','')");    
        out.println("</script>");  
	          
		return null;
	}
	
	/**进入编辑*/
	@RequestMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable String id){
		log.warn("请求后台管理编辑页。。。");
		ModelAndView mv=new ModelAndView(viewPath+"edit");
		return mv;
	}
	
}
