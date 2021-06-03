package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class UpdateChangeTest extends TestNgHooks {
	@BeforeTest
	public void setValues() {
		testCaseName = "Update Change request";
		testDescription = "Update existing change";
		nodes = "Change Management";
		authors = "Priya";
		category = "smoke";
		dataSheetName = "Update Change";
	}
	@Test(dataProvider="fetchData")
	public void createChange(String uid, String pwd, String filter, String search, String changeID) throws InterruptedException {
		new LoginPage()
			.moveToFrame()
			.typeUsername(uid)
			.typePassword(pwd)
			.clickLoginButton()
			.filter(filter)
			.openChange()
			.switchToFrame()
			.selectSearchWithNumber(search)
			.typeChangeID(changeID)
			.selectChangeToBeOpened()
			.clickScheduleTab()
			.selectPlannedStartDate()
			.selectPlannedEndDate()
			.checkCabRequiredCheckBox()
			.selectCabDate()
			.clickUpdate();

	}
}
