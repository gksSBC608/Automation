package assignment.module6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestModule6 {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	String titleToCheck = "Facebook – log in or sign up";
	String textToVerify = "Facebook helps you connect and share with the people in your life.";
	String text2 = "It's free and always will be.";

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
		String navigationLink = "https://www.facebook.com/";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.navigate().to(navigationLink);

	}

	@Test
	public void test1() {

		String title_actual = driver.getTitle();
		System.out.println("Actual title: " + title_actual);
		System.out.println("Expected title: " + titleToCheck);
		Assert.assertEquals(title_actual, titleToCheck);
	}

	@Test
	public void test2() {
		boolean isTextPresent = driver.getPageSource().contains(textToVerify);
		Assert.assertTrue(isTextPresent);
	}

	@Test
	public void test3() {

		boolean isTextPresent = driver.getPageSource().contains(text2);
		Assert.assertTrue(isTextPresent);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@AfterClass
	public void afterClass() {

		System.out.println("After class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
		driver.close();
	}

}
