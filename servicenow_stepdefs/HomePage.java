package servicenow_stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomePage extends BaseSteps{
	
	@Given("service now home page is loaded")
	public void checkServiceNowHomePageIsLoaded() {
		if(driver.findElement(By.xpath("//span[text()='ServiceNow Home Page']")).isDisplayed()){
			System.out.println("Service now home page is loaded");
		}else {
			System.out.println("Service now home page is not loaded");
		}
	}
	@When("filter with {string}")
	public void filter(String filter) {
		driver.findElement(By.id("filter")).sendKeys(filter);
	}
	
	@And("click My Work option")
	public void clickOnMyWork() {
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
	}
	
	@And("click Create new option")
	public void clickOnChange() {
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
	}
	
}
