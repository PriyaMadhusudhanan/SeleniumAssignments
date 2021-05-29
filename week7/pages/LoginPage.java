package week7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week7.hooks.TestNgHooks;

public class LoginPage extends TestNgHooks{
	public LoginPage typeUserName(String uid) {	
		type(locateElement("id", "username"), uid);
		return this;
	}
	
	public LoginPage typePassword(String pwd) {
		type(locateElement("id", "password"), pwd);
		return this;
	}
	
	public HomePage typePasswordAndEnter() {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);
		return new HomePage();
	}
	
	public HomePage clickLoginButton() {
		click(locateElement("class", "decorativeSubmit"));
		return new HomePage();
	}
	
	public LoginPage clickLoginButtonWithInvalidCredentials() {
		click(locateElement("class", "decorativeSubmit"));
		return this;
	}
	
}
