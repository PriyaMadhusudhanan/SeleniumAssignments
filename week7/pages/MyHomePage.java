package week7.pages;

import week7.hooks.TestNgHooks;


public class MyHomePage extends TestNgHooks{
	public MyLeadsPage clickLeadsTab() {
		click(locateElement("link", "Leads"));
		return new MyLeadsPage();
	}
}
