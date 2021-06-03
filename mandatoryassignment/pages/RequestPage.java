package week7.mandatoryassignment.pages;


import week7.mandatoryassignment.hooks.TestNgHooks;



public class RequestPage extends TestNgHooks{
	public RequestPage typeDescription(String desc) {
		clearAndType(locateElement("id", "sc_request.description"), desc);
		return this;
	}
	public TasksPage clickSubmit() {
		click(locateElement("id", "sysverb_insert"));
		return new TasksPage();
	}
	
	public TasksPage clickOnCancelRequest() {
		click(locateElement("xpath", "//button[text()='Cancel Request']"));
		return new TasksPage();
	}
	
	public RequestPage selectLocation(String location) throws InterruptedException {
		clear_TypeAndClickTab(locateElement("id", "sys_display.sc_request.location"), location);
		Thread.sleep(1000);
		return this;
	}
	
	public RequestPage selectDueDate() throws InterruptedException {
		click(locateElement("xpath", "//span[@class='icon-calendar icon']"));
		click(locateElement("xpath", "//a[@aria-selected='true']//following::td/a"));
		click(locateElement("id", "GwtDateTimePicker_ok"));
		Thread.sleep(1000);
		return this;
	}
	
	public TasksPage clickUpdate() {
		click(locateElement("id", "sysverb_update"));
		return new TasksPage();
	}
	
	public RequestPage clickDelete() {
		click(locateElement("id", "sysverb_delete"));
		return this;
	}
	
	public TasksPage clickOnDeleteConfirmation() {
		click(locateElement("id", "ok_button"));
		return new TasksPage();
	}
}
