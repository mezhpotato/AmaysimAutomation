package pageobjects;

import common.BaseCode;

public class HomePage extends BaseCode {
	
	public String accountLink() {
		return "//span[text()='Account']";
	}
		
	public void clickAccountLink() {
		click(accountLink());		
	}

}
