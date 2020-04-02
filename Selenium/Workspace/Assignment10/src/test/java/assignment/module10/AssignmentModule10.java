package assignment.module10;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practice.module10.test1.pages.WelcomePage;
import practice.module10.test2.pages.WelcomePage_BarnersNobel;

public class AssignmentModule10 {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		System.out.println("Before method");

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@Test
	public void validateCredentialsTest() {

		String navigationLink = "http://newtours.demoaut.com/";
		driver.navigate().to(navigationLink);

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.processLogin();
		String textToValidate = "Find a Flight: Mercury Tours:";
		// boolean asserted = welcomePage.validateLogin(textToValidate);
		assertTrue(welcomePage.validateLogin(textToValidate));
	}

	@Test
	public void testBarnesNobel() {
		String navigationLink = "https://www.barnesandnoble.com/";
		driver.navigate().to(navigationLink);
		WelcomePage_BarnersNobel welcomePage = new WelcomePage_BarnersNobel(driver);
		welcomePage.closeModal();
		welcomePage.hoverOnBooksElement();
		welcomePage.clickBiography();
		String text = "Biography";
		assertTrue(welcomePage.validateIfpageLoaded(text));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
