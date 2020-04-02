package PageBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.*;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import business_Logic.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import utilities.ActionUtility;
import utilities.DriverBuilder;

public class BasePage {

	public static AppiumDriver<MobileElement> driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ZonedDateTime currentTime = ZonedDateTime.now();
	public static String formattedTime = currentTime.toLocalDateTime()
			.format(DateTimeFormatter.ofPattern("dd-MM-yyy_hh_mm_ss"));
	static Properties p = new Properties();
	static FileInputStream fis = null;
	public static String workingDir = System.getProperty("user.dir");
	public String Path_Report = workingDir + "//extent-report//";
	public ActionUtility actionUtility = new ActionUtility();
	public static LoginPage_Common loginPage = new LoginPage_Common();
	public WelcomePage_Common welcomePage = new WelcomePage_Common();
	public TripListPage_Common tripList = new TripListPage_Common();
	public ButtonTripListPage_Common buttonTrip = new ButtonTripListPage_Common();
	public MapSearch maps = new MapSearch();
	public ChatPage_Common chatPage = new ChatPage_Common();

//	public void initiatePage(BasePage basePage){
//		loginPage = new LoginPage_Common(driver);
//		dashBoard = new DashBoardPage_Common();
//	}

	@BeforeMethod
	public void setUp(Method method) throws InterruptedException, IOException {
		report = new ExtentReports("Extent_Report/ZOLLMobileSmokeiOSReport.html", false, DisplayOrder.OLDEST_FIRST,
				NetworkMode.ONLINE);
		logger = report.startTest(method.getName());
		try {
			File files = new File("DataSource/Data.Properties");
			System.out.println(files.getAbsolutePath());
			fis = new FileInputStream(files.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(500);

		File file = new File(p.getProperty("ApplicationPath"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", p.getProperty("PlatformName"));
		capabilities.setCapability("deviceName", p.getProperty("iOSDeviceName"));
		capabilities.setCapability("platformVersion", p.getProperty("iOSPlatformVersion"));
		capabilities.setCapability("udid", p.getProperty("UDID"));
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("bundleId", p.getProperty("BundleId"));
		capabilities.setCapability("automationName", p.getProperty("AutomationName"));
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		capabilities.setCapability("xcodeOrgId", p.getProperty("xcodeOrgId"));
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("useNewWDA", false);
		capabilities.setCapability("bootstrapPath", p.getProperty("BootStrapPath"));
		capabilities.setCapability("agentPath", p.getProperty("AgentPath"));
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
		driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "App is Launched");
		loginPage.setDriver(driver);
		loginPage.setLog(logger);
		welcomePage.setDriver(driver);
		welcomePage.setLog(logger);
		tripList.setDriver(driver);
		tripList.setLog(logger);
		maps.setDriver(driver);
		maps.setLog(logger);
		chatPage.setDriver(driver);
		chatPage.setLog(logger);
	}

	@AfterMethod
	public void endApplication(ITestResult result) throws Exception {
		// Method need to added in basePage
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String screenShot = DriverBuilder.takeScreenshot(driver);
			System.out.println(screenShot);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShot));
		}
		report.endTest(logger);
		report.flush();
		driver.quit();
	}

}