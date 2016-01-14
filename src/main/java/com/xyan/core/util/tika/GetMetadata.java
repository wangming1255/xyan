package com.xyan.core.util.tika;
/*package com.xyan.core.util.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class GetMetadata {

	
	 * 
	 * 除了内容，Tika还可以从一个文件中提取元数据。元数据是什么，但用文件所提供的附加信息。如果我们考虑一个音频文件，艺术家名，专辑名，
	 * 标题下自带的元数据。 XMP标准
	 * 
	 * 可扩展元数据平台(XMP)是用于处理和涉及到的文件的内容存储信息的标准。它是由Adobe系统公司的XMP创建提供了用于定义，创建和元数据的处理标准
	 * 。可以嵌入该标准为多种文件格式，如PDF，JPEG，JPEG，GIF，JPG，HTML等。 Property 类
	 * 
	 * Tika使用属性类遵循XMP属性定义。它提供了PropertyType和值类型枚举捕获的元数据的名称和值。 Metadata 类
	 * 
	 * 这个类实现了各种接口，如ClimateForcast, CativeCommons,Geographic, TIFF
	 * 等提供各种元数据模型的支持。此外，此类提供各种方法来提取一个文件的内容。 Metadata 名称
	 * 
	 * 我们可以从它的元数据对象用的方法()提取一个文件的所有元数据的名称的列表。它返回所有的名字作为一个字符串数组。使用元数据的名称，
	 * 就可以得到使用get()方法的值。它需要一个元数据的名称，并返回与它相关联的值。
	 * 
	 * String[] metadaNames = metadata.names();
	 * 
	 * String value = metadata.get(name);
	 * 
	 * 使用解析法提取元数据
	 * 
	 * 当我们分析一个使用文件parse()，传递一个空的元数据对象作为一个参数。这种方法提取指定的文件的元数据(如果该文件中包含有)，
	 * 并将它们放置在元数据对象。因此，在使用parse()解析文件后，就可以提取该对象的元数据。
	 * 
	 
	public static void main(final String[] args) throws IOException, TikaException {

		// Assume that boy.jpg is in your current directory
		File file = new File("boy.jpg");

		// Parser method parameters
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(file);
		ParseContext context = new ParseContext();

		try {
			parser.parse(inputstream, handler, metadata, context);
		} catch (SAXException e) {
			e.printStackTrace();
		}
		System.out.println(handler.toString());

		// getting the list of all meta data elements
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
		}
	}
}*/