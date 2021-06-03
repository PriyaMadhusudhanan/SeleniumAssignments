package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class UpdateRequestTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Update request";
		testDescription = "Update existing request";
		nodes = "Request Management";
		authors = "Priya";
		category = "smoke";
		dataSheetName = "Update Request";
	}
	@Test(dataProvider="fetchData")
	public void updateRequestTest(String uid, String pwd, String filter, String requestID, String location) throws InterruptedException {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber(requestID)
			.SelectExistingRequest()
			.selectLocation(location)
			.selectDueDate()
			.clickUpdate();
	}
}
