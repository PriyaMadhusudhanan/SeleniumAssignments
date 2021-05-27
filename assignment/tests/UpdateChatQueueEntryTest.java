package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class UpdateChatQueueEntryTest extends PreAndPost{
	
	@Test
	public void createChatQueueEntry() throws InterruptedException {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("My Work")
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber("CHAT0010082")
			.SelectExistingChatQueueEntry()
			.selectState("Closed Abandoned")
			.selectPriority("1 - Critical")
			.typeConfigurationItem("PS Apache02")
			.clickUpdate();
	}

}
