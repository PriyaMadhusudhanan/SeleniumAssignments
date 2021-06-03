package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class UpdateChatQueueEntryTest extends TestNgHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update chat queue entry";
		testDescription = "Update existing chat entry";
		nodes = "Queue Entry";
		authors = "Priya";
		category = "regression";
		dataSheetName = "Update Chat";
	}
	@Test(dataProvider="fetchData")
	public void createChatQueueEntry(String uid, String pwd, String filter, String chatID, String state, String priority,String configItem) throws InterruptedException {
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
			.selectState(state)
			.selectPriority(priority)
			.typeConfigurationItem(configItem)
			.clickUpdate();
	}

}
