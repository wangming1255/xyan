package com.xyan.frame.util.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelUtil {

	@SuppressWarnings("resource")
	public static void read() {
		try {
			FileInputStream file = new FileInputStream("fisrtExcel.xls");
			POIFSFileSystem ts = new POIFSFileSystem(file);
			HSSFWorkbook wb = new HSSFWorkbook(ts);
			HSSFSheet sh = wb.getSheetAt(0);
			HSSFRow ro = null;
			for (int i = 0; sh.getRow(i) != null; i++) {
				ro = sh.getRow(i);
				for (int j = 0; ro.getCell(j) != null; j++) {
					System.out.print(ro.getCell(j) + "");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ok");
	}

	@SuppressWarnings("resource")
	public static void createExcel(String name) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件(Workbook)
		workbook.createSheet("工作簿");// 创建工作表(Sheet)
		FileOutputStream out = new FileOutputStream(name);
		workbook.write(out);// 保存Excel文件
		out.close();// 关闭文件流
	}
	
	public static void createCell(HSSFSheet sheet,int rowNum,int cellNum,Object value){
		HSSFCell cell = sheet.createRow(rowNum).createCell(cellNum);// 创建行的单元格,也是从0开始
		cell.setCellValue(value.toString());// 设置单元格内容
	}
	
	public static void main(String[] args) {
		try {
			createExcel("d:\\tmp\\test.xls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
