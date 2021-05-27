package week6.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import week6.assignment.testnghooks.PreAndPost;

public class ChatQueueEntryPage extends PreAndPost {
	public ChatQueueEntryPage typeShortDescription() {
		driver.findElement(By.id("chat_queue_entry.short_description")).sendKeys("This is queue entry");
		return this;
	}
	
	public TaskPage clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new TaskPage();
	}
	
	public ChatQueueEntryPage selectState(String stateDesc) throws InterruptedException {
		Select state=new Select(driver.findElement(By.id("chat_queue_entry.state")));
		state.selectByVisibleText(stateDesc);
		Thread.sleep(1000);
		return this;
	}
	
	public ChatQueueEntryPage selectPriority(String priorityDesc) throws InterruptedException {
		Select priority=new Select(driver.findElement(By.id("chat_queue_entry.priority")));
		priority.selectByVisibleText(priorityDesc);
		Thread.sleep(1000);
		return this;
	}
	
	public TasksPage clickUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
		return new TasksPage();
	}
	
	public ChatQueueEntryPage typeConfigurationItem(String config) throws InterruptedException {
		driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).clear();
		driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).sendKeys(config,Keys.TAB);
		Thread.sleep(2000);
		return this;
		
	}
	
	public ChatQueueEntryPage clickDelete() {
		driver.findElement(By.id("sysverb_delete")).click();
		return this;
	}
	
	public TasksPage clickOnDeleteConfirmation() {
		driver.findElement(By.id("ok_button")).click();
		return new TasksPage();
	}
}
