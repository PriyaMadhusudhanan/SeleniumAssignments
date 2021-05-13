package week4.mandatory_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeManagement_UpdateSchedule {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.id("filter")).sendKeys("Change");
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		driver.switchTo().frame("gsft_main");
		
		Select search= new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		search.selectByVisibleText("Number");
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHG0000030",Keys.ENTER);	
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.xpath("//span[text()='Schedule']")).click();
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		driver.findElement(By.id("GwtDateTimePicker_day17")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
		driver.findElement(By.id("GwtDateTimePicker_day41")).click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		driver.findElement(By.xpath("(//span[@class='input-group-checkbox'])[2]")).click();
		driver.findElement(By.id("change_request.cab_date.ui_policy_sensitive")).click();
		driver.findElement(By.id("GwtDateTimePicker_day40")).click();
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		
		//Verification
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHG0000030",Keys.ENTER);	
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String startDate = driver.findElement(By.id("change_request.start_date")).getAttribute("value");
		String endDate = driver.findElement(By.id("change_request.end_date")).getAttribute("value");
		String cabRequired = driver.findElement(By.id("ni.change_request.cab_required")).getAttribute("checked");
		String cabDate = driver.findElement(By.id("change_request.cab_date")).getAttribute("value");
		
		if (startDate!="" &&endDate!=""&&cabRequired!=""&&cabDate!="") {
			System.out.println("Schedule update is done");
		}
		
	}

}
