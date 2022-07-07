package pageobjects;

import common.BaseCode;

public class ReferAFriendPage extends BaseCode {
	
	public String referAFriendMessage1() {
		return "//*[@id='e']/span/p";
	}
	
	public String referAFriendMessage2() {
		return "//*[@id='f']/span/p";
	}
	
	public String referAFriendMessage3() {
		return "//*[@id='g']/span/p";
	}
	
	public String referAFriendMessage4() {
		return "//*[@id='m']/span/p";
	}
	
	public String emailAddressTextbox() {
		return "//input[@id='a']";
	}
	
	public String emailMessageTextbox() {
		return "//textarea[@id='b']";
	}
	
	public String shareButton() {
		return "//span/p[text()='Share']";
	}
	
	public String shareAgainButton() {
		return "//span/p[text()='Share Again']";
	}
	
	public String termsLink() {
		return "//div[text()='Terms']";
	}
	
	public String referAFriendSuccessMessage1() {
		return "//*[@id='A']/span/p";
	}
	
	public String referAFriendSuccessMessage2() {
		return "//*[@id='r']/span/p";
	}
	
	public String referAFriendSuccessMessage3() {
		return "//*[@id='r']/span/p[3]";
	}
	
	public void inputEmailAddress(String emails) {
		inputValue(emailAddressTextbox(), emails);
	}
	
	public void inputEmailMessage(String message) {
		inputValue(emailMessageTextbox(), message);
	}

	public void clickShareButton() {
		click(shareButton());		
	}

}
