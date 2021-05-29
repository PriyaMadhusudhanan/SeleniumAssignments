package week7.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	
	@Test
	public static Object[][] readExcelData(String sheetName) {
		try {
			
			File filePath=new File("./Data/Leads.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(filePath);
			XSSFSheet sh=wb.getSheet(sheetName);
			int rowCount=sh.getLastRowNum();
			int colCount=sh.getRow(0).getLastCellNum();
			String[][] data=new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row=sh.getRow(i);
				//int colCount=row.getLastCellNum();
				for (int j = 0; j < colCount; j++) {
					data[i-1][j]=row.getCell(j).getStringCellValue();
					//System.out.println(row.getCell(j).getStringCellValue());
				}
			}
			
			return data;
			
		} catch (InvalidFormatException e) {
			System.err.println("Invalid format Exception");
			return null;
		} catch (IOException e) {
			System.err.println("Excel file is not available");
			return null;
		}
		
	}

}
