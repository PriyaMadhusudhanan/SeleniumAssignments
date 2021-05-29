package week7.tests;

import org.testng.annotations.Test;

import week7.hooks.TestNgHooks;
import week7.pages.LoginPage;

public class LoginTest extends TestNgHooks {
	@Test
	public void login() {
		new LoginPage()
			.typeUserName("DemoSalesManage")
			.typePassword("crmsfa")
			.clickLoginButton()
			.getMessage();
	}
}
