package com.xyan.test.pdf;

import java.io.File;



/**
 * @author:wangming
 * @description:(描述这个类的用途)
 * @since:ctreated at 2015年12月29日 上午11:56:12
 * @update:wangming modified at 2015年12月29日 上午11:56:12
 * @version:1.0
 */
public class PdfUtils {

	private PdfUtilsBean pdfUtilsBean = null;
	private String fileName = "";
	private String picPath = "";
	private int id = -1;

	public PdfUtils(PdfUtilsBean pdfUtilsBean, String fileName, String picPath, int id) {
		this.pdfUtilsBean = pdfUtilsBean;
		this.fileName = fileName;
		this.picPath = picPath;
		this.id = id;
	}

	public void CreatePdf() {
		this.pdfUtilsBean.CreatePdf(fileName, picPath, id);
	}

	public void DeletePdf() throws Exception {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
	}
}
