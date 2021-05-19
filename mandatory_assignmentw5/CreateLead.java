package week5.mandatory_assignmentw5;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass {
	
	@DataProvider(name="TestData")
		public Object[][] fetchData() throws Exception{
			
			String sheetName="Create Lead";
			String data[][]=ExcelDataRead.readExcelData(sheetName);
			return data;
		}
	
	
	@Test(dataProvider="TestData")
	public void createLead(String CompName, String FName, String LName, String email, String phCountryCd, String phAreaCd, String phNo) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(phCountryCd);
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(phAreaCd);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

	}

}
