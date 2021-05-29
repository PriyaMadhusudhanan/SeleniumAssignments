package week7.pages;

import week7.hooks.TestNgHooks;

public class ViewLeadPage extends TestNgHooks {
	public ViewLeadPage verifyLeadIsCreated() {
		verifyPartialTitle("View Lead");
		return this;
	}
}
