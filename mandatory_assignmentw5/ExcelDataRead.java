package week5.mandatory_assignmentw5;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	@Test
	public static String[][] readExcelData(String sheetName) throws Exception {
		
		File fileName=new File("./Data/Leads.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fileName);
		XSSFSheet sheet=wb.getSheet(sheetName);

		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row=sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell=row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j]=cell.getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
	
}
