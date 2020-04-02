/**
 * 
 */
package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author M1030608
 *
 */
public class SelectFlights {

	// reserveFlights

	@FindBy(css = "input[value='Unified Airlines$763$135$11:24']")
	WebElement depFlight;

	@FindBy(css = "input[value='Pangea Airlines$672$134$16:37']")
	WebElement returnFLight;

	@FindBy(name = "reserveFlights")
	WebElement reserveFlights;

	public SelectFlights(WebDriver driver) {

		try {
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ChooseFlightAndContinue() {

		try {
			depFlight.click();
			returnFLight.click();
			reserveFlights.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
