package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;

public class HomePage extends TestNgHooks{
	public HomePage filter(String filter) {
		clearAndType(locateElement("id", "filter"), filter);
		return this;
	}
	
	public TasksPage clickOnMyWork() {
		click(locateElement("xpath", "//div[text()='My Work']"));
		return new TasksPage();
	}
	
	public CreateChangeRequestPage clickOnChange() {
		click(locateElement("xpath", "(//div[text()='Create New'])[3]"));
		return new CreateChangeRequestPage();
	}
	
	public ChangeRequestsPage openChange() {
		click(locateElement("xpath", "(//div[text()='Open'])[3]"));
		return new ChangeRequestsPage();
	}
}
