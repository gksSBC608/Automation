package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HomePage extends BaseTest {

	private void initials() {
		driver.get("http://localhost:8082/");
	}

	@Test(priority = 1)
	public void testTitleOfPage() {
		initials();
		assertEquals(driver.getTitle(), "XYZ Home");
	}

	@Test(priority = 2)
	public void testOpenAccountWorking() {

		String linkText = "Open Account";
		commonActions.findByLinkText(linkText).click();
		String registerButtonId = "sbmtBtn";
		String value = commonActions.findById(registerButtonId).getAttribute("value");
		assertEquals("Register", value);
		driver.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
