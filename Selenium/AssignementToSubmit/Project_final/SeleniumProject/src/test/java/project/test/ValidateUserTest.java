package project.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import project.pages.WelcomePage;
import project.test.config.JyperionListener;

@Listeners(JyperionListener.class)
public class ValidateUserTest extends BaseTest {

	@Test
	public void validateCredentialsTest() {

		// String navigationLink = "http://newtours.demoaut.com/";
		// driver.navigate().to(navigationLink);

		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.processLogin();
		String textToValidate = "Find a Flight: Mercury Tours:";
		assertTrue(welcomePage.validateLogin(textToValidate));
	}

}
