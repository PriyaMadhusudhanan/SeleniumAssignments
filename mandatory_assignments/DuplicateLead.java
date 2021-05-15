package week5.day1.mandatory_assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DuplicateLead extends BaseClass{
	@Test
	public void dupLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//a[@class='x-tab-right'])[3]")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("priya.madhu7373@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String FirstName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		String LastName = driver.findElement(By.id("createLeadForm_lastName")).getAttribute("value");
		driver.findElement(By.name("submitButton")).click();
		String Fname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String Lname = driver.findElement(By.id("viewLead_lastName_sp")).getText();

		if(FirstName.equals(Fname)&&LastName.equals(Lname)) {
			System.out.println("Duplicated lead name is same as captured name");
		}else {
			System.err.println("Duplicated lead name is not same as captured name");
		}

	}

}
