package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident {

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
		//Update urgency and state
		Select urgency=new Select(driver.findElement(By.id("incident.urgency")));
		urgency.selectByVisibleText("1 - High");
		Select state=new Select(driver.findElement(By.id("incident.state")));
		state.selectByVisibleText("In Progress");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		//Search for created incident #
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(incidentNo,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//Verification
		String urgencyText=driver.findElement(By.xpath("//select[@id='incident.urgency']//option[@selected='SELECTED']")).getText();
		String stateText=driver.findElement(By.xpath("//select[@id='incident.state']//option[@selected='SELECTED']")).getText();
		
		if (urgencyText.equals("1 - High")) {
			if (stateText.equals("In Progress")) {
				System.out.println("Urgency and State is updated as expected");
			}
		} else {
			System.out.println("Urgency and State is not updated as expected");
		}
		
		
		driver.close();
	}

}
