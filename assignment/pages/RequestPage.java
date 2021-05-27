package week6.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.assignment.testnghooks.PreAndPost;

public class RequestPage extends PreAndPost{
	public RequestPage typeDescription() {
		driver.findElement(By.id("sc_request.description")).sendKeys("This is new request");
		return this;
	}
	public TasksPage clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new TasksPage();
	}
	
	public TasksPage clickOnCancelRequest() {
		driver.findElement(By.xpath("//button[text()='Cancel Request']")).click();
		return new TasksPage();
	}
	
	public RequestPage selectLocation(String location) throws InterruptedException {
		driver.findElement(By.id("sys_display.sc_request.location")).sendKeys(location,Keys.TAB);
		Thread.sleep(1000);
		return this;
	}
	
	public RequestPage selectDueDate() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		driver.findElement(By.xpath("//a[@aria-selected='true']//following::td/a")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public TasksPage clickUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
		return new TasksPage();
	}
	
	public RequestPage clickDelete() {
		driver.findElement(By.id("sysverb_delete")).click();
		return this;
	}
	
	public TasksPage clickOnDeleteConfirmation() {
		driver.findElement(By.id("ok_button")).click();
		return new TasksPage();
	}
}
