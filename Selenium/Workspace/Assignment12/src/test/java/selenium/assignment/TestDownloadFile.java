package selenium.assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestDownloadFile {

	private static String driverPath = "driver/";
	private static WebDriver driver;
	private static String downloadFilepath = "C:/AssignmentDownload";
	private static String expectedFilename = "smilechart.xls";

	@BeforeClass
	public void beforeClass() {

		File downloadDir = new File(downloadFilepath);

		// if (!downloadDir.exists()) {
		downloadDir.mkdirs();
		// }

		File[] listOfFiles = downloadDir.listFiles();
		for (File file : listOfFiles) {
			file.delete();
		}

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); // to disable browser
														// extension popup
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	public void testDownload_file() throws InterruptedException {
		String urlToNavigate = "http://spreadsheetpage.com/index.php/file/C35/P10/";
		driver.get(urlToNavigate);
		PageUnderTest page = new PageUnderTest(driver);

		page.clickTheDownloadFileLink();
		Thread.sleep(5000);

		getFilenameOfDownloaded();

	}

	private void getFilenameOfDownloaded() {

		File folder = new File(downloadFilepath);
		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
					String filename = file.getName();
					// long lastModified = file.lastModified();
					// long currMillis = new Date().getTime();
					//System.out.println(lastModified + " " + currMillis + " " + (currMillis - lastModified));
					Assert.assertEquals(filename.toLowerCase(), expectedFilename.toLowerCase());
				}
			}
		}
	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
