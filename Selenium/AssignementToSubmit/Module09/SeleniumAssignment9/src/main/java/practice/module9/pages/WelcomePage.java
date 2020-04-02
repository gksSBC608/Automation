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
public class WelcomePage {

	@FindBy(name = "userName")
	WebElement usernameElement;

	@FindBy(name = "password")
	WebElement passwordElement;

	@FindBy(name = "login")
	WebElement signInButton;

	private WebDriver driver;

	public WelcomePage(WebDriver driver) {
		try {
			this.driver = driver;
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
			String screenName = this.getClass().getSimpleName();
			TakeScreenshot.takeScreenshot(driver,screenName);
			signInButton.click();
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
