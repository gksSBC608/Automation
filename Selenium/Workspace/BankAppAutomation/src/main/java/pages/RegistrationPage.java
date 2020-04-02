package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import bankapp.dto.RegistrationData;

public class RegistrationPage {

	private WebDriver driver;

	public RegistrationPage() {
		try {
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(name = "firstname")
	private WebElement firstname;

	@FindBy(id = "lastname")
	private WebElement lastname;

	@FindBy(name = "bankname")
	private WebElement bankname;

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password1")
	private WebElement repeatPassword;

	@FindBy(id = "sbmtBtn")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterRegistrationDetails(RegistrationData registrationData) {
		firstname.sendKeys(registrationData.getFirstname());
		lastname.sendKeys(registrationData.getLastname());
		bankname.sendKeys(registrationData.getBankname());
		username.sendKeys(registrationData.getUsername());
		password.sendKeys(registrationData.getPassword());
		repeatPassword.sendKeys(registrationData.getRepeatPassword());
	}

	public void clickRegisterButton() {
		submitButton.click();
	}

}
