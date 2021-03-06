/**
 * 
 */
package practice.module10.test1.pages;

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

	public EnterPassengerDetails(WebDriver driver) {

		try {
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

			confirmFlight.click();

		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyIfBookingDone(String textToVerify) {
		return false;
	}
}
