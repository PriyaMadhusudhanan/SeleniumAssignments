package week7.mandatoryassignment.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.mandatoryassignment.hooks.TestNgHooks;
import week7.mandatoryassignment.pages.LoginPage;


public class AssessChangeTest extends TestNgHooks{
	@BeforeTest
	public void setValues() {
		testCaseName = "Assess change";
		testDescription = "Update status of change as Assess";
		nodes = "Change Management";
		authors = "Priya";
		category = "smoke";
		dataSheetName = "Assess Change";
	}
	@Test(dataProvider = "fetchData")
	public void createChange(String uid, String pwd, String filter, String search, String changeID, String status, String group, String assignedTo) throws InterruptedException {
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
			.selectStatusAsAssess(status)
			.typeAssignmentGroup(group)
			.typeAssignedTo(assignedTo)
			.clickUpdate();
	}
}