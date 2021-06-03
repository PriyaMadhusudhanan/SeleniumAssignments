package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;

public class TasksPage extends TestNgHooks {
	
	public TasksPage switchToMainFrame() {
		switchToFrame("gsft_main");
		return this;
	}
	public TaskPage clickOnNewButton() {
		click(locateElement("id", "sysverb_new"));
		return new TaskPage();
	}
	
	public TasksPage searchWithRequestNumber(String chatNo) {
		clear_TypeAndClickEnter(locateElement("xpath", "//input[@class='form-control']"), chatNo);
		return this;
	}
	
	public RequestPage SelectExistingRequest() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new RequestPage();
	}
	
	public ChatQueueEntryPage SelectExistingChatQueueEntry() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new ChatQueueEntryPage();
	}
	
}
