package week5.mandatory_assignmentw5;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DeleteLead extends BaseClass{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		
		String sheetName="Delete Lead";
		String data[][]=ExcelDataRead.readExcelData(sheetName);
		return data;
	}

	
	@Test(dataProvider="TestData")
	public void deleteLead(String phCountryCd, String phAreaCd, String phNo) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys(phCountryCd);
		driver.findElement(By.name("phoneAreaCode")).sendKeys(phAreaCd);
		driver.findElement(By.name("phoneNumber")).sendKeys(phNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if(displayed) {
			System.out.println("The mentioned Lead is not available");
		}else {
			System.err.println("The mentioned Lead is not yet deleted");
		}

	}

}
