package week7.mandatoryassignment.pages;

import week7.mandatoryassignment.hooks.TestNgHooks;


public class LoginPage extends TestNgHooks{
	public LoginPage moveToFrame() {
		switchToFrame("gsft_main");
		return this;
	}
	public LoginPage typeUsername(String username) {
		clearAndType(locateElement("id", "user_name"), username);
		return this;
	}
	public LoginPage typePassword(String pwd) {
		clearAndType(locateElement("id", "user_password"), pwd);
		return this;
	}
	public HomePage clickLoginButton() {
		click(locateElement("id", "sysverb_login"));
		return new HomePage();
	}
}
