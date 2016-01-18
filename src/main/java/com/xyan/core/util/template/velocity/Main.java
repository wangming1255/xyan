package com.xyan.core.util.template.velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Main {
	
	public static void handle(){
		Velocity.init(Config.properties);
		Template template = Velocity.getTemplate("");
		VelocityContext context = new VelocityContext();
		String fileSeparator = System.getProperty("file.separator");
		String fileName="template"+fileSeparator+"";
		context.put("meta", null);
		try {
			writeFiles(template, context, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeFiles(Template template, VelocityContext context,
			String fileName) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName, false);
		template.merge(context, fileWriter);
		fileWriter.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		//System.out.println(Class.class.getClass().getResource("/").getPath());
	  //.out.println(directory.getCanonicalPath());//获取标准的路径 
	   // System.out.println();//获取绝对路径 
	}
}
class Config{
	public static Properties properties = new Properties();
	static{
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, Class.class.getClass().getResource("/").getPath());
		properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		properties.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		properties.setProperty(Velocity.RESOURCE_LOADER, "file");
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
	}
}