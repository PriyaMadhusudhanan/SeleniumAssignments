package stepsforleads;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ViewLeadPage extends BaseSteps{
	@And("Click on Duplicate button")
	public void clickDuplicate() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	@Then("Verify duplicate Lead is created")
	public void isDuplicateLeadCreated() {
		String title = driver.getTitle();
		
		if(title.contains("View Lead")) {
			System.out.println("Duplicate Lead is created successfully");
		}else {
			System.out.println("Duplicate Lead is not created");
		}
		
	}
	
	@And("Click on Delete button")
	public void clickDelete() {
		driver.findElement(By.linkText("Delete")).click();
	}
}
