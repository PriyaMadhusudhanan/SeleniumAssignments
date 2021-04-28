package week2.day2.assignments.mandatory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Priya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("Title is verified");
		}else {
			System.err.println("Title is wrong");
		}
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Atos Syntel India PVT LTD");
		driver.findElement(By.name("submitButton")).click();
		String compName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		compName=compName.replaceAll("[0-9()]", " ").trim();
		if(compName.equals("Atos Syntel India PVT LTD")) {
			System.out.println("Company name got updated properly");
		}else {
			System.err.println("Company name is not updated properly");
		}
		driver.close();
	}

}
