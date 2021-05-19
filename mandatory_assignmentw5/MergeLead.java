package week5.mandatory_assignmentw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MergeLead extends BaseClass{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		
		String sheetName="Merge Lead";
		Object data[][]=ExcelDataRead.readExcelData(sheetName);
		return data;
	}
	
	@Test(dataProvider="TestData")
	public void mergeLead(String fromFName, String fromLName, String toFName, String toLName) throws InterruptedException {
		
		//Click on Merge Lead
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();

		//Click on from Contact icon
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();

		//Window handles
		Set<String> allWindows=driver.getWindowHandles();
		List<String> listOfWindows=new ArrayList<String>(allWindows);

		//Move to From Contact window
		driver.switchTo().window(listOfWindows.get(1));

		//Select the first Lead
		driver.findElement(By.name("firstName")).sendKeys(fromFName);
		driver.findElement(By.name("lastName")).sendKeys(fromLName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//Switch control to parent window
		driver.switchTo().window(listOfWindows.get(0));

		//Click on To Contact icon
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();
		
		//Getting current windows
		allWindows=driver.getWindowHandles();
		listOfWindows=new ArrayList<String>(allWindows);

		//Move to To Contact window
		driver.switchTo().window(listOfWindows.get(1));

		//Select the first contact
		driver.findElement(By.name("firstName")).sendKeys(toFName);
		driver.findElement(By.name("lastName")).sendKeys(toLName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//Switch control to parent window
		driver.switchTo().window(listOfWindows.get(0));
		
		//Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
