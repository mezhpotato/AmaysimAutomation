package tests;

import org.testng.annotations.Test;

import common.BaseCode;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ManagePlanPage;
import pageobjects.ReferAFriendPage;

public class SuccessfulReferAFriendTest extends BaseCode {	
	
	@Test
	public void test() {
		//Input Parameters
		String number = getPropertyValue("app.username"); //0466134574
		String simPlan = "UNLIMITED 10GB";
		String password = getPropertyValue("app.password"); //AWqasde321
		String referralEmail = "sample@email.com";
		String referralMessage = "sample message";
		
		System.out.println("Test Case: MyAmaysim: Refer A Friend");
		System.out.println("Test Description: Script will Login to the application and peform the basic function of a successful 'Refer A Friend' functionality.");
		
		//Open HomeURL
		openBrowserAndURL();
		pause(5); //Added pause to avoid unexpected loading error during runtime
		
		//Click Accounts link to navigate to Login Page
		System.out.println("Step: Click Accounts link to navigate to Login Page and click the Account link.");
		HomePage homePage = new HomePage();
		homePage.clickAccountLink();		
		
		pause(8);//Added pause to avoid unexpected loading error during runtime
		LoginPage loginPage = new LoginPage();
		//Verify Login Header is displayed
		verifyPageElementDisplayed(loginPage.loginToAmaysimHeader());
		
		//Login to the application		
		System.out.println("Step: User logs-in to the application.");
		loginPage.loginToAmaysim(number, password); 		
				
		pause(5); //Added pause to avoid unexpected loading error during runtime
		AccountPage accountPage = new AccountPage();
		//Verify Welcome Message is displayed
		verifyTextInPageElement(accountPage.welcomeMessageHeader(),"Welcome back!");
		//click on an existing service		
		System.out.println("Step: User selects and click a Service/ Plan.");
		accountPage.clickSimAService(simPlan);		
		
		pause(8); //Added pause to avoid unexpected loading error during runtime
		ManagePlanPage managePlanPage = new ManagePlanPage();		
		//Verify Welcome Message is displayed
		verifyPageElementDisplayed(managePlanPage.manageAPlanHeader());
		//Click 'Refer a Friend' in the side menu
		System.out.println("Step: User navigates to 'Refer a Friend' page.");
		managePlanPage.clickReferAFriendMenu();
		
		//Verify 'refer a friend' header is displayed
		pause(5); //Added pause to avoid unexpected loading error during runtime

		ReferAFriendPage referAFriendPage = new ReferAFriendPage();
		switchToFrame("//*[contains(@id,'fb')]"); //Switched to frame to be able to execute the steps below
		System.out.println("Step: Verify the texts and fields displayed in the 'Refer a Friend' page.");
		waitForPageElementToLoad(referAFriendPage.referAFriendMessage1());
		verifyTextInPageElement(referAFriendPage.referAFriendMessage1(), "GET $10 IN ACCOUNT CREDIT FOR EVERY FRIEND YOU REFER");
		verifyTextInPageElement(referAFriendPage.referAFriendMessage2(), "Give your friends $10 in account credit and you'll also get $10 in account credit when they sign up");
		verifyTextInPageElement(referAFriendPage.referAFriendMessage3(), "Send your friends an email");
		verifyTextInPageElement(referAFriendPage.referAFriendMessage4(), "By clicking SHARE, you confirm that you have their consent to sharing their email address");		
		
		//Verify 'Refer a Friend' fields displayed
		verifyPageElementDisplayed(referAFriendPage.emailAddressTextbox()); //Email address field
		verifyValueInPageElement(referAFriendPage.emailAddressTextbox(), "Send to (comma separated)"); //Verify place holder text		
		verifyPageElementDisplayed(referAFriendPage.emailMessageTextbox()); //Email message field
		verifyValueInPageElement(referAFriendPage.emailMessageTextbox(), "Heard of amaysim? They have amazing SIM-only mobile plans you'll love AND I'm giving you $10 in account credit when you sign up!"); //Verify place holder text
		verifyPageElementDisplayed(referAFriendPage.shareButton()); //Share button
		verifyPageElementDisplayed(referAFriendPage.termsLink()); //Terms link
		
		System.out.println("Step: Enter valid email and message then click the Share button.");
		//Enter email addresses for referral		
		referAFriendPage.inputEmailAddress(referralEmail);
		//Enter email message for referral
		referAFriendPage.inputEmailMessage(referralMessage);
		//click Share button
		referAFriendPage.clickShareButton();
		
		pause(5); //Added pause to avoid unexpected loading error during runtime
		System.out.println("Step: Verify the confirmation message displayed in the 'Refer a Friend' page after clicking Share button.");
		//Verify 'refer a friend' completion message
		verifyTextInPageElement(referAFriendPage.referAFriendSuccessMessage1(), "THANKS FOR SHARING THE BIG LOVE");
		verifyTextInPageElement(referAFriendPage.referAFriendSuccessMessage2(), "Once your friend signs up you'll find your $10 credit in your account.");
		verifyTextInPageElement(referAFriendPage.referAFriendSuccessMessage3(), "Don’t stop there! The more you share the more rewards you’ll get!");
		//Verify element is displayed
		verifyPageElementDisplayed(referAFriendPage.shareAgainButton()); //Share Again button
	}
}
