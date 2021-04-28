package week2.day2.assignments.mandatory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]/a")).click();
		//driver.findElement(By.xpath("//ul[@class='shortcuts']//a/following::a[3]")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		String CompName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		CompName=CompName.replaceAll("[0-9()]", " ");
		System.out.println(CompName);

	}

}
