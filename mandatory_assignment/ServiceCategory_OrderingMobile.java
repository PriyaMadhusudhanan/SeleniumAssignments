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

public class ServiceCategory_OrderingMobile {

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
		driver.findElement(By.xpath("//div[text()='Service Catalog']")).click();
		//Switch to Frame
		driver.switchTo().frame("gsft_main");
		//Click on Mobile
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		
		//Click on Apple iPhone 6s
		WebElement mobile=driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(mobile)).click();;
		//Switch to Frame
		//driver.switchTo().frame("gsft_main");
		//Place order
		Select allowance=new Select(driver.findElement(By.xpath("//div[@class='col-xs-6  form-field input_controls ']/select")));
		allowance.selectByValue("unlimited");
		Select color=new Select(driver.findElement(By.xpath("(//div[@class='col-xs-6  form-field input_controls ']/select)[2]")));
		color.selectByVisibleText("Rose Gold");
		Select storage=new Select(driver.findElement(By.xpath("(//div[@class='col-xs-6  form-field input_controls ']/select)[3]")));
		storage.selectByVisibleText("128GB [add $50.00]");
		driver.findElement(By.id("oi_order_now_button")).click();
		
		//verification
		String orderNo = driver.findElement(By.id("requesturl")).getText();
		if(!orderNo.isEmpty()) {
			System.out.println("Order is placed successfully and the order# is:"+orderNo);
		}
		
		driver.close();
	}

}
