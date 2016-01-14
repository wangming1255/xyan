package com.xyan.core.util.tika;
/*package com.eliteams.quick4j.core.util.tika;

import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
public class LanguageDetection {

	
	 * 必要的语言检测
	 * 
	 * 对于基于它们写在一个多语种网站的语言文件分类，语言检测工具是必要的。这个工具应该接受无语言注释(元数据)的文件，
	 * 并通过检测语言中添加这些信息在文档的元数据。 算法性能分析语料库 什么是语料库？
	 * 
	 * 为了检测一个文档的语言，语言信息被构造和用已知的语言的信息进行比较。设置这些已知的语言文字被称为语料库。
	 * 
	 * 语料库是一种书面语言，解释了语言用于实际生活中的文本的集合。
	 * 
	 * 语料库是从书本，成绩单，而像其他的互联网数据资源开发。语料库的精度取决于我们使用帧性能分析算法。 什么是性能分析算法？
	 * 
	 * 检测语言的常用方法是使用字典。在给定的一段文本中使用的词语将与词典进行匹配。
	 * 
	 * 在语言中常用的单词的列表将是最简单有效的语料库用于检测特定的语言，例如， a, an,在英文中。 使用Word设置为语料库
	 * 
	 * 使用字集，一个简单的算法是框架找到两个语料库，其将等于的匹配单词的频率之间的差异的总和之间的距离。
	 * 
	 * 此类算法有以下问题：
	 * 
	 * 因为匹配单词的频率非常少，则该算法不能有效地与几个句子小文本工作。它需要大量的文字进行准确匹配。
	 * 
	 * 它不能检测到字边界具有语言复合句，而那些具有类似空格或标点符号无字分隔。
	 * 
	 * 由于在使用字集作为语料库这些困难，单个字符或字符组会被考虑。 使用字符集为主体
	 * 
	 * 因为这是在一种语言中常用的字符是有限的数目，很容易应用基于单词的频率，而不是字符的算法。
	 * 这种算法的工作更为出色的情况下在一个或极少数语言中使用的特定的字符集。
	 * 
	 * 此算法存在下列缺点：
	 * 
	 * 它是难以区分具有相似性质的频率两种语言。
	 * 
	 * 没有任何特定的工具或算法来具体确定的帮助下（如文集）所使用的多语言字符集的语言。
	 * 
	 * N-gram算法
	 * 
	 * 上述的缺点就产生了利用给定长度的字符序列为分析语料的一种新方法。个字符的这样的序列被称为N-gram，在一般情况下，N表示该字符序列的长度。
	 * 
	 * N元算法是一种有效的方法来检测语言，特别是在案件欧洲语言如英语的。
	 * 
	 * 该算法与短文正常工作。
	 * 
	 * 虽然有高级语言纹算法来检测多个语言中具有更吸引人的特征的多语言文档，Tika使用3-grams算法，因为它适合于大多数实际情况。
	 * 
	 * Tika语言检测
	 * 
	 * 在所有由ISO639-1标准的184标准语言，Tika可检测18种语言。
	 * 语言检测Tika是通过使用LanguageIdentifier类的getLanguage()方法。此方法返回字符串格式的语言代号。
	 * 下面给出由Tika检测出的18语言代码对的列表中： da—Danish de—German et—Estonian el—Greek
	 * en—English es—Spanish fi—Finnish fr—French hu—Hungarian is—Icelandic
	 * it—Italian nl—Dutch no—Norwegian pl—Polish pt—Portuguese ru—Russian
	 * sv—Swedish th—Thai
	 * 
	 * 实例化LanguageIdentifier类，则应该将内容传递的字符串格式将被提取，或LanguageProfile类对象。
	 * 
	 * LanguageIdentifier object=new LanguageIdentifier(“this is english”);
	 
	public static void main(String args[]) throws IOException, SAXException, TikaException {

		LanguageIdentifier identifier = new LanguageIdentifier("this is english ");
		String language = identifier.getLanguage();
		System.out.println("Language of the given content is : " + language);
	}
	
	public static void domentLanguageDetection() throws Exception{

	      //Instantiating a file object
	      File file = new File("Example.txt");

	      //Parser method parameters
	      Parser parser = new AutoDetectParser();
	      BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      FileInputStream content = new FileInputStream(file);

	      //Parsing the given document
	      parser.parse(content, handler, metadata, new ParseContext());

	      LanguageIdentifier object = new LanguageIdentifier(handler.toString());
	      System.out.println("Language name :" + object.getLanguage());
	}
}*/