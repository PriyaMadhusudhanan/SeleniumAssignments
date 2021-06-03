package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;

public class CancelRequestTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Cancel Request";
		testDescription = "Cancel the existing request";
		nodes = "Request Management";
		authors = "Priya";
		category = "smoke";
		dataSheetName = "Cancel Request";
	}
	@Test(dataProvider = "fetchData")
	public void cancelRequestTest(String uid, String pwd, String filter, String requestNo) {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber(requestNo)
			.SelectExistingRequest()
			.clickOnCancelRequest();
	}
}
