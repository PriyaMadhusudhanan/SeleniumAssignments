package week7.pages;

import week7.hooks.TestNgHooks;


public class MyLeadsPage extends TestNgHooks{
	public CreateLeadPage clickCreateLeadMenu() {
		click(locateElement("link", "Create Lead"));
		return new CreateLeadPage();
	}
}
