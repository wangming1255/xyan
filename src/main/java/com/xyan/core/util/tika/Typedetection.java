package com.xyan.core.util.tika;
/*package com.eliteams.quick4j.core.util.tika;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

public class Typedetection {
	
	 * MIME 标准
	 * 
	 * 多用途Internet邮件扩展(MIME)标准，用于识别文件类型的最佳标准。这些标准的知识有助于在内部相互作用的浏览器。
	 * 
	 * 当浏览器遇到一个媒体文件，它选择可用它来显示其内容的兼容软件。在情况下，它不具有任何合适的应用程序，以运行一个特定媒体文件，
	 * 它建议用户获得合适的插件软件。 Tika类型检测
	 * 
	 * Tika支持MIME所提供的所有互联网媒体文件类型。每当一个文件通过Tika检测到该文件，其文件类型。检测的介质类型，Tika内部通过以下机制。
	 * 文件扩展名
	 * 
	 * 检查文件扩展名是检测的文件的格式的最简单和最广泛使用的方法。许多应用程序和操作系统提供这些扩展的支持。下面所示是一些已知文件类型的扩展名。 
	 * 文件名  				扩展名 
	 * image 				.jpg 
	 * audio 				.mp3 
	 * java  archive file 	.jar 
	 * java class file 		.class
	 * 内容类型提示
	 * 
	 * 每当从数据库中检索文件或将其附加到另一个文档，可能会失去该文件的名称或扩展名。在这种情况下，该文件所提供的元数据被用于检测文件的扩展名。 魔术字节
	 * 
	 * 遵守文件的原始字节，可以为每个文件找到一些独特的字符模式。一些文件具有特殊的字节前缀称为被专门制成并包含在一个文件中，
	 * 用于识别文件类型的目的魔术字节。
	 * 
	 * 例如，可以找到CA FE BA在一个PDF文件（十六进制格式）的一个java文件和PDF％（ASCII格式）。
	 * Tika使用此信息来识别的文件的媒体类型。 字符编码
	 * 
	 * 文件纯文本使用不同类型的字符编码的编码。这里的主要挑战是确定在文件中使用的字符编码的类型。Tika
	 * 一样的标记和字节的频率来识别所使用的纯文本内容的编码系统字符编码技术。 XML根字符
	 * 
	 * 为了检测XML文档，Tika解析XML文档并提取，如根元素，命名空间和引用的架构，从文件的真实介质类型，可以找到的信息。
	 * 使用Facade类类型检测
	 * 
	 * facade类的detect() 方法被用于检测文档类型。这个方法接受一个文件作为输入。下面显示的是文件类型检测与Tika外观类的示例程序。
	 
	public static void main(String[] args) throws IOException {
		// assume example.mp3 is in your current directory
		File file = new File("E:/Test/12.html");//

		// Instantiating tika facade class
		Tika tika = new Tika();

		// detecting the file type using detect method
		String filetype = tika.detect(file);
		System.out.println(filetype);
	}

}*/