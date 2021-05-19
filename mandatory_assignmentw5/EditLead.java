package week5.mandatory_assignmentw5;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class EditLead extends BaseClass {
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		
		String sheetName="Edit Lead";
		Object data[][]=ExcelDataRead.readExcelData(sheetName);
		return data;
	}

	
	@Test(dataProvider="TestData")
	public void editLead(String FName, String CompName) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(FName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(CompName);
		driver.findElement(By.name("submitButton")).click();
		String compName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		compName=compName.replaceAll("[0-9()]", " ").trim();
		if(compName.equals("Atos Syntel India PVT LTD")) {
			System.out.println("Company name got updated properly");
		}else {
			System.err.println("Company name is not updated properly");
		}

	}

}
