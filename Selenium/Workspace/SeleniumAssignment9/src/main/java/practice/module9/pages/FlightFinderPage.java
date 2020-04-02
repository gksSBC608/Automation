/**
 * 
 */
package practice.module9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import practice.utils.TakeScreenshot;

/**
 * @author M1030608
 *
 */
public class FlightFinderPage {

	@FindBy(name = "tripType")
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

	@FindBy(name = "servClass")
	WebElement serviceClass;

	@FindBy(name = "airline")
	WebElement airline;

	@FindBy(name = "findFlights")
	WebElement continueButton;

	WebDriver driver;

	public FlightFinderPage(WebDriver driver) {

		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterFlightSearchDetail() {

		try {

			tripType.click();
			Select passengers = new Select(passCount);
			passengers.selectByIndex(0);
			Select departFrom = new Select(fromPort);
			departFrom.selectByValue("Frankfurt");
			Select depMonth = new Select(fromMonth);
			depMonth.selectByIndex(6);
			Select depDay = new Select(fromDay);
			depDay.selectByValue("19");
			Select arriveAt = new Select(toPort);
			arriveAt.selectByValue("Sydney");
			Select retMonth = new Select(returnMonth);
			retMonth.selectByValue("8");
			Select retDay = new Select(returnDay);
			retDay.selectByValue("11");
			serviceClass.click();

			// airline

			Select prefAirline = new Select(airline);
			prefAirline.selectByVisibleText("Unified Airlines");

		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void continueToFlightSearch() {
		try {
			String screenName = this.getClass().getSimpleName();
			TakeScreenshot.takeScreenshot(driver, screenName);

			continueButton.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
