/**
 * 
 */
package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bankapp.dto.RegistrationData;
import config.ConfigData;
import config.DataReader;
import pages.RegistrationPage;

/**
 * @author M1030608
 *
 */
public class RegisterPageTests extends BaseTest {

	/**
	 * 
	 */
	public RegisterPageTests() {

	}

	/**
	 * 
	 */
	private void doInitials() {
		driver.navigate().to("http://localhost:8082/register");
	}

	@DataProvider(name = "registerUser")
	public Object[][] obtainRegisterData() {
		Object[][] data = new Object[ConfigData.NUMBER_REG_FIELDS][];
		data = DataReader.readData();
		return data;
	}

	@Test(dataProvider = "registerUser", enabled = false)
	public void testRegisterUser() {
		
		RegistrationData registrationData = new RegistrationData();
				RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterRegistrationDetails(registrationData);
		registrationPage.clickRegisterButton();	
	}

}
