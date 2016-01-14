package com.xyan.test.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class Test {

	static String path = "e://tmp//";

	public static void main(String[] args) throws Exception {
		// 页面大小
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		rect.setBackgroundColor(BaseColor.ORANGE);
		Document doc = new Document(rect);
		// 文档属性
		doc.addTitle("Title@sample");
		doc.addAuthor("Author@rensanning");
		doc.addSubject("Subject@iText sample");
		doc.addKeywords("Keywords@iText");
		doc.addCreator("Creator@iText");

		// 页边空白
		doc.setMargins(10, 20, 30, 40);

		doc.open();
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path + "createSamplePDF.pdf"));
		doc.open();
		doc.add(new Paragraph("Hello World2"));
		writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
		doc.close();
	}
}