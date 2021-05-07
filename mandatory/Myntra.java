package week3.mandatory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		//Driver set up
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Launching web app
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Using actions class and methods for mousehover
		Actions actions=new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//a[text()='Women']"));
		Action mouseOver= actions.moveToElement(menu).build();
		mouseOver.perform();
		Thread.sleep(1000);
		WebElement subMenu=driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Jackets & Coats']"));
		Action click=actions.moveToElement(subMenu).click().build();
		click.perform();
		Thread.sleep(2000);
		//Get total count of Item
		String items= driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String itemCount=items.replaceAll("\\D", "").trim();
		driver.findElement(By.xpath("//span[@class='categories-num']")).isDisplayed();
		String jackets= driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String jacketsCount=jackets.replaceAll("\\D", "").trim();
		String coats= driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String coatsCount=coats.replaceAll("\\D", "").trim();
		int overallCount=Integer.parseInt(itemCount);
		int jacketCount=Integer.parseInt(jacketsCount);
		int coatCount=Integer.parseInt(coatsCount);
		if(overallCount==jacketCount+coatCount) {
			System.out.println("The sum of Categories and overall count are getting matched");
		}else {
			System.out.println("The sum of Categories and overall count are not getting matched");
		}
		
		
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']//div")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		WebElement sort=driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Action sortMouseHover=actions.moveToElement(sort).build();
		sortMouseHover.perform();
		
		driver.findElement(By.xpath("//ul[@class='sort-list']//label[text()='Better Discount']")).click();
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//li[@class='product-base']//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of the first item is:"+price);
		WebElement size= driver.findElement(By.xpath("//li[@class='product-base']/a"));
		Action sizeMouseHover=actions.moveToElement(size).build();
		sizeMouseHover.perform();
		
		driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']")).click();
		driver.close();
	}

}
