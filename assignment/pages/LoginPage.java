package week6.assignment.pages;

import org.openqa.selenium.By;

import week6.assignment.testnghooks.PreAndPost;

public class LoginPage extends PreAndPost{
	public LoginPage moveToFrame() {
		driver.switchTo().frame("gsft_main");
		return this;
	}
	public LoginPage typeUsername(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
		return this;
	}
	public LoginPage typePassword(String pwd) {
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		return this;
	}
	public HomePage clickLoginButton() {
		driver.findElement(By.id("sysverb_login")).click();
		return new HomePage();
	}
}
