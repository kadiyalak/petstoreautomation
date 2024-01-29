package api.utilities;
import java.io.File;import java.io.IOException;import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.FileInputStream;
import java.io.FileOutputStream;import org.apache.poi.ss.usermodel .*;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class XLUtility {
public FileInputStream f1;
	public FileOutputStream fo;
	
	public XSSFWorkbook workbook;
	
	public XSSFSheet sheet;
	
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
	f1=new FileInputStream(path);
	workbook=new XSSFWorkbook(f1);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	f1.close();
	return rowcount;
}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
	f1=new FileInputStream(path);
	workbook=new XSSFWorkbook(f1);
	
	sheet=workbook.getSheet(sheetName);row=sheet.getRow(rownum);int cellCount=row.getLastCellNum();
	
	workbook.close();
	f1.close();
	return cellCount;
}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	
	{
	f1=new FileInputStream(path);
	workbook=new XSSFWorkbook(f1);
	
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	DataFormatter formatter=new DataFormatter();
	
	String data;
	try {
	
	data=formatter.formatCellValue(cell);//returns the formatted value of a cell as a String 
	}
	
	catch(Exception e)
	{
	
	data="";
	
	
	}
	workbook.close();
	f1.close();
	return data;
	}
	
	public void setCellData(String sheetName,int colnum,String data,int rownum) throws IOException
	
	{
	
	File xlfile=new File(path);
	if(!xlfile.exists())//if file not exists then create new file
	
	{
	workbook=new XSSFWorkbook();
	fo=new FileOutputStream(path);
	
	workbook.write(fo);;
	}
	f1=new FileInputStream(path);
	workbook=new XSSFWorkbook(f1);
	
	if(workbook.getSheetIndex(sheetName)==-1)//if sheetnot exists then create new sheet
	{
	workbook.createSheet(sheetName);
	sheet=workbook.getSheet(sheetName);
	}
	
	if(sheet.getRow(rownum)==null)//if row not exists then create new row
	{
		sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);;workbook.close();
		f1.close();fo.close();
		
	}
	}
		public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
		{
		
		f1=new FileInputStream(path);
		workbook=new XSSFWorkbook(f1);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);;
		
		workbook.write(fo);;
		workbook.close();
		f1.close();
		fo.close();
		
		}
		public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
		{
		
		
			f1=new FileInputStream(path);
			workbook=new XSSFWorkbook(f1);
			sheet=workbook.getSheet(sheetName);
			
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			style=workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);;
			
			workbook.write(fo);;
			workbook.close();
			f1.close();
			fo.close();
		
		
		
	}
	
	
}
