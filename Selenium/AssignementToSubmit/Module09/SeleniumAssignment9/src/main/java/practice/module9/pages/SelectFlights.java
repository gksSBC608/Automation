/**
 * 
 */
package practice.module9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import practice.utils.TakeScreenshot;

/**
 * @author M1030608
 *
 */
public class SelectFlights {

	// reserveFlights

	@FindBy(name = "reserveFlights")
	WebElement reserveFlights;

	WebDriver driver;

	public SelectFlights(WebDriver driver) {

		this.driver = driver;
		try {
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickContinueToReserveFlight() {

		try {
			String screenName = this.getClass().getSimpleName();
			TakeScreenshot.takeScreenshot(driver, screenName);

			reserveFlights.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
