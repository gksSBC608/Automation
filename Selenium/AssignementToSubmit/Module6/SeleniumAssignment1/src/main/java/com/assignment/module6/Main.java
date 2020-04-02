package com.assignment.module6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	public static void main(String[] args) {

		String navigationLink = "https://www.facebook.com/";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		navigate(navigationLink);
		String titleToCheck = "Facebook – log in or sign up";
		String textToVerify = "Facebook helps you connect and share with the people in your life.";
		String text2 = "It's free and always will be.";
		testCase1(titleToCheck);
		testCase2(textToVerify);
		testCase3(text2);

		driver.close();
		System.out.println("Closed the driver");
	}

	private static void navigate(String navigationLink) {

		driver.navigate().to(navigationLink);
	}

	private static void testCase1(String title_expected) {

		String title_actual = driver.getTitle();
		boolean result = title_expected.equalsIgnoreCase(title_actual);
		if (result) {
			System.out.println("Tile matched");
		} else {
			System.out.println("Tile not matched");
		}

	}

	private static void testCase2(String text) {

		boolean isTextPresent = driver.getPageSource().contains(text);
		if (isTextPresent) {
			System.out.println("Test Passed:-> Text '" + text + "' is present on the page opened");
		} else {
			System.out.println("Test Failed:-> Text '" + text + "' is not present on the page opened");
		}

	}

	private static void testCase3(String text) {

		boolean isTextPresent = driver.getPageSource().contains(text);
		if (isTextPresent) {
			System.out.println("Test Passed:-> Text '" + text + "' is present on the page opened");
		} else {
			System.out.println("Test Failed:-> Text '" + text + "' is not present on the page opened");
		}

	}

}
