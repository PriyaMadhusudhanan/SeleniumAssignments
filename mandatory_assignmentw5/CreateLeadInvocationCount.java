package week5.mandatory_assignmentw5;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class CreateLeadInvocationCount extends BaseClass {
	@Test(invocationCount=3)
	public void createLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Syntel");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Madhusudhanan");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("priya.madhu7373@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("44225185");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

	}

}
