package com.xyan.core.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

/**
 * @author:wangming
 * @description:(描述这个类的用途)
 * @since:ctreated at 2015年12月29日 下午1:49:55
 * @update:wangming modified at 2015年12月29日 下午1:49:55
 * @version:1.0
 */
public class PDFUtil {
	
	static String path = "e://tmp//";
	/**
	 * @throws IOException 
	 * @throws DocumentException 
	 * @Author:wangming
	 * @Description:添加水印(背景图)
	 * @since 2015年12月29日 下午1:49:49
	 */
	public static void method1() throws IOException, DocumentException{
		//图片水印
		PdfReader reader = new PdfReader(path + "test.pdf");
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(path
				+ "test2.pdf"));

		Image img = Image.getInstance(path+"1.jpg");
		img.setAbsolutePosition(200, 400);
		PdfContentByte under = stamp.getOverContent(1);
		under.addImage(img);

		//文字水印
		PdfContentByte over = stamp.getOverContent(1);
		over.beginText();
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
				BaseFont.EMBEDDED);
		over.setFontAndSize(bf, 18);
		over.setTextMatrix(30, 30);
		over.showTextAligned(Element.ALIGN_LEFT, "DUPLICATE", 230, 430, 45);
		over.endText();

		//背景图
		Image img2 = Image.getInstance(path+"2.jpg");
		img2.setAbsolutePosition(0, 0);
		PdfContentByte under2 = stamp.getOverContent(1);
		under2.addImage(img2);

		stamp.close();
		reader.close();
	}
	
	/**
	 * @Author:wangming
	 * @Description:插入Chunk, Phrase, Paragraph, List 
	 * @throws DocumentException
	 * @since 2015年12月29日 下午2:03:06
	 */
	public static void method2() throws DocumentException{
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		rect.setBackgroundColor(BaseColor.ORANGE);
		Document document = new Document(rect);
		//Chunk对象: a String, a Font, and some attributes
		document.add(new Chunk("China"));
		document.add(new Chunk(" "));
		Font font = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
		Chunk id = new Chunk("chinese", font);
		id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
		id.setTextRise(6);
		document.add(id);
		document.add(Chunk.NEWLINE);

		document.add(new Chunk("Japan"));
		document.add(new Chunk(" "));
		Font font2 = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
		Chunk id2 = new Chunk("japanese", font2);
		id2.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
		id2.setTextRise(6);
		id2.setUnderline(0.2f, -2f);
		document.add(id2);
		document.add(Chunk.NEWLINE);

		//Phrase对象: a List of Chunks with leading
		document.newPage();
		document.add(new Phrase("Phrase page"));

		Phrase director = new Phrase();
		Chunk name = new Chunk("China");
		name.setUnderline(0.2f, -2f);
		director.add(name);
		director.add(new Chunk(","));
		director.add(new Chunk(" "));
		director.add(new Chunk("chinese"));
		director.setLeading(24);
		document.add(director);

		Phrase director2 = new Phrase();
		Chunk name2 = new Chunk("Japan");
		name2.setUnderline(0.2f, -2f);
		director2.add(name2);
		director2.add(new Chunk(","));
		director2.add(new Chunk(" "));
		director2.add(new Chunk("japanese"));
		director2.setLeading(24);
		document.add(director2);
				
		//Paragraph对象: a Phrase with extra properties and a newline
		document.newPage();
		document.add(new Paragraph("Paragraph page"));

		Paragraph info = new Paragraph();
		info.add(new Chunk("China "));
		info.add(new Chunk("chinese"));
		info.add(Chunk.NEWLINE);
		info.add(new Phrase("Japan "));
		info.add(new Phrase("japanese"));
		document.add(info);

		//List对象: a sequence of Paragraphs called ListItem
		document.newPage();
		List list = new List(List.ORDERED);
		for (int i = 0; i < 10; i++) {
			ListItem item = new ListItem(String.format("%s: %d movies",
					"country" + (i + 1), (i + 1) * 100), new Font(
					Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));
			List movielist = new List(List.ORDERED, List.ALPHABETICAL);
			movielist.setLowercase(List.LOWERCASE);
			for (int j = 0; j < 5; j++) {
				ListItem movieitem = new ListItem("Title" + (j + 1));
				List directorlist = new List(List.UNORDERED);
				for (int k = 0; k < 3; k++) {
					directorlist.add(String.format("%s, %s", "Name1" + (k + 1),
							"Name2" + (k + 1)));
				}
				movieitem.add(directorlist);
				movielist.add(movieitem);
			}
			item.add(movielist);
			list.add(item);
		}
		document.add(list);

	}
	
	/**
	 * @Author:wangming
	 * @Description:插入Anchor, Image, Chapter, Section 
	 * @throws DocumentException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @since 2015年12月29日 下午2:04:21
	 */
	public static void method3() throws DocumentException, MalformedURLException, IOException{
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		rect.setBackgroundColor(BaseColor.ORANGE);
		Document document = new Document(rect);
		//Anchor对象: internal and external links
		Paragraph country = new Paragraph();
		Anchor dest = new Anchor("china", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
		dest.setName("CN");
		dest.setReference("http://www.china.com");//external
		country.add(dest);
		country.add(String.format(": %d sites", 10000));
		document.add(country);

		document.newPage();
		Anchor toUS = new Anchor("Go to first page.", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
		toUS.setReference("#CN");//internal
		document.add(toUS);

		//Image对象
		document.newPage();
		Image img = Image.getInstance("resource/test.jpg");
		img.setAlignment(Image.LEFT | Image.TEXTWRAP);
		img.setBorder(Image.BOX);
		img.setBorderWidth(10);
		img.setBorderColor(BaseColor.WHITE);
		img.scaleToFit(1000, 72);//大小
		img.setRotationDegrees(-30);//旋转
		document.add(img);

		//Chapter, Section对象（目录）
		document.newPage();
		Paragraph title = new Paragraph("Title");
		Chapter chapter = new Chapter(title, 1);

		title = new Paragraph("Section A");
		Section section = chapter.addSection(title);
		section.setBookmarkTitle("bmk");
		section.setIndentation(30);
		section.setBookmarkOpen(false);
		section.setNumberStyle(
		Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);

		Section subsection = section.addSection(new Paragraph("Sub Section A"));
		subsection.setIndentationLeft(20);
		subsection.setNumberDepth(1);

		document.add(chapter);

	}
	
	
	/**
	 * @Author:wangming
	 * @Description:画图 
	 * @throws DocumentException
	 * @since 2015年12月29日 下午2:05:28
	 */
	public static void method4() throws DocumentException{
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		rect.setBackgroundColor(BaseColor.ORANGE);
		Document document = new Document(rect);
		//左右箭头
		document.add(new VerticalPositionMark() {

			public void draw(PdfContentByte canvas, float llx, float lly,
					float urx, float ury, float y) {
				canvas.beginText();
				BaseFont bf = null;
				try {
					bf = BaseFont.createFont(BaseFont.ZAPFDINGBATS, "", BaseFont.EMBEDDED);
				} catch (Exception e) {
					e.printStackTrace();
				}
				canvas.setFontAndSize(bf, 12);
				
				// LEFT
				canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), llx - 10, y, 0);
				// RIGHT
				canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), urx + 10, y + 8, 180);
				
				canvas.endText();
			}
		});

		//直线
		Paragraph p1 = new Paragraph("LEFT");
		p1.add(new Chunk(new LineSeparator()));
		p1.add("R");
		document.add(p1);
		//点线
		Paragraph p2 = new Paragraph("LEFT");
		p2.add(new Chunk(new DottedLineSeparator()));
		p2.add("R");
		document.add(p2);
		//下滑线
		LineSeparator UNDERLINE = new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
		Paragraph p3 = new Paragraph("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
		p3.add(UNDERLINE);
		document.add(p3);

	}
	
	
	/**
	 * @Author:wangming
	 * @Description:设置段落
	 * @throws DocumentException
	 * @since 2015年12月29日 下午2:06:24
	 */
	public static  void method5() throws DocumentException{
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		rect.setBackgroundColor(BaseColor.ORANGE);
		Document document = new Document(rect);
		Paragraph p = new Paragraph("In the previous example, you added a header and footer with the showTextAligned() method. This example demonstrates that it’s sometimes more interesting to use PdfPTable and writeSelectedRows(). You can define a bottom border for each cell so that the header is underlined. This is the most elegant way to add headers and footers, because the table mechanism allows you to position and align lines, images, and text.");

		//默认
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(p);

		document.newPage();
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		p.setIndentationLeft(1 * 15f);
		p.setIndentationRight((5 - 1) * 15f);
		document.add(p);

		//居右
		document.newPage();
		p.setAlignment(Element.ALIGN_RIGHT);
		p.setSpacingAfter(15f);
		document.add(p);

		//居左
		document.newPage();
		p.setAlignment(Element.ALIGN_LEFT);
		p.setSpacingBefore(15f);
		document.add(p);

		//居中
		document.newPage();
		p.setAlignment(Element.ALIGN_CENTER);
		p.setSpacingAfter(15f);
		p.setSpacingBefore(15f);
		document.add(p);

	}
	
	
	/**
	 * @Author:wangming
	 * @Description:删除Page 
	 * @throws IOException
	 * @throws DocumentException
	 * @since 2015年12月29日 下午2:08:39
	 */
	public static void method6() throws IOException, DocumentException{
		FileOutputStream out = new FileOutputStream(path + "deletePage.pdf");

		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document, out);

		document.open();
		document.add(new Paragraph("First page"));
		document.add(new Paragraph(Document.wmfFontCorrection));

		document.newPage();
		writer.setPageEmpty(false);

		document.newPage();
		document.add(new Paragraph("New page"));

		document.close();

		PdfReader reader = new PdfReader(path + "deletePage.pdf");
		reader.selectPages("1,3");
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(path
				+ "deletePage2.pdf"));
		stamp.close();
		reader.close();

	}
	
	public static void method7() throws DocumentException, IOException{
		FileOutputStream out = new FileOutputStream(path + "insertPage.pdf");

		Document document = new Document();

		PdfWriter.getInstance(document, out);

		document.open();
		document.add(new Paragraph("1 page"));

		document.newPage();
		document.add(new Paragraph("2 page"));

		document.newPage();
		document.add(new Paragraph("3 page"));

		document.close();

		PdfReader reader = new PdfReader(path + "insertPage.pdf");
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(path
				+ "insertPage2.pdf"));

		stamp.insertPage(2, reader.getPageSize(1));

		ColumnText ct = new ColumnText(null);
		ct.addElement(new Paragraph(24, new Chunk("INSERT PAGE")));
		ct.setCanvas(stamp.getOverContent(2));
		ct.setSimpleColumn(36, 36, 559, 770);

		stamp.close();
		reader.close();

	}
	
	
	public static void main(String[] args) {
		try {
			method1();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
