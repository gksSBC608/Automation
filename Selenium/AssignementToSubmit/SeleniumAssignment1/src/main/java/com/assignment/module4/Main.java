package com.assignment.module4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	public static void main(String[] args) {

		String navigationLink = "http://newtours.demoaut.com/";
		String username = "edugaurav";
		String password = "edugaurav1";
		String textToVerify = "Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		navigate();
		enterLoginCredentialsAndLogin();
		verifyForTextOnPage(textToVerify);

		driver.close();
	}

	private static void navigate() {

		driver.navigate().to("http://newtours.demoaut.com/");
	}

	private static void enterLoginCredentialsAndLogin() {

		driver.findElement(By.name("userName")).sendKeys("edugaurav");
		driver.findElement(By.name("password")).sendKeys("edugaurav1");
		driver.findElement(By.name("login")).click();
	}

	private static void verifyForTextOnPage(String text) {

		boolean isTextPresent = driver.getPageSource().contains(text);
		if (isTextPresent) {
			System.out.println("Test Passed:-> Text '" + text + " is present on the page opened");
		} else {
			System.out.println("Test Failed:-> Text '" + text + " is not present on the page opened");
		}

	}

}
