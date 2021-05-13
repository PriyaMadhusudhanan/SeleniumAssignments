package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QueueEntry_Create {

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
		driver.findElement(By.id("filter")).sendKeys("My work");
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		//Switch to Frame and click on new button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("//a[@href='wizard_view.do?sys_action=sysverb_wizard_ans&WIZARD:action=follow&wiz_referring_url=task_list.do?sys_id=-1@99@sys_target=task@99@sysparm_fixed_query=@99@sysparm_group_sort=@99@sysparm_parent=e56db0c76d2220100acb70b3534330b7@99@sysparm_query=active%3dtrue%5eassigned_to%3djavascript%3agetMyAssignments()%5estate!%3d-5@99@sysparm_target=@99@sysparm_view=&wiz_collection_key=&wiz_collectionID=&wiz_collection=&wiz_collection_related_field=&wiz_view=&wiz_action=sysverb_new&sys_id=4f7db4c76d2220100acb70b353433083&sysparm_query=active=true^assigned_to=javascript:getMyAssignments()^state!=-5&sysparm_target=&sys_target=task']")).click();
		//Capture Incident#
		String chatNo = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert")).click();
		//Search for created incident #
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(chatNo,Keys.ENTER);
		

		if(driver.findElement(By.xpath("//a[@class='linked formlink']")).isDisplayed()) {
			System.out.println("Chat is created");
		}

	}

}
