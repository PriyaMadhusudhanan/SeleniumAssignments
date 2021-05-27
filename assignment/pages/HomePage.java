package week6.assignment.pages;

import org.openqa.selenium.By;

import week6.assignment.testnghooks.PreAndPost;

public class HomePage extends PreAndPost{
	public HomePage filter(String filter) {
		driver.findElement(By.id("filter")).sendKeys(filter);
		return this;
	}
	
	public TasksPage clickOnMyWork() {
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		return new TasksPage();
	}
	
	public CreateChangeRequestPage clickOnChange() {
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
		return new CreateChangeRequestPage();
	}
	
	public ChangeRequestsPage openChange() {
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		return new ChangeRequestsPage();
	}
}
