/**
 * 
 */
package project.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

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

	@FindBy(name = "creditCard")
	WebElement cardType;

	@FindBy(name = "cc_exp_dt_mn")
	WebElement cardExpMonth;

	@FindBy(name = "cc_exp_dt_yr")
	WebElement cardExpYear;

	// ticketLess

	@FindBy(name = "ticketLess")
	WebElement ticketLess;

	// delCountry
	@FindBy(name = "delCountry")
	WebElement delCountryEl;

	@FindBy(name = "buyFlights")
	WebElement confirmFlight;

	WebDriver driver;

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
			passengerMeal.selectByValue("LCML");

			Select creditCard = new Select(cardType);
			creditCard.selectByValue("DC");

			Select creditCardExpMonth = new Select(cardExpMonth);
			creditCardExpMonth.selectByIndex(8);

			Select creditCardExpYear = new Select(cardExpYear);
			creditCardExpYear.selectByValue("2010");

			ticketLess.click();

			Select delCountry = new Select(delCountryEl);
			delCountry.selectByValue("201");

			Alert alert = driver.switchTo().alert();
			Thread.sleep(1100);
			String message = alert.getText();
			String text = "$6.5";
			boolean isTextPresent = message.contains(text);
			Assert.assertTrue(isTextPresent);
			alert.accept();
			confirmFlight.click();

		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
