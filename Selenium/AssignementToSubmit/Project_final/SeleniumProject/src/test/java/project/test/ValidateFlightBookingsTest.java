package project.test;

import org.testng.annotations.Test;

import project.config.Config;
import project.pages.EnterPassengerDetails;
import project.pages.FlightConfirmationPage;
import project.pages.FlightFinderPage;
import project.pages.SelectFlights;
import project.pages.WelcomePage;

public class ValidateFlightBookingsTest extends BaseTest {

	@Test
	public void testFlightBookings() {

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.processLogin();
		FlightFinderPage flightFinderPage = new FlightFinderPage(driver);
		flightFinderPage.selectOneWayFlightAndCOntinue();
		driver.navigate().back();
		flightFinderPage.enterFlightSearchDetailForRoundTrip();
		flightFinderPage.continueToFlightSearch();
		
		SelectFlights selectFlights = new SelectFlights(driver);
		selectFlights.ChooseFlightAndContinue();
		
		EnterPassengerDetails pass = new EnterPassengerDetails(driver);
		pass.enterPassengerDetailAndConfirm();
		
		FlightConfirmationPage flightConfirmation = new FlightConfirmationPage(driver);
		flightConfirmation.isFlightConfirmed();
		String flightToConfirm  = Config.flightToConfirm;
		flightConfirmation.verifyDepartureFlight(flightToConfirm);
		

	}
}
