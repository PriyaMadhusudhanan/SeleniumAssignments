package week4.mandatory_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeManagement_AssessChange {

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
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHG0000033",Keys.ENTER);	
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		Select status= new Select(driver.findElement(By.id("change_request.state")));
		status.selectByVisibleText("Assess");
		
		driver.findElement(By.id("sys_display.change_request.assignment_group")).sendKeys("Software",Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("sys_display.change_request.assigned_to")).sendKeys("ITIL User",Keys.TAB);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		//Verification
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHG0000033",Keys.ENTER);	
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String selectedState = driver.findElement(By.xpath("//select[@id='change_request.state']//option[@selected='SELECTED']")).getText();
		String assignedTo = driver.findElement(By.id("sys_display.change_request.assigned_to")).getAttribute("value");
		
		if (selectedState.equals("Assess")&&assignedTo.equals("ITIL User")) {
			System.out.println("State and Assigned to updates are done");
		}
	}

}
