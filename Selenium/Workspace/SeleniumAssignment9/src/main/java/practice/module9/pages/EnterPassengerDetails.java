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
public class EnterPassengerDetails {

	@FindBy(name = "passFirst0")
	WebElement firstName;

	@FindBy(name = "passLast0")
	WebElement lastName;

	@FindBy(name = "pass.0.meal")
	WebElement passMeal;

	@FindBy(name = "creditnumber")
	WebElement cardNumber;

	@FindBy(name = "buyFlights")
	WebElement confirmFlight;

	private WebDriver driver;

	public EnterPassengerDetails(WebDriver driver) {

		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterPassengerDetailAndConfirm() {
		try {
			firstName.sendKeys("Test");
			lastName.sendKeys("Data_0");
			Select passengerMeal = new Select(passMeal);
			passengerMeal.selectByValue("VGML");
			cardNumber.sendKeys("1098765432123");
			String screenName = this.getClass().getSimpleName();
			TakeScreenshot.takeScreenshot(driver, screenName);
			confirmFlight.click();

		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyIfBookingDone(String textToVerify) {

		System.out.println(driver.getPageSource());

		return driver.getPageSource().contains(textToVerify);
	}
}
