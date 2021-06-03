package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class CreateChatQueueEntryTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Create change";
		testDescription = "Create a new change request";
		nodes = "Change Management";
		authors = "Priya";
		category = "sanity";
		dataSheetName = "Create Chat";
	}
	@Test(dataProvider="fetchData")
	public void createChatQueueEntry(String uid, String pwd, String filter, String desc) {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnMyWork()
			.switchToMainFrame()
			.clickOnNewButton()
			.clickOnChatQueueEntry()
			.typeShortDescription(desc)
			.clickSubmit();
	}

}
