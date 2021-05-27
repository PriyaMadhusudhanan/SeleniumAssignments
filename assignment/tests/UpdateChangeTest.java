package week6.assignment.tests;

import org.testng.annotations.Test;

import week6.assignment.pages.LoginPage;
import week6.assignment.testnghooks.PreAndPost;

public class UpdateChangeTest extends PreAndPost {
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
			.typeChangeID("CHG0031102")
			.selectChangeToBeOpened()
			.clickScheduleTab()
			.selectPlannedStartDate()
			.selectPlannedEndDate()
			.checkCabRequiredCheckBox()
			.selectCabDate()
			.clickUpdate();

	}
}
