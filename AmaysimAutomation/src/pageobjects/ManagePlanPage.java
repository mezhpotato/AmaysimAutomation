package pageobjects;

import common.BaseCode;

public class ManagePlanPage extends BaseCode {
	
	public String manageAPlanHeader() {
		return "//div[normalize-space(text())='manage plan']";
	}
	
	public String referAFriendMenu() {
		return "//a[text()='Refer a friend']";
	}

	public void clickReferAFriendMenu() {
		click(referAFriendMenu());		
	}

}
