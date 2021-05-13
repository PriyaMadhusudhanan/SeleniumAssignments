package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proposal_CreateProposal {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launching URL
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Switch to Frame
		driver.switchTo().frame("gsft_main");
		//Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		//Filter with Incidents
		driver.findElement(By.id("filter")).sendKeys("Proposal",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String proposal=driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("This is new proposal");driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		driver.findElement(By.id("sysverb_insert")).click();
		//Verification
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(proposal,Keys.ENTER);
		if(driver.findElement(By.xpath("//a[@class='linked formlink']")).isDisplayed()) {
			System.out.println("New Proposal is created");
		}
	}

}
