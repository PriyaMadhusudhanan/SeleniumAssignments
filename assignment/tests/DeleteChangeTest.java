package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class DeleteChangeTest extends PreAndPost {
	@Test
	public void createChange() throws InterruptedException {
		new LoginPage()
			.moveToFrame()
			.typeUsername("admin")
			.typePassword("India@123")
			.clickLoginButton()
			.filter("Change")
			.openChange()
			.switchToFrame()
			.selectSearchWithNumber()
			.typeChangeID("CHG0031099")
			.selectChangeToBeOpened()
			.clickDeleteButton()
			.clickDeleteconfirmationButton();
	}
}
