package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class CreateRequestTest extends PreAndPost{
	
	@Test
	public void createRequest() {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("My Work")
			.clickOnMyWork()
			.switchToMainFrame()
			.clickOnNewButton()
			.clickOnRequest()
			.typeDescription()
			.clickSubmit();
	}

}
