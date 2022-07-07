package pageobjects;

import common.BaseCode;

public class LoginPage extends BaseCode {
	
	public String loginToAmaysimHeader() {
		return "//h1[normalize-space(text())='Login to amaysim']";
	}
	
	public String usernameTextbox() {
		return "//input[@id='username']";
	}
	public String passwordTextbox() {
		return "//input[@id='password']";
	}
	public String loginButton() {
		return "//button[text()='Login']";
	}
		
	public void inputUsername(String username) {
		inputValue( usernameTextbox(), username);
	}
	
	public void inputPassword(String password) {
		inputValue(passwordTextbox(), password);
	}
	
	public void clickALoginButton() {
		click(loginButton());		
	}
	
	public void loginToAmaysim(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		clickALoginButton();
	}

}
