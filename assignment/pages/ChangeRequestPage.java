package week6.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import week6.assignment.testnghooks.PreAndPost;

public class ChangeRequestPage extends PreAndPost{
	public ChangeRequestPage typeShortDespriptions() {
		driver.findElement(By.id("change_request.short_description")).sendKeys("This is Change creation TC");
		return this;
	}
	
	public CreateChangeRequestPage clickSubmit() {
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		return new CreateChangeRequestPage();
	}
	
	public ChangeRequestPage selectStatusAsAssess() {
		Select status= new Select(driver.findElement(By.id("change_request.state")));
		status.selectByVisibleText("Assess");
		
		return this;
	}
	public ChangeRequestPage typeAssignmentGroup(String group) throws InterruptedException {
		driver.findElement(By.id("sys_display.change_request.assignment_group")).sendKeys(group,Keys.TAB);
		Thread.sleep(2000);
		return this;
	}
	public ChangeRequestPage typeAssignedTo(String assignedTo) throws InterruptedException {
		driver.findElement(By.id("sys_display.change_request.assigned_to")).sendKeys(assignedTo,Keys.TAB);
		Thread.sleep(2000);
		return this;
	}
	
	public ChangeRequestsPage clickUpdate() {
		driver.findElement(By.id("sysverb_update_bottom")).click();
		return new ChangeRequestsPage();
	}
	
	public ChangeRequestPage clickScheduleTab() {
		driver.findElement(By.xpath("//span[text()='Schedule']")).click();
		return this;
	}
	
	public ChangeRequestPage selectPlannedStartDate() {
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		driver.findElement(By.id("GwtDateTimePicker_day17")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		return this;
	}
	
	public ChangeRequestPage selectPlannedEndDate() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
		driver.findElement(By.id("GwtDateTimePicker_day41")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public ChangeRequestPage checkCabRequiredCheckBox() {
		driver.findElement(By.xpath("(//span[@class='input-group-checkbox'])[2]")).click();
		return this;
	}
	
	public ChangeRequestPage selectCabDate() throws InterruptedException {
		driver.findElement(By.id("change_request.cab_date.ui_policy_sensitive")).click();
		driver.findElement(By.id("GwtDateTimePicker_day40")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public ChangeRequestPage clickDeleteButton() {
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		return this;
	}
	
	public ChangeRequestsPage clickDeleteconfirmationButton() {
		driver.findElement(By.id("ok_button")).click();
		return new ChangeRequestsPage();
	}
}
