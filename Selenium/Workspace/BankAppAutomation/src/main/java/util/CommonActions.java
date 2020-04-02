package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);

	}

	public WebElement findByLinkText(String linkText) {

		return wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		// return driver.findElement(By.linkText(linkText));

	}

	public WebElement findById(String registerButtonId) {

		return wait.until(ExpectedConditions.elementToBeClickable(By.id(registerButtonId)));

	}

}
