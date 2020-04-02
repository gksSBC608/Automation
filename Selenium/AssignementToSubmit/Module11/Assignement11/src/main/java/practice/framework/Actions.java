/**
 * 
 */
package practice.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import practice.util.Config;

/**
 * @author M1030608
 *
 */
public class Actions {

	private static WebDriver driver;

	/**
	 * 
	 */
	public Actions() {
		// TODO Auto-generated constructor stub
	}

	public Actions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", Config.DRIVER_PATH + "chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void closeBrowser() {

		driver.close();
	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();

	}

	public static void implementWait() {

		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

	}

	public static void navigate(String website) {

		driver.navigate().to(website);

	}

	public static void enterValueInTextbox(String locator, String locatorValue, String parameter) {
		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
			driver.findElement(By.id(locatorValue)).sendKeys(parameter);
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
			driver.findElement(By.name(locatorValue)).sendKeys(parameter);
		} else if (locator.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(parameter);
		}

	}

	public static void clickButton(String locator, String locatorValue) {
		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else if (locator.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
	}

	public static void validateMessage(String locator, String locatorValue, String textToValidate) {
		boolean result = false;
		String text = "";
		if (locator.equalsIgnoreCase("NA")) {
			result = driver.getPageSource().contains(textToValidate);

		} else {
			if (locator.equalsIgnoreCase("id")) {
				text = driver.findElement(By.id(locatorValue)).getText();
			} else if (locator.equalsIgnoreCase("name")) {
				text = driver.findElement(By.name(locatorValue)).getText();
			} else if (locator.equalsIgnoreCase("css")) {
				text = driver.findElement(By.cssSelector(locatorValue)).getText();
			}
			result = text.equalsIgnoreCase(textToValidate);
		}
		Assert.assertTrue(result);

	}

	public static boolean validateTitle(String title) {
		return title.equalsIgnoreCase(driver.getTitle());
	}

}
