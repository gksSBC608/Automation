package test_definition;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
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

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import PageBase.BasePage;
import PageBase.BasePageRegression;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import utilities.ActionUtility;
import utilities.DriverBuilder;

public class TripList_ButtonStatus extends BasePageRegression{

	
    
    /**
     * 
     * trip details
     */
    
    
    
    @Test(groups ={"smoke","p1"})
    public void VerifyTheStatusChangeInFirstTripByTappingOnButtonStatusAssigned() throws Exception{
    	 loginPage.enterUserNameAndPasswordInLoginInPage();
         loginPage.clickOnLoginButton();
         welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
         //welcomePage.enterTheUnit();
         //welcomePage.enterTheFirstCrew();
         welcomePage.clickOnNextButtonInWelcomePage();
         tripList.verifyTripListHeader();
         tripList.VerifyActiveTripHeader();
         buttonTrip.VerifyTheCurrentStatusOfFirstTripListAndButtonStatus();
    }
    
    @Test(groups ={"smoke","p1"})
    public void VerifyTheChangeInFirstTripToPreviousStatus() throws Exception{
    	 loginPage.enterUserNameAndPasswordInLoginInPage();
         loginPage.clickOnLoginButton();
         welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
         //welcomePage.enterTheUnit();
         //welcomePage.enterTheFirstCrew();
         welcomePage.clickOnNextButtonInWelcomePage();
         tripList.verifyTripListHeader();
         tripList.VerifyActiveTripHeader();
         buttonTrip.VerifyTheCurrentStatusOfFirstTripListAndButtonStatus();
         buttonTrip.toChangeTheCurrentStatusOfFirstTripListAndButtonStatus();
    }
    
    
    
    
    @AfterMethod
    public void endApplication(ITestResult result) throws Exception{
    	//Method need to added in basePage
	    	if(result.getStatus() == ITestResult.SUCCESS){
				logger.log(LogStatus.PASS, "Passed");
			}else if(result.getStatus() == ITestResult.FAILURE){
				String screenShot = DriverBuilder.takeScreenshot(driver);
				System.out.println(screenShot);
				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShot));
			}
			report.endTest(logger);
			report.flush();
	        driver.quit();

    }
    
    
}
