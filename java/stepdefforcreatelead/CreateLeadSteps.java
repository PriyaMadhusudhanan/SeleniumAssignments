package stepdefforcreatelead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadSteps {
ChromeDriver driver;
	
	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	@When("Load URL {string}")
	public void loadURL(String url) {
		driver.get(url);
	}
	
	@And("Type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@And("Type password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("click on Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@And("click on CRMSFA link")
	public void clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click on Leads button")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@When("Click on Create Lead link")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@And("Type Company name as (.*)$")
	public void TypeCompanyName(String CompName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompName);
	}
	@And("Type First name as (.*)$")
	public void TypeFirstName(String FName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
	}
	@And("Type Last name as (.*)$")
	public void TypeLastName(String LName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
	}
	
	@And("Click on Create Lead button")
	public void clickOnCreateLead() {
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	}
	
	@Then("Verify Lead is created successfully")
	public void isLeadCreated() {
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Lead is created :"+text);
	}
}
