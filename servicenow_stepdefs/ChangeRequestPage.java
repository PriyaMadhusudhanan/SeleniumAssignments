package servicenow_stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class ChangeRequestPage extends BaseSteps{
	@And("type description as (.*)$")
	public void typeShortDespriptions(String desc) {
		driver.findElement(By.id("change_request.short_description")).sendKeys(desc);
	}
	
	@And("click submit button")
	public void clickSubmit() {
		driver.findElement(By.id("sysverb_insert_bottom")).click();
	}
}
