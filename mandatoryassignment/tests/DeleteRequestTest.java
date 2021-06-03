package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class DeleteRequestTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete Request";
		testDescription = "Delete existing request";
		nodes = "Request Management";
		authors = "Priya";
		category = "smoke";
		dataSheetName = "Delete Request";
	}
	@Test(dataProvider="fetchData")
	public void cancelRequestTest(String uid, String pwd, String filter, String requestID) {
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
			.clickDelete();
	}
}
