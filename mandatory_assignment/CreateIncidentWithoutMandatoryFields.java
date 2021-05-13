package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncidentWithoutMandatoryFields {

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
		//Click on Submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		//Verification
		String text = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
		
		if (text.equals("The following mandatory fields are not filled in: Short description")) {
			System.out.println("Test case is passed");
		}
		
		driver.close();
	}

}
