/**
 * 
 */
package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import util.CommonActions;

/**
 * @author M1030608
 *
 */
public class BaseTest {

	protected WebDriver driver;
	protected CommonActions commonActions;

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeClassOperations(ITestContext context, String browser) {

		// String browser = context.getCurrentXmlTest().getParameter("browser");

		if (browser.equalsIgnoreCase("Chrome"))
			launchChrome();
		else
			launchFirefox();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		commonActions = new CommonActions(driver);
	}

	private void launchChrome() {
		String basepath = System.getProperty("user.dir");
		System.out.println(basepath);
		String driverPath = basepath + File.separator + "driver" + File.separator + "chromedriver" + File.separator
				+ "chromedriver.exe";
		System.out.print("driverPath:- ");
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	private void launchFirefox() {
		String basepath = System.getProperty("user.dir");
		System.out.println(basepath);
		String driverPath = basepath + File.separator + "driver" + File.separator + "geckodriver" + File.separator
				+ "geckodriver.exe";
		System.out.print("driverPath:- ");
		System.out.println(driverPath);
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
