package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;


public class CreateChangeRequestPage extends TestNgHooks{
	public CreateChangeRequestPage switchToMainFrame() {
		switchToFrame("gsft_main");
		return this;
	}
	public ChangeRequestPage clickOnNormalButton() {
		click(locateElement("xpath", "//span[text()='Normal']"));
		return new ChangeRequestPage();
	}
}
