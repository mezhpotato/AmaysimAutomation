package pageobjects;

import common.BaseCode;

public class AccountPage extends BaseCode {
	
	public String welcomeMessageHeader() {
		return "//span[@id='WelcomeMessage']";
	}
	
	public String simServiceItem(String service) {
		return "//div[@id='service_tile_mobile']//div[text()='"+service+"']";
	}

	public void clickSimAService(String service) {
		click(simServiceItem(service));		
	}

}
