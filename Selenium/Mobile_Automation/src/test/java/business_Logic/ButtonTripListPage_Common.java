package business_Logic;

import com.relevantcodes.extentreports.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ActionUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by M1040354 on 10/30/2017.
 */
public class ButtonTripListPage_Common {

    private static AppiumDriver<MobileElement> driver;
    private static ActionUtility actionUtility = new ActionUtility();
    Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports report ;
    public static ExtentTest logger;

    //*********TripList page***********
    @FindBy(id = "main_contentFrame")
    private MobileElement tripListMainFrame;
    @FindBy(id = "cataLogtextView")
    private MobileElement catalogIconText;
    @FindBy(id = "scantextView")
    private MobileElement ScanIconText;
    @FindBy(id = "btnenRoute")
    private MobileElement enRouteButton;
    @FindBy(id = "btnAtScene")
    private MobileElement atSceneButton;
    @FindBy(id ="btnTransporting")
    private MobileElement transportingButton;
    @FindBy(id ="btnComplete")
    private MobileElement completeButton;
    
    
    @AndroidFindBy(id = "")
    private MobileElement currentStatus;
    @AndroidFindBy(id = "")
    private MobileElement previousStatus;

    

    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        ButtonTripListPage_Common.driver = driver;
        actionUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void setLog(ExtentTest logger){

        ButtonTripListPage_Common.logger = logger;
    }

    public void beforeExtentReport(String testName){
        report = new ExtentReports(".\\Extent_Report\\MobileAndroidReport.html", true, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
        logger = report.startTest(testName);
        logger.log(LogStatus.INFO,"App is launched");
    }
    public void afterExtentReport(String status){
        if(status.equals("fail")){
            logger.log(LogStatus.FAIL, "Failed");
        }else{
            logger.log(LogStatus.PASS, "Passed");
        }
        report.endTest(logger);
        report.flush();
    }
    
    public void VerifyTheCurrentStatusOfFirstTripListAndButtonStatus(){
    	String status = "En Route";
    	
    	try{
    		String buttonStatus = currentStatus.getText();
    		Assert.assertEquals(buttonStatus.toLowerCase(), status);
    		logger.log(LogStatus.INFO, "current trip status is matching with trip list status");
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING,"current trip status in trip list page is not matching");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING,"unable to verfiy the current trip status header in trip list page");
    		throw e;
    	}
    }
    
    
    public void toChangeTheCurrentStatusOfFirstTripListAndButtonStatus(){
    	String status = "En Route";
    	String prevStatus = "Assigned";
    	try{
    		String buttonStatus = previousStatus.getText();
    		
    		//Assert.assertEquals(buttonStatus.toLowerCase(), status.toLowerCase());
    		
    		if(buttonStatus.equals(prevStatus)){
    			actionUtility.click(previousStatus);
    			logger.log(LogStatus.INFO, "tapped on previous status");
    		}
    		logger.log(LogStatus.INFO, "current trip status is - ");
    	}catch(AssertionError e){
    		
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING,"unable to verfiy the current trip status header in trip list page");
    		throw e;
    	}
    }
    
}
