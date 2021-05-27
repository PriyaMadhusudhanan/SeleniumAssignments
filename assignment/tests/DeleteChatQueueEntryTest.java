package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class DeleteChatQueueEntryTest extends PreAndPost{
	
	@Test
	public void createChatQueueEntry() {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("My Work")
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber("CHAT0010084")
			.SelectExistingChatQueueEntry()
			.clickDelete()
			.clickOnDeleteConfirmation();
	}

}
