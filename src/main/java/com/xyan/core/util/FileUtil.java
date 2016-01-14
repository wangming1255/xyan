package com.xyan.core.util;

import java.io.File;

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
}
