package week7.pages;

import week7.hooks.TestNgHooks;

public class HomePage extends TestNgHooks {
	public LoginPage clickLogoutButton() {
		click(locateElement("class", "decorativeSubmit"));
		return new LoginPage();
	}
	
	public HomePage getMessage() {
		verifyPartialText(locateElement("tag", "h2"), "Welcome");
		return this;
	}
	
	public MyHomePage clickCrmsfaLink() {
		click(locateElement("link", "CRM/SFA"));
		return new MyHomePage();
	}
	
}
