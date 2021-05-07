package week3.mandatory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver set up
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();

				//Launching erail web app
				driver.get("https://erail.in/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				//Unchecking sort on date check box
				driver.findElement(By.id("chkSelectDateOnly")).click();

				//Select From Station
				driver.findElement(By.id("txtStationFrom")).clear();
				driver.findElement(By.id("txtStationFrom")).sendKeys("MS");
				driver.findElement(By.xpath("//div[text()='Chennai Egmore']")).click();

				//Select To Station
				driver.findElement(By.id("txtStationTo")).clear();
				driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
				driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
				
				Thread.sleep(2000);
				
				List<String> trainName=new ArrayList<String>();

				List<WebElement> trains=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']/tbody/tr"));
				int count=trains.size();
				
				for (int i = 0; i < count; i++) {
					WebElement row=trains.get(i);
					String value=row.findElement(By.xpath("td[2]")).getText();
					trainName.add(value);
				}
				
				System.out.println("No of count in the List is:"+trainName.size());
				
				Set<String> noOfTrains=new LinkedHashSet<String>(trainName);
				System.out.println("No of count in the set is:"+noOfTrains.size());

	}

}
