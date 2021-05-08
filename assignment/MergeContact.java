package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//Launching URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Login
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Click on Merge Contract
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		//Click on from Contact icon
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();

		//Window handles
		Set<String> allWindows=driver.getWindowHandles();
		List<String> listOfWindows=new ArrayList<String>(allWindows);

		//Move to From Contact window
		driver.switchTo().window(listOfWindows.get(1));

		//Select the first contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//Switch control to parent window
		driver.switchTo().window(listOfWindows.get(0));

		//Click on To Contact icon
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		
		//Getting current windows
		allWindows=driver.getWindowHandles();
		listOfWindows=new ArrayList<String>(allWindows);

		//Move to To Contact window
		driver.switchTo().window(listOfWindows.get(1));

		//Select the first contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

		//Switch control to parent window
		driver.switchTo().window(listOfWindows.get(0));
		
		//Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Confirm the title
		System.out.println(driver.getTitle());

	}

}
