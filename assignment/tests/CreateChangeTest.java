package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class CreateChangeTest extends PreAndPost {
	@Test
	public void createChange() {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("Change")
			.clickOnChange()
			.switchToMainFrame()
			.clickOnNormalButton()
			.typeShortDespriptions()
			.clickSubmit();
	}
}
