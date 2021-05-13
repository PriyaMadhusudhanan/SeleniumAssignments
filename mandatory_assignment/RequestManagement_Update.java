package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RequestManagement_Update {

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
		driver.findElement(By.id("filter")).sendKeys("My work");
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		//Switch to Frame 
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("REQ0010047",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.id("sys_display.sc_request.location")).sendKeys("Rhode Island",Keys.TAB);
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		driver.findElement(By.xpath("//a[@aria-selected='true']//following::td/a")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		driver.findElement(By.id("sysverb_update")).click();
		
		//Search for created incident #
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		String location = driver.findElement(By.id("sys_display.sc_request.location")).getAttribute("value");
		String date = driver.findElement(By.id("sc_request.due_date")).getAttribute("value");
		if(location.equals("Rhode Island")&& !date.equals("")) {
			System.out.println("Request is Updated");
		}

	}

}
