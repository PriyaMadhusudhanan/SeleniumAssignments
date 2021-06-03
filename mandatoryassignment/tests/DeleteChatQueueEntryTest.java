package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class DeleteChatQueueEntryTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete chat queue entry";
		testDescription = "Delete existing chat";
		nodes = "Queue Entry";
		authors = "Priya";
		category = "sanity";
		dataSheetName = "Delete Chat";
	}
	@Test(dataProvider="fetchData")
	public void createChatQueueEntry(String uid, String pwd, String filter, String chatID) {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber(chatID)
			.SelectExistingChatQueueEntry()
			.clickDelete()
			.clickOnDeleteConfirmation();
	}

}
