package com.xyan.core.util.template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import com.xyan.api.model.WorkModel;
import com.xyan.core.config.ApplicationConfig;

public class HtmlTemlate {
	public static Map<String,Object> productByURL(String url) {
		WorkModel model=new WorkModel();
		try {
			URL u = new URL(url);
			URLConnection connection = u.openConnection();
			InputStream is = (InputStream) connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer str = new StringBuffer();
			String tempStr = null;
			while ((tempStr = br.readLine()) != null) {
				str.append(tempStr);
			}
			is.close();
			String id=System.currentTimeMillis()+"";
			File f=new File(ApplicationConfig.viewPath+"/work/template/"+id+".html");
			if(!f.exists()){
				f.createNewFile();
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			out.write(str.toString());
			model.setId(id);
			model.setContent(str.toString());
			model.setCreateDate(new Date());
			model.setStatus("1");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model.toMap();
	}
	
	public static Map<String,Object> productByContent(String content) {
		WorkModel model=new WorkModel();
		try {
			String id=System.currentTimeMillis()+"";
			File f=new File(ApplicationConfig.viewPath+"/work/template/"+id+".html");
			BufferedReader in = new BufferedReader(new FileReader(f));
			StringBuffer str = new StringBuffer();
			String tempStr = null;
			while ((tempStr = in.readLine()) != null) {
				if(tempStr.matches("[.||\\n]*$\\{{1}")){
					
				}
				str.append(tempStr);
			}
			in.close();
			if(!f.exists()){
				f.createNewFile();
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			out.write(str.toString());
			model.setId(id);
			model.setContent(str.toString());
			model.setCreateDate(new Date());
			model.setStatus("1");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model.toMap();
	}
	public static void main(String[] args) {
		String str="....${";
		String url="[.||\\n]*$\\{{1}";
		System.out.println(str.matches(url));
	}
}
