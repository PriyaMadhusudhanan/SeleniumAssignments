package week3.mandatory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver set up
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Launching erail web app
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Select From Station
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS");
		driver.findElement(By.xpath("//div[text()='Chennai Egmore']")).click();
		
		//Select To Station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		
		//Unchecking sort on date check box
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(1000);
		
		Map<String,String> map = new LinkedHashMap<String,String>();
		
		
		WebElement table=driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> rows=table.findElements(By.xpath("//tr"));
		for (WebElement webElement : rows) {
			List<WebElement> cols=table.findElements(By.xpath("//tr/td"));
			for (WebElement webElement2 : cols) {
				if(webElement2.getText().startsWith("H")) {
					map.put(webElement2.getText(), webElement2.getText());
				}
			}
		}
		
		System.out.println(map);
		
		
	}

}
