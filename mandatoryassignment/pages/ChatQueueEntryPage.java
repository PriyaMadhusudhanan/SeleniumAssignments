package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;


public class ChatQueueEntryPage extends TestNgHooks {
	public ChatQueueEntryPage typeShortDescription(String desc) {
		clearAndType(locateElement("id", "chat_queue_entry.short_description"), desc);
		return this;
	}
	
	public TaskPage clickSubmit() {
		click(locateElement("id", "sysverb_insert"));
		return new TaskPage();
	}
	
	public ChatQueueEntryPage selectState(String stateDesc) throws InterruptedException {
		selectDropDownUsingText(locateElement("id", "chat_queue_entry.state"), stateDesc);
		Thread.sleep(1000);
		return this;
	}
	
	public ChatQueueEntryPage selectPriority(String priorityDesc) throws InterruptedException {
		selectDropDownUsingText(locateElement("id", "chat_queue_entry.priority"), priorityDesc);
		Thread.sleep(1000);
		return this;
	}
	
	public TasksPage clickUpdate() {
		click(locateElement("id", "sysverb_update"));
		return new TasksPage();
	}
	
	public ChatQueueEntryPage typeConfigurationItem(String config) throws InterruptedException {
		clear_TypeAndClickTab(locateElement("id", "sys_display.chat_queue_entry.cmdb_ci"), config);
		Thread.sleep(2000);
		return this;
		
	}
	
	public ChatQueueEntryPage clickDelete() {
		click(locateElement("id", "sysverb_delete"));
		return this;
	}
	
	public TasksPage clickOnDeleteConfirmation() {
		click(locateElement("id", "ok_button"));
		return new TasksPage();
	}
}
