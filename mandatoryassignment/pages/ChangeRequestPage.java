package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;


public class ChangeRequestPage extends TestNgHooks{
	public ChangeRequestPage typeShortDespriptions(String desc) {
		clearAndType(locateElement("id", "change_request.short_description"), desc);
		return this;
	}
	
	public CreateChangeRequestPage clickSubmit() {
		click(locateElement("id", "sysverb_insert_bottom"));
		return new CreateChangeRequestPage();
	}
	
	public ChangeRequestPage selectStatusAsAssess(String value) {
		selectDropDownUsingText(locateElement("id","change_request.state"), value);
		return this;
	}
	public ChangeRequestPage typeAssignmentGroup(String group) throws InterruptedException {
		clear_TypeAndClickTab(locateElement("id", "sys_display.change_request.assignment_group"), group);
		Thread.sleep(2000);
		return this;
	}
	public ChangeRequestPage typeAssignedTo(String assignedTo) throws InterruptedException {
		clear_TypeAndClickTab(locateElement("id", "sys_display.change_request.assigned_to"), assignedTo);
		Thread.sleep(2000);
		return this;
	}
	
	public ChangeRequestsPage clickUpdate() {
		click(locateElement("id", "sysverb_update_bottom"));
		return new ChangeRequestsPage();
	}
	
	public ChangeRequestPage clickScheduleTab() {
		click(locateElement("xpath", "//span[text()='Schedule']"));
		return this;
	}
	
	public ChangeRequestPage selectPlannedStartDate() {
		click(locateElement("xpath", "//span[@class='icon-calendar icon']"));
		click(locateElement("id", "GwtDateTimePicker_day17"));
		click(locateElement("id", "GwtDateTimePicker_ok"));
		return this;
	}
	
	public ChangeRequestPage selectPlannedEndDate() throws InterruptedException {
		click(locateElement("xpath", "(//span[@class='icon-calendar icon'])[2]"));
		click(locateElement("id", "GwtDateTimePicker_day41"));
		click(locateElement("id", "GwtDateTimePicker_ok"));
		Thread.sleep(1000);
		return this;
	}
	
	public ChangeRequestPage checkCabRequiredCheckBox() {
		click(locateElement("xpath", "(//span[@class='input-group-checkbox'])[2]"));
		return this;
	}
	
	public ChangeRequestPage selectCabDate() throws InterruptedException {
		click(locateElement("id", "change_request.cab_date.ui_policy_sensitive"));
		click(locateElement("id", "GwtDateTimePicker_day40"));
		Thread.sleep(1000);
		return this;
	}
	
	public ChangeRequestPage clickDeleteButton() {
		click(locateElement("xpath", "//button[text()='Delete']"));
		return this;
	}
	
	public ChangeRequestsPage clickDeleteconfirmationButton() {
		click(locateElement("id", "ok_button"));
		return new ChangeRequestsPage();
	}
}
