package week7.mandatoryassignment.hooks;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import week7.mandatoryassignment.utils.ExcelDataRead;
import week7.mandatoryassignment.wrappers.BaseDriver;



public class TestNgHooks extends BaseDriver {

	public String dataSheetName;		

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return ExcelDataRead.readExcelData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		startApp("chrome", "https://dev103117.service-now.com");
		setNode();
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}













}
