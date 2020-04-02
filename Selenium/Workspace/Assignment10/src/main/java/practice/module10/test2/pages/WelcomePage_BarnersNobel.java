package practice.module10.test2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class WelcomePage_BarnersNobel {

	@FindBy(css = "a[aria-label='Close']")
	WebElement modalCloseButton;

	@FindBy(linkText = "Books")
	WebElement BookLink;

	@FindBy(linkText = "Biography")
	WebElement biographyLink;

	private WebDriver driver;

	public WelcomePage_BarnersNobel(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeModal() {
		try {
			modalCloseButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hoverOnBooksElement() {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(BookLink).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickBiography() {
		try {

			biographyLink.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateIfpageLoaded(String textToValidate) {
		boolean result = false;
		try {
			String css = "span.text-container span.text";
			String text = driver.findElement(By.cssSelector(css)).getText();
			result = text.equalsIgnoreCase(textToValidate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
