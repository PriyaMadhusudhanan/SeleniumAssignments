package week4.mandatory_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeManagement_CreateChange {

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
		driver.findElement(By.id("filter")).sendKeys("Change");
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
		//Click on Normal
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[text()='Normal']")).click();
		//Capture change#
		String change=driver.findElement(By.name("change_request.number")).getAttribute("value");
		
		driver.findElement(By.id("change_request.short_description")).sendKeys("This is Change creation TC");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		//Verification
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		driver.switchTo().frame("gsft_main");
		Select search= new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		search.selectByVisibleText("Number");
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(change,Keys.ENTER);	
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (text.equals(change)) {
			System.out.println("Change is created successfully");
		}
	}

}
