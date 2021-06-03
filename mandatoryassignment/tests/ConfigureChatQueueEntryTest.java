package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;

public class ConfigureChatQueueEntryTest extends TestNgHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Configure chat queue entry";
		testDescription = "Configure existing chat queue entry";
		nodes = "Queue Entry";
		authors = "Priya";
		category = "sanity";
		dataSheetName = "Configure Chat";
	}
	
	@Test(dataProvider = "fetchData")
	public void configureChatQueueEntry(String uid, String pwd, String filter, String chatID, String status, String priority) throws InterruptedException {
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
			.selectState(status)
			.selectPriority(priority)
			.clickUpdate();
	}

}
