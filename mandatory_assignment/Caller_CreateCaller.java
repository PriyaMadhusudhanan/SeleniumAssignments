package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Caller_CreateCaller {

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
		driver.findElement(By.id("filter")).sendKeys("Callers",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Priya");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Madhusudhanan");
		driver.findElement(By.id("sys_user.title")).sendKeys("Ms");
		driver.findElement(By.id("sys_user.email")).sendKeys("priya.madhu7373@gmail.com");
		driver.findElement(By.id("sys_user.phone")).sendKeys("9840447720");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9840447720");
		driver.findElement(By.id("sysverb_insert")).click();
		System.out.println("Caller is created");
		
	}

}
