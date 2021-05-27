package servicenow_stepdefs;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;


public class ChatQueueEntryPage extends BaseSteps {
	@And("type Short Description")
	public void typeShortDescription() {
		driver.findElement(By.id("chat_queue_entry.short_description")).sendKeys("This is queue entry");
	}
	@And("click Submit button")
	public void clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
}
