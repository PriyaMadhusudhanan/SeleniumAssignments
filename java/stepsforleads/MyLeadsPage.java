package stepsforleads;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyLeadsPage extends BaseSteps{
	
	@And("Click on Find Leads")
	public void clickOnFindLeadsMenu() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@Then("Verify Lead is deleted")
	public void isLeadDeleted() {
		String title = driver.getTitle();
		if(title.contains("My Leads")) {
			System.out.println("Lead is deleted successfully");
		}else {
			System.out.println("Lead is not deleted");
		}
	}
	
}
