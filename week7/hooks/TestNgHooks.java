package week7.hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import week7.utils.ExcelDataRead;
import week7.wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {
	@BeforeSuite
	public void init() {
		
	}
	
	@BeforeTest
	public void setupTest() {
		
	}
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod
	public void invoke() {
		startApp("chrome", "http://leaftaps.com/opentaps");
	}
	
	@AfterMethod
	public void close() {
		closeActiveBrowser();
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterSuite
	public void tearDown() {
		
	}
	
	@DataProvider(name="readExcelData")
	public Object[][] fetchData() {
		return ExcelDataRead.readExcelData("Create Lead");
	}
}


