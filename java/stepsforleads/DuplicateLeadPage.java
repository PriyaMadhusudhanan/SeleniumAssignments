package stepsforleads;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class DuplicateLeadPage extends BaseSteps {
	@And("Click on Create Lead Button")
	public void clickCreateLead() {
		driver.findElement(By.className("smallSubmit")).click();
	}
}
