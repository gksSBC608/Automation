package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;




public class DriverBuilder 
{
	
	static Logger log = null;
	private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();
	public static enum LogType{ INFO, PASS, SOFTFAIL , WARNING,	SCREENSHOT, UNCOMPLETED, TEXTLOGONLY, HARDFAIL};
	private static final ThreadLocal<ExtentTest> reportLogger = new ThreadLocal<ExtentTest>();
	@SuppressWarnings("unused")
	private DesiredCapabilities capability;
	public AppiumDriver<IOSElement> driver;
	static Properties p = new Properties();
    static FileInputStream fis = null;
//	private IOSClient iosClient;

	public void setDriver(AppiumDriver<IOSElement> driver){
		this.driver = driver;
	}

	public AppiumDriver<IOSElement> getiOSDriver(){
		return driver;
	}
	
	public static ExtentTest getReportLogger() {
        return reportLogger.get();
    }

    public static void setReportLogger(ExtentTest extentTest) {
        reportLogger.set(extentTest);
    }
    
    public void hideKeyboard() {
    	driver.hideKeyboard();
    }
	
    
    public static String takeScreenshot(AppiumDriver<MobileElement> driver) throws Exception {
        try {
        	try {
				fis = new FileInputStream("DataSource/Data.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p.load(fis);
			Thread.sleep(200);
        	  DateFormat DF = new SimpleDateFormat("yyyyMMddhhmmss");//DF.format(new Date())+
              String fileName = "TEST"+DF.format(new Date())+".png";
             // logger.info("Screenshot Name" + fileName);
              String directory =p.getProperty("ScreenshotSave");
              java.io.File sourceFile = (java.io.File) ((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              //File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
              FileCopyUtils.copy(sourceFile, new java.io.File(directory + fileName));
              String destination = directory + fileName;
              return destination;
        } catch (Exception e) {
              throw new Exception("Screen shot is not available");
        }
  }
	
//	public void setAndroidClient(String host, int port){
//		client = new Client(host, port, true);
//	}
//	
//	public Client getAndroidClient(){
//		return client;
//	}
//	
//	public void setIOSClient(String host, int port){
//		client = new Client(host, port, true);
//	}
//	
//	public Client getIOSClient(){
//		return client;
//	}
	
	
	
	/**
	 * This method logs the message or image to the PDF report 
	 * @param message to be printed on report 
	 * @param type LogType eg: PASSED, SOFTFAIL, HARDFAIL
	 * @return 
	 * @throws 
	 * @author ptt4kor
	 */
	public static void ReportLog(String message, LogType type){
		//get the name of the method
	
		String methodName =Thread.currentThread().getStackTrace()[2].getMethodName();
	switch(type){
		case INFO:
			Reporter.log(message+ " [I]");
			log.info("["+ methodName + "] - [INFO] - " + message );
			break;
		case PASS:
			Reporter.log(message+ " [P]");
			log.info("["+ methodName + "] - [PASS] - " + message );
			break;
		case SOFTFAIL:
			Reporter.log(message+ " [F]");
			log.info("["+ methodName + "] - [SOFTFAIL] - " + message );
//			takeSaveScreenShot();
			break;
		case WARNING:
			Reporter.log(message+ " [W]");
			log.info("["+ methodName + "] - [WARNING] - " + message );
			break;
		case SCREENSHOT:
			Reporter.log(message+ " [J]");
			log.info("["+ methodName + "] - [JPG] - " + "Screenshot taken, file name is " + message + ".jpg" );
			break;
		case UNCOMPLETED:
			Reporter.log(message+ " [U]");
			log.info("["+ methodName + "] - [UNCOMPLETED] - " + message );
			Assert.fail(message);

			break;
		case TEXTLOGONLY:
			log.info("["+ methodName + "] - [LOG] - " + message );
			break;
		case HARDFAIL:
			Reporter.log(message+ " [S]");
			log.info("["+ methodName + "] - [HARDFAIL] - " + message );
//			takeSaveScreenShot();
			Assert.fail(message);
			
			break;
		}
		
	}
	
	
	
	
	
}
