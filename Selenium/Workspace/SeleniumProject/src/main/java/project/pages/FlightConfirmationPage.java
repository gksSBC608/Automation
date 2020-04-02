/**
 * 
 */
package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author M1030608
 *
 */
public class FlightConfirmationPage {

	private WebDriver driver;

	@FindBy(css = "img[src='/images/masts/mast_confirmation.gif']")
	private WebElement flighTconfirmationMessage;

	@FindBy(css = "img[src='/images/forms/backtoflights.gif']")
	private WebElement backToFlightButton;

	public FlightConfirmationPage(WebDriver driver) {

		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isFlightConfirmed() {

		Assert.assertTrue(flighTconfirmationMessage.isDisplayed());
	}

	public void verifyDepartureFlight(String flightname) {

		if (!driver.getPageSource().contains(flightname)) {
			backToFlightButton.click();
		}
	}

}
