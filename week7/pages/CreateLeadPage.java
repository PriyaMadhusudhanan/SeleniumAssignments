package week7.pages;

import week7.hooks.TestNgHooks;

public class CreateLeadPage extends TestNgHooks{
	public CreateLeadPage typeCompanyName(String compName) {
		type(locateElement("id", "createLeadForm_companyName"), compName);
		return this;
	}
	
	public CreateLeadPage typeFirstName(String fName) {
		type(locateElement("id", "createLeadForm_firstName"), fName);
		return this;
	}
	

	public CreateLeadPage typeLastName(String lName) {
		type(locateElement("id", "createLeadForm_lastName"), lName);
		return this;
	}
	
	public CreateLeadPage typeEmail(String email) {
		type(locateElement("id", "createLeadForm_primaryEmail"), email);
		return this;
	}
	public CreateLeadPage typePhoneCountry(String phCountryCd) {
		type(locateElement("id", "createLeadForm_primaryPhoneCountryCode"), phCountryCd);
		return this;
	}
	public CreateLeadPage typePhoneArea(String phAreaCd) {
		type(locateElement("id", "createLeadForm_primaryPhoneAreaCode"), phAreaCd);
		return this;
	}
	public CreateLeadPage typePhoneNumber(String phNo) {
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), phNo);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton() {
		click(locateElement("class", "smallSubmit"));
		return new ViewLeadPage();
	}
	
}
