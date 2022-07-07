package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseCode {

	public static WebDriver driver;
	private static String projectFilePath = System.getProperty("user.dir");
	private Properties properties;

	@BeforeTest
	@Parameters({ "system.properties.path"})
	public void testInitialization(String propertyFile) {
		System.out.println("Starting the test.");
		String propertyFilePath = projectFilePath + "\\resources\\propertyFiles\\" + propertyFile + ".properties";
		loadPropertyFile(propertyFilePath);
	}
	
	@AfterTest
	public void testCleanUp() {
		closeBrowser();
	}

	public void openBrowserAndURL() {
		try {
			String url = getPropertyValue("app.url");
			System.setProperty("webdriver.chrome.driver",
					projectFilePath + "\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Opened Chrome browser.");
			driver.get(url);
			System.out.println(url + " - URL has been opened.");
		} catch (Exception e) {
			System.out.println("*** Failed opening the browser and URL.");
			Assert.fail(e.getMessage());
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
			driver.quit();
			System.out.println("Closing browser.");
			System.out.println("Ending the test.");
		} catch (Exception e) {
			System.out.println("*** Failed closing the browser");
			Assert.fail(e.getMessage());
		}
	}

	public void pause(Integer seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyPageElementDisplayed(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			System.out.println("PASSED: Element '" + locator + "' is displayed in the screen.");
		} catch (NoSuchElementException e) {
			System.out.println("*** FAILED: Page element '" + locator + "' is NOT displayed in the screen.");
			Assert.fail("");
		}
	}

	public void verifyTextInPageElement(String locator, String expectedValue) {
		try {
			String actualValue = findElement(locator).getText();

			if (expectedValue.equals(actualValue)) {
				System.out.println("PASSED: Value '" + expectedValue + "' is displayed in" + " page element " + locator
						+ " in the screen.");
			} else {				
				System.out.println("*** FAILED: Value '" + expectedValue + "' is NOT displayed in" + " page element " + locator
						+ " in the screen. Actual value is '" + actualValue +"'.");
				Assert.fail("");
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public void verifyValueInPageElement(String locator, String expectedValue) {
		try {
			String actualValue = findElement(locator).getAttribute("placeholder");

			if (expectedValue.equals(actualValue)) {
				System.out.println("PASSED: Value '" + expectedValue + "' is displayed in" + " page element " + locator
						+ " in the screen.");
			} else {
				System.out.println("*** FAILED: Value '" + expectedValue + "' is NOT displayed in" + " page element " + locator
						+ " in the screen. Actual value is '" + actualValue +"'.");
				Assert.fail("");
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyCurrentURL(String urlToCheck) {
		try {
			String actualURL = driver.getCurrentUrl();

			if (urlToCheck.equals(actualURL)) {
				System.out.println("PASSED: Value '" + urlToCheck + "' is the current page.");
			} else {
				System.out.println("*** FAILED: Value '" + urlToCheck + "' is NOT the current URL. Actual value is '"
						+ actualURL + "'.");
				Assert.fail("");
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void click(String locator) {
		try {
			WebElement element = findElement(locator);
			element.click();
			System.out.println("PASSED: Page element '" + locator + "' has been clicked.");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void inputValue(String locator, String value) {
		try {
			WebElement element = findElement(locator);
			element.clear();
			element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			element.sendKeys(value);
			System.out.println("PASSED: Page element '" + locator + "' has been entered with value '" + value + "'.");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void waitForPageElementToLoad(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} catch (NoSuchElementException e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			Assert.fail(e.getMessage());
		}
	}

	public WebElement findElement(String locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} catch (NoSuchElementException e) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			Assert.fail(e.getMessage());
		}
		return element;
	}
	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(findElement(frame));
	}
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void loadPropertyFile(String propertyFile){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFile));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFile);
		}		
	}
	
	public String getPropertyValue(String property) {		
		String value = properties.getProperty(property);		
		return value;
	}

}
