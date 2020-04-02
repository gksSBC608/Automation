package com.assignment.module5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	public static void main(String[] args) {

		String navigationLink = "https://www.facebook.com/";
		String username = "use-ur-id";
		String password = "use-ur-pwd";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		navigate(navigationLink);
		enterLoginCredentialsAndLogin(username, password);
		testStep2();

		driver.close();
		System.out.println("Closed the driver");
	}

	private static void navigate(String navigationLink) {

		driver.navigate().to(navigationLink);
	}

	private static void enterLoginCredentialsAndLogin(String username, String password) {

		String email_CSS = "input[name='email']";
		driver.findElement(By.name("email")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(email_CSS)).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		String loginBtn_CSS = "input[value='Log In']";
		driver.findElement(By.cssSelector(loginBtn_CSS)).click();
	}

	private static void testStep2() {
		driver.navigate().refresh();
		System.out.println("Refreshed");
		driver.navigate().back();
		System.out.println("Navigated back");
		driver.navigate().forward();
		System.out.println("Navigated forward");
	}

}
