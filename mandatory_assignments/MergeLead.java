package week5.day1.mandatory_assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class MergeLead extends BaseClass{
	@Test
	public void mergeLead() {
		
		//Click on Merge Lead
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();

		//Click on from Contact icon
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();

		//Window handles
		Set<String> allWindows=driver.getWindowHandles();
		List<String> listOfWindows=new ArrayList<String>(allWindows);

		//Move to From Contact window
		driver.switchTo().window(listOfWindows.get(1));

		//Select the first contact
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
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

		//Switch control to parent window
		driver.switchTo().window(listOfWindows.get(0));
		
		//Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
