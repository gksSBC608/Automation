package com.assignment.module7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	private static String driverPath = "driver/";
	private static WebDriver driver;
	private static WebDriverWait wait;

	public static void main(String[] args) {

		String navigationLink = "https://www.google.com/gmail/about/#";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 35);

		navigate(navigationLink);
		clickSigInLink();
		String username = "enter-ur-gmail-id";
		String password = "enter-ur-password";
		enterEmailandPassword(username, password);
		waitForElementToAppear();
		countTotalNumberofEmails();
		driver.close();
		System.out.println("Closed the driver");
	}

	private static void clickSigInLink() {
		try {
			driver.findElement(By.linkText("SIGN IN")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void enterEmailandPassword(String username, String password) {
		try {
			driver.findElement(By.name("identifier")).sendKeys(username);
			driver.findElement(By.cssSelector("div#identifierNext content span")).click();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.cssSelector("div#passwordNext content span")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void waitForElementToAppear() {

		String cssSelector = "a[title='Gmail']";
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// div[class='ar5 J-J5-Ji'] span[class='ts']

	private static void countTotalNumberofEmails() {
		String css = "div[class='ar5 J-J5-Ji'] span[class='ts']";
		List<WebElement> list = driver.findElements(By.cssSelector(css));

		WebElement el = list.get(2);
		System.out.println("Total number of emails is:=>" + el.getText());

	}

	private static void navigate(String navigationLink) {

		driver.navigate().to(navigationLink);
	}

}
