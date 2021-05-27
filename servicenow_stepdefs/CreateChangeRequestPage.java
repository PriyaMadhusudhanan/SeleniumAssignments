package servicenow_stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class CreateChangeRequestPage extends BaseSteps{
	
	@And("move to main frame")
	public void switchToMainFrame() {
		driver.switchTo().frame("gsft_main");
	}
	
	@And("select normal")
	public void clickOnNormalButton() {
		driver.findElement(By.xpath("//span[text()='Normal']")).click();
	}
	
	@Then("verify change is created successully")
	public void getPageName() {
		if(driver.findElement(By.xpath("//h1[text()='Create a change request']")).isDisplayed()) {
			System.out.println("Change is created successfully");
		}
	}
	
	
}
