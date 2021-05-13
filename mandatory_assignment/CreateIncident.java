package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident {

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
		//Switch to Frame and click on new button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		//Capture Incident#
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		//Update Description
		driver.findElement(By.id("incident.short_description")).sendKeys("This is TC001");
		//Click on SuincidentNobmit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		//Search for created incident #
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(incidentNo,Keys.ENTER);

		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if(text.equals(incidentNo)) {
			System.out.println("Incident is created");
		}else {
			System.out.println("Incident is not created");
		}
		System.out.println(incidentNo);
		//driver.close();
	}

}
