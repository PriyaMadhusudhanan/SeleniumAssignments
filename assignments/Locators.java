package week2.day1.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {
		//Driver Set up
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//Launching Testleaf webpage
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Log in
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Create Lead link to create the new lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter all the info
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Syntel");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Madhusudhanan");
		WebElement eleSelectSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select s1=new Select(eleSelectSource);
		s1.selectByVisibleText("Partner");
		WebElement eleMktCmpgn=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select s2=new Select(eleMktCmpgn);
		s2.selectByVisibleText("Automobile");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Madhusudhanan");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("07/14/1994");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Accounts");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("1000000");
		WebElement eleCurrency=driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select s3=new Select(eleCurrency);
		s3.selectByVisibleText("INR - Indian Rupee");
		WebElement eleIndustry=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select s4=new Select(eleIndustry);
		s4.selectByVisibleText("Finance");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");
		WebElement eleOwnership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select s5=new Select(eleOwnership);
		s5.selectByVisibleText("Partnership");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("715071");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("####");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Its Week 2 and day 1 assignment");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Its Week 2 and day 1 mandatory assignment");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("44225185");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("123");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("priya.madhu7373@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://google.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Priya M");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("2/73, 2nd St");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Nehru Nagar");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalCountryGeoId")).sendKeys("India");
		WebElement eleState=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select s6=new Select(eleState);
		s6.selectByVisibleText("TAMILNADU");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600100");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("001");
		
		//Click on Create lead button to create new lead
		driver.findElement(By.name("submitButton")).click();
		
		//Click on Duplicate lead, modify company name and submit
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Atos Syntel Pvt Ltd");
		driver.findElement(By.name("submitButton")).click();
		
		//Get only updated company name
		String compName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String orgName1 = compName.replaceAll("[0-9()]", "");
		String orgName=orgName1.trim();
		System.out.println(orgName);
		
		//Verify whether modified company name got updated properly
		if(orgName.equals("Atos Syntel Pvt Ltd")) {
			System.out.println("Company name is verified");
		}else {
			System.err.println("Company name is updated wrongly");
		}
		
		driver.close();

	}

}
