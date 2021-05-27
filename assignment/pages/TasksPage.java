package week6.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.assignment.testnghooks.*;

public class TasksPage extends PreAndPost {
	
	public TasksPage switchToMainFrame() {
		driver.switchTo().frame("gsft_main");
		return this;
	}
	public TaskPage clickOnNewButton() {
		driver.findElement(By.id("sysverb_new")).click();
		return new TaskPage();
	}
	
	public TasksPage searchWithRequestNumber(String chatNo) {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(chatNo,Keys.ENTER);
		return this;
	}
	
	public RequestPage SelectExistingRequest() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new RequestPage();
	}
	
	public ChatQueueEntryPage SelectExistingChatQueueEntry() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new ChatQueueEntryPage();
	}
	
}
