package week6.assignment.pages;

import org.openqa.selenium.By;

import week6.assignment.testnghooks.PreAndPost;

public class CreateChangeRequestPage extends PreAndPost{
	public CreateChangeRequestPage switchToMainFrame() {
		driver.switchTo().frame("gsft_main");
		return this;
	}
	public ChangeRequestPage clickOnNormalButton() {
		driver.findElement(By.xpath("//span[text()='Normal']")).click();
		return new ChangeRequestPage();
	}
}
