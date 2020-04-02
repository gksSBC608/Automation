package test_definition;
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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import PageBase.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import utilities.ActionUtility;
import utilities.DriverBuilder;

 

public class SmokeTest extends BasePage{

    /*
     * smoke test
     */
    
    @Test(groups ={"smoke","p1"})
    public void NMA_367_VerifyUIElementsInActiveTrip() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectEnRouteStatusTrip();
        //tripList.toTapOnZollRespond();
        tripList.toVerifyTheSubMenuTabsInActiveTrip();
        tripList.navigateToPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheDropOffMapIsDisplayed();
        tripList.clickOnDropOffMyLocationIconInGoogleMap();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_794_VerifyActiveTripPatientInformation() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectEnRouteStatusTrip();
        //tripList.toTapOnZollRespond();
        tripList.toVerifyTheSubMenuTabsInActiveTrip();
        tripList.navigateToPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_373_VerifyUIElementsInDropScreenInActiveTrip() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectEnRouteStatusTrip();
        //tripList.toTapOnZollRespond();
        tripList.toVerifyTheSubMenuTabsInActiveTrip();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheDropOffMapIsDisplayed();
        tripList.clickOnDropOffMyLocationIconInGoogleMap();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_945_VerifyThePickUpInfoScreenTripsDetails() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectAssignedStatus();
        tripList.verifyTheTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
        tripList.verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails();
        tripList.verifyThePickMapIsDisplayedForTripDetails();
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_989_VerifyTheDropOffScreenTripsDetails() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectAssignedStatus();
        tripList.verifyTheTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
        tripList.verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails();
        tripList.verifyThePickMapIsDisplayedForTripDetails();
        tripList.selectTheMapDirectionInAddress();
        //tripList.clickOnSatelliteViewButtonInMap();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.verifyTheDropOfFdetailsForAssignedOrCancelledOrCompletedInTripDetails();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        tripList.clickOnSatelliteViewButtonInMap();
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_961_VerifyTheTripDetailsInfoForAssignedTrips() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectAssignedStatus();
        tripList.verifyTheTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
        tripList.verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails();
        tripList.navigateToTripInformationTabInTripDetails();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage();
        tripList.verifyTheTransportInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1196_VerifyUIElement() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
        chatPage.verifyChatCountInChatHomeScreen();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyChatCountInChatHomeScreen();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1245_VerifyUsershouldBeAbleToPickNewContactFromContactPageAndStartNewMessageThread() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnGroups();
        chatPage.selectTheTripInGroups();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
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