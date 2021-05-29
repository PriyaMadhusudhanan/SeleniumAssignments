package week7.tests;

import org.testng.annotations.Test;

import week7.hooks.TestNgHooks;
import week7.pages.LoginPage;



public class CreateLeadTest extends TestNgHooks{
	@Test(dataProvider="readExcelData")
	public void createLead(String compName,String fName,String lName,String MailID, String phCountryCd, String phAreaCd, String phNo) {
		new LoginPage()
		.typeUserName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLoginButton()
		.getMessage()
		.clickCrmsfaLink()
		.clickLeadsTab()
		.clickCreateLeadMenu()
		.typeCompanyName(compName)
		.typeFirstName(fName)
		.typeLastName(lName)
		.typeEmail(MailID)
		.typePhoneCountry(phCountryCd)
		.typePhoneArea(phAreaCd)
		.typePhoneNumber(phNo)
		.clickCreateLeadButton()
		.verifyLeadIsCreated();
	}
}
