/**
 * 
 */
package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author M1030608
 *
 */
public class FlightFinderPage {

	@FindBy(css = "input[value='oneway']")
	WebElement oneWayFlight;

	@FindBy(css = "input[value='roundtrip']")
	WebElement tripType; // One way or Round Trip

	@FindBy(name = "passCount")
	WebElement passCount;

	@FindBy(name = "fromPort")
	WebElement fromPort;

	@FindBy(name = "fromMonth")
	WebElement fromMonth;

	@FindBy(name = "fromDay")
	WebElement fromDay;

	@FindBy(name = "toPort")
	WebElement toPort;

	@FindBy(name = "toMonth")
	WebElement returnMonth;

	@FindBy(name = "toDay")
	WebElement returnDay;

	@FindBy(css = "input[value='First']")
	WebElement serviceClass;

	@FindBy(name = "airline")
	WebElement airline;

	@FindBy(name = "findFlights")
	WebElement continueButton;

	public FlightFinderPage(WebDriver driver) {

		try {
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightSearchDetailForRoundTrip() {

		try {

			tripType.click();
			Select departFrom = new Select(fromPort);
			departFrom.selectByValue("Seattle");
			Select arriveAt = new Select(toPort);
			arriveAt.selectByValue("Zurich");
			Select depMonth = new Select(fromMonth);
			depMonth.selectByIndex(0);
			Select depDay = new Select(fromDay);
			depDay.selectByValue("11");
			Select retMonth = new Select(returnMonth);
			retMonth.selectByValue("8");
			Select retDay = new Select(returnDay);
			retDay.selectByValue("15");
			serviceClass.click();
			Select prefAirline = new Select(airline);
			prefAirline.selectByVisibleText("Unified Airlines");

		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectOneWayFlightAndCOntinue() {
		oneWayFlight.click();
		continueButton.click();
	}

	public void continueToFlightSearch() {
		try {

			continueButton.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
