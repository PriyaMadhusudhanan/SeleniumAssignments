package stepsforleads;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class HomePage extends BaseSteps{
	@And("click on CRMSFA link")
	public void clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
}
