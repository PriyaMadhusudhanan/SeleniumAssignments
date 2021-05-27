package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class UpdateRequestTest extends PreAndPost{
	@Test
	public void cancelRequestTest() throws InterruptedException {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("My Work")
			.clickOnMyWork()
			.switchToMainFrame()
			.searchWithRequestNumber("REQ0010258")
			.SelectExistingRequest()
			.selectLocation("Rhode Island")
			.selectDueDate()
			.clickUpdate();
	}
}
