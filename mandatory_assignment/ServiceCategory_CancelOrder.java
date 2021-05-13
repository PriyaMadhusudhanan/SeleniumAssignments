package week4.mandatory_assignment;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceCategory_CancelOrder {

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
		driver.findElement(By.id("filter")).sendKeys("Service Catalog");
		driver.findElement(By.xpath("//div[text()='Requests']")).click();
		
		//Switch to Frame
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("REQ0010037",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		Select approval=new Select(driver.findElement(By.id("sc_request.approval")));
		approval.selectByVisibleText("Rejected");
		Select requestState=new Select(driver.findElement(By.id("sc_request.request_state")));
		requestState.selectByVisibleText("Closed Cancelled");

		driver.findElement(By.xpath("//button[text()='Cancel Request']")).click();
		System.out.println("The order is cancelled");
		driver.close();
	}

}
