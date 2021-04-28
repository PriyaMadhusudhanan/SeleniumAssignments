package week2.day2.assignments.mandatory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Priya");
		driver.findElement(By.id("lastNameField")).sendKeys("Madhusudhanan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Priya");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Madhusudhanan");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Account");
		driver.findElement(By.id("createContactForm_description")).sendKeys("This is selenium assignment");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test@gmail.com");
		WebElement state=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select s1=new Select(state);
		s1.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is Selenium Assignment of week 2");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title=driver.getTitle();
		System.out.println("The title of the current page is:"+title);

	}

}
