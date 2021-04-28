package week2.day2.assignments.mandatory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//a[@class='x-tab-right'])[3]")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("priya.madhu7373@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		if(title.equals("Duplicate Lead | opentaps CRM")) {
			System.out.println("Title is correct");
		}else {
			System.err.println("Title is not correct");
		}
		String FirstName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		String LastName = driver.findElement(By.id("createLeadForm_lastName")).getAttribute("value");
		driver.findElement(By.name("submitButton")).click();
		String Fname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String Lname = driver.findElement(By.id("viewLead_lastName_sp")).getText();

		if(FirstName.equals(Fname)&&LastName.equals(Lname)) {
			System.out.println("Duplicated lead name is same as captured name");
		}else {
			System.err.println("Duplicated lead name is not same as captured name");
		}
		driver.close();
	}

}
