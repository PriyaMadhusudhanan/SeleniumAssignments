package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class CreateChangeTest extends TestNgHooks {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create change";
		testDescription = "Create a new change request";
		nodes = "Change Management";
		authors = "Priya";
		category = "sanity";
		dataSheetName = "Create Change";
	}
	
	@Test(dataProvider = "fetchData")
	public void createChange(String uid, String pwd, String filter, String desc) {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnChange()
			.switchToMainFrame()
			.clickOnNormalButton()
			.typeShortDespriptions(desc)
			.clickSubmit();
	}
}
