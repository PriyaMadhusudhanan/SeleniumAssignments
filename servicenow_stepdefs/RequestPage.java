package servicenow_stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.And;


public class RequestPage extends BaseSteps{
	@And("Type Description")
	public void typeDescription() {
		driver.findElement(By.id("sc_request.description")).sendKeys("This is new request");
	}
	@And("click submit")
	public void clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
	@And("Click Cancel request button")
	public void clickOnCancelRequest() {
		driver.findElement(By.xpath("//button[text()='Cancel Request']")).click();
	}
	@And("Select Location {string}")
	public void selectLocation(String location) throws InterruptedException {
		driver.findElement(By.id("sys_display.sc_request.location")).sendKeys(location,Keys.TAB);
		Thread.sleep(1000);
	}
	@And("select due date")
	public void selectDueDate() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		driver.findElement(By.xpath("//a[@aria-selected='true']//following::td/a")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		Thread.sleep(1000);
	}
	@And("click update button")
	public void clickUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
	}
	@And("Click Delete Button")
	public void clickDelete() {
		driver.findElement(By.id("sysverb_delete")).click();
	}
	@And("click Delete confirmation button")
	public void clickOnDeleteConfirmation() {
		driver.findElement(By.id("ok_button")).click();
	}
}
