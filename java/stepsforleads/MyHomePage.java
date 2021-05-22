package stepsforleads;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class MyHomePage extends BaseSteps{
	
	@And("Click on Leads button")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
}
