package assignment.module9;

import org.testng.annotations.Test;

import practice.module9.pages.EnterPassengerDetails;
import practice.module9.pages.FlightFinderPage;
import practice.module9.pages.SelectFlights;
import practice.module9.pages.WelcomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AssignmentModule9 {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		System.out.println("Before method");

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test
	public void testBookTicket() {
		String navigationLink = "http://newtours.demoaut.com/";
		driver.navigate().to(navigationLink);
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.processLogin();
		FlightFinderPage flightFinder = new FlightFinderPage(driver);
		flightFinder.enterFlightSearchDetail();
		flightFinder.continueToFlightSearch();
		SelectFlights selectFlight = new SelectFlights(driver);
		selectFlight.clickContinueToReserveFlight();
		EnterPassengerDetails passDetails = new EnterPassengerDetails(driver);
		passDetails.enterPassengerDetailAndConfirm();
		String textToVerify = "Please print a copy of this screen for your records";
		boolean booked = passDetails.verifyIfBookingDone(textToVerify);
		assertTrue(booked);
	}

	@Test(invocationCount = 5)
	public void testLaunchingDropbox() throws InterruptedException {

		String navigationLink = "https://www.dropbox.com/";
		driver.navigate().to(navigationLink);
		String title = driver.getTitle();
		System.out.println("Title of the page is:->" + title);
		Thread.sleep(3999);

	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();
	}

	@AfterTest
	public void afterTest() {
	}

}
