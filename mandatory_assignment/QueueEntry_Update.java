package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QueueEntry_Update {

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
		driver.findElement(By.id("filter")).sendKeys("My work");
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		//Switch to Frame and click on new button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHAT0010028",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		Select state=new Select(driver.findElement(By.id("chat_queue_entry.state")));
		state.selectByVisibleText("Closed Abandoned");
		Select priority=new Select(driver.findElement(By.id("chat_queue_entry.priority")));
		priority.selectByVisibleText("1 - Critical");
		driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).clear();
		driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).sendKeys("PS Apache02",Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_update")).click();

		//Search for created incident #
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHAT0010028",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		String stateText = driver.findElement(By.xpath("//select[@id='chat_queue_entry.state']//option[@selected='SELECTED']")).getText();
		String priorityText = driver.findElement(By.xpath("//select[@id='chat_queue_entry.priority']//option[@selected='SELECTED']")).getText();
		String item=driver.findElement(By.id("sys_display.chat_queue_entry.cmdb_ci")).getAttribute("value");

		if(stateText.equals("Closed Abandoned")&&priorityText.equals("1 - Critical")&&item.equals("PS Apache02")) {
			System.out.println("Chat is configured");
		}

	}

}
