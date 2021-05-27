package servicenow_stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class TasksPage extends BaseSteps {
	
	@And("click new button")
	public TaskPage clickOnNewButton() {
		driver.findElement(By.id("sysverb_new")).click();
		return new TaskPage();
	}
	
	@Then("verify successful creation")
	public void checkTitle() {
		String title = driver.getTitle();
		if(title.contains("Tasks")) {
			System.out.println("Verified successfully");
		}
	}
	
	@When("search with existing request {string}")
	public void searchWithRequestNumber(String reqNo) {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(reqNo,Keys.ENTER);
	}
	
	@And("Select existing request")
	public void SelectExistingRequest() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}
	
	
}
