package week6.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import week6.assignment.testnghooks.PreAndPost;

public class ChangeRequestsPage extends PreAndPost{
	public ChangeRequestsPage switchToFrame() {
		driver.switchTo().frame("gsft_main");
		return this;
	}
	
	public ChangeRequestsPage selectSearchWithNumber() {
		Select search= new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		search.selectByVisibleText("Number");
		return this;
	}
	
	public ChangeRequestsPage typeChangeID(String ChangeID) {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(ChangeID,Keys.ENTER);
		return this;
	}
	
	public ChangeRequestPage selectChangeToBeOpened() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new ChangeRequestPage();
	}
}
