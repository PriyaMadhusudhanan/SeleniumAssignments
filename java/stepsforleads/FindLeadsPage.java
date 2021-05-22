package stepsforleads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class FindLeadsPage extends BaseSteps{
	
	@When("Type First Name as (.*)$")
	public void TypeFirstName(String firstName) {
		WebElement fName=driver.findElement(By.xpath("(//input[@name='firstName'])[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(fName));
		fName.sendKeys(firstName);
	}
	
	@And("Type Last Name as (.*)$")
	public void TypeLasName(String lastName) {
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys(lastName);
	}
	
	@And("Click on Find Leads button")
	public void clickOnFindLeads() {
		WebElement btFindLead=driver.findElement(By.xpath("//button[text()='Find Leads']"));
		wait.until(ExpectedConditions.elementToBeClickable(btFindLead));
		btFindLead.click();
	}
	
	@And("Select existing Lead")
	public void selectLead() throws Exception {
		Thread.sleep(3000);
		WebElement selectLead=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		//wait.until(ExpectedConditions.visibilityOf(selectLead))
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		
		selectLead.click();
	}
	
	@When("Click on Phone")
	public void clickOnPhone() {
		WebElement phone= driver.findElement(By.xpath("//span[text()='Phone']"));
		wait.until(ExpectedConditions.elementToBeClickable(phone));
		phone.click();
	}
	
	@And("Type Phone number (.*)$")
	public void typePhoneNumber(String phoneNumber) {
		WebElement phNumber=driver.findElement(By.name("phoneNumber"));
		wait.until(ExpectedConditions.visibilityOf(phNumber));
		phNumber.sendKeys(phoneNumber);
	}
	
}
