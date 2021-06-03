package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;


public class ChangeRequestsPage extends TestNgHooks{
	public ChangeRequestsPage switchToFrame() {
		switchToFrame("gsft_main");
		return this;
	}
	
	public ChangeRequestsPage selectSearchWithNumber(String value) {
		selectDropDownUsingText(locateElement("xpath", "//select[@class='form-control default-focus-outline']"), value);
		return this;
	}
	
	public ChangeRequestsPage typeChangeID(String ChangeID) {
		clear_TypeAndClickEnter(locateElement("xpath", "//input[@class='form-control']"), ChangeID);
		return this;
	}
	
	public ChangeRequestPage selectChangeToBeOpened() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new ChangeRequestPage();
	}
}
