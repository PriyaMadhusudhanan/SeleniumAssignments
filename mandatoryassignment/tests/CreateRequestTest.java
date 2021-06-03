package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class CreateRequestTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Request";
		testDescription = "Create a new request";
		nodes = "Request Management";
		authors = "Priya";
		category = "regression";
		dataSheetName = "Create Request";
	}
	
	@Test(dataProvider = "fetchData")
	//String CompName, String FName, String LName, String email , String phCountrCd, String phAreaCd, String phNo
	public void createRequest(String uid, String pwd, String filter, String desc) {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnMyWork()
			.switchToMainFrame()
			.clickOnNewButton()
			.clickOnRequest()
			.typeDescription(desc)
			.clickSubmit();
	}

}
