package com.xyan.frame.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

/**文件工具类*/
public class FileUtil {

	
	/**获取文件的mime类型*/
	public static String getMimeType(String file) throws Exception{
		MagicMatch match = Magic.getMagicMatch(new File(file), true);
		return match.getMimeType();
	}
	
	public static void main(String[] args) {
		createDir("d:\\tmp\\mp3");
	}
	
	/*public static void read(String file) {
		FileInputStream is = null;
		try {
			File f = new File(file);
			is = new FileInputStream(f);

			ContentHandler contenthandler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			metadata.set(Metadata.RESOURCE_NAME_KEY, f.getName());
			Parser parser = new AutoDetectParser();
			ParseContext context = new ParseContext();
			parser.parse(is, contenthandler, metadata, context);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}*/
	
	/**
	 * 写文件
	 * @param content 文件内容
	 * @param file 文件名
	 */
	public static void writeFile(byte[] content, String file) {
		try {
			File f = new File(file).getParentFile();
			if (!f.exists()) {
				f.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(content, 0, content.length);
			fos.flush();
			fos.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 *@Auhor:创建目录
	 *@Description:(用一句话描述)
	 *@param dir
	 *@Date:2016年4月18日 上午10:26:51
	 */
	public static void createDir(String dir){
		File file=new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	public static void log(String key,String content) throws IOException{
		File logFile=new File(SystemUtil.getProperty("file.log.path")+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+".log");
		if(!logFile.exists()){
			logFile.createNewFile();
		}
		Writer out=new BufferedWriter(new FileWriter(logFile,true));
		out.write("\n"+key+"\n");
		out.write(content);
		out.close();
	}
}
