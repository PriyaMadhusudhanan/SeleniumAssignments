package week4.mandatory_assignment;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

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
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		//Switch to Frame
		driver.switchTo().frame("gsft_main");
		//Open Existing incident
		String incidentNo=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//Delete incident
		driver.findElement(By.xpath("//button[text()='Delete']")).click();	
		
		driver.findElement(By.id("ok_button")).click();
		
		//Search for created incident #
		System.out.println(driver.findElement(By.xpath("//div[@class='input-group']//input")).isDisplayed());

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='input-group']//input"))));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='input-group']//input")).isDisplayed());
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(incidentNo,Keys.ENTER);

		//Verification
		if (driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed()) {
			System.out.println("Incident is Deleted");
		}
		
		driver.close();
	}

}
