package week4.mandatory_assignment;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

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
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Open - Unassigned']")).click();
		//Switch to Frame
		driver.switchTo().frame("gsft_main");
		//Open Existing incident
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		//Assign the incident
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sys_display.incident.assignment_group")).clear();
		driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("Software",Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("sys_display.incident.assigned_to")).sendKeys("ITIL User",Keys.TAB);
		Thread.sleep(1500);
		//Update work notes
		driver.findElement(By.id("activity-stream-comments-textarea")).sendKeys("Updating incident with software group assignment");
		driver.findElement(By.xpath("//button[text()='Post']")).click();
		driver.findElement(By.id("sysverb_update_bottom")).click();
		//Search for created incident #
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(incidentNo,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Verification
		String assignedGroup=driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");

		if (assignedGroup.equals("Software")) {
			System.out.println("Incident is assigned");
		}

		driver.close();
	}

}
