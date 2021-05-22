package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
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
	
	
	@Then("Verify title for successful login {string}")
	public void isLoginSuccess(String actualTitle) {
		String title = driver.getTitle();
		if(title.equals(actualTitle)) {
			System.out.println("Login is successful");
		}
	}
	
	@Then("Verify error message {string}")
	public void isLoginFailure(String actualErrorMessage) {
		String errorMessage = driver.findElement(By.xpath("//div[@id='errorDiv']/p[2]")).getText();
		if(errorMessage.equals(actualErrorMessage)) {
			System.out.println("Login is failure with following error message: "+errorMessage);
		}
	}
	
}
