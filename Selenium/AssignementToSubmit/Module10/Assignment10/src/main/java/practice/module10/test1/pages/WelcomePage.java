/**
 * 
 */
package practice.module10.test1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author M1030608
 *
 */
public class WelcomePage {

	private WebDriver driver;

	@FindBy(name = "userName")
	WebElement usernameElement;

	@FindBy(name = "password")
	WebElement passwordElement;

	@FindBy(name = "login")
	WebElement signInButton;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		try {
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processLogin() {
		try {
			usernameElement.sendKeys("mercury");
			passwordElement.sendKeys("mercury");
			signInButton.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean validateLogin(String textToValidate) {
		System.out.println("--------------------------------");
		System.out.println(driver.getTitle());
		System.out.println("--------------------------------");
		return driver.getTitle().contains(textToValidate);
	}

}
