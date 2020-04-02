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

public class TripList_TripDetails extends BasePageRegression{

	
    
    /**
     * 
     * trip details
     */
    
    @Test(groups ={"smoke","p1"})
    public void VerifyTheSubMenusInHamburgerMenuMobileView() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.toGetTheInformationOfSelectedTripListAndSelectTrip();
        tripList.verifyTheMenuHeaderIsdisplayed();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_908_VerifyTheTripDetailsPagePickUpInfoScreenDetails() throws Exception{
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
        tripList.verifyTheTripStatusInTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
        tripList.verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_911_VerifyTheNavigationHeaderButtonToBrowseAllTripsScreenDetails() throws Exception{
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
        tripList.verifyTheTripStatusInTripDetailsPage();
        tripList.clickOnForwardNavigationInTripDetailsPage();
        tripList.clickOnBackwardNavigationInTripDetailsPage();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_959_VerifyTheTripDetailsInfoForAssignedTrips() throws Exception{
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
    	    tripList.verifyTheTripStatusInTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
        tripList.verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails();
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
    public void VerifyButtonStatusInTripListPage() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        //tripList.selectTheAssignedStatusTripList();
        tripList.selectEnRouteStatusTrip();
        
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_907_VerifyTheTripDetailsPickUpScreenForAssignedOrCancelledOrCompletedTrips() throws Exception{
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
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_909_VerifyTheBackButtonFunctionalityInTripDetailsPickUpInfoScreenForAssignedOrCancelledOrCompletedTrips() throws Exception{
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
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.selectTheMapDirectionInAddress();
        //tripList.clickOnSatelliteViewButtonInMap();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.verifyTheDropOfFdetailsForAssignedOrCancelledOrCompletedInTripDetails();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnGPSimageInDropOffTab();
        //tripList.clickOnSatelliteViewButtonInMap();
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
    }
    
    @Test(groups ={"smoke","p1"})
    public void VerifyNoCrashInApplicationIfWeKeepOnNavigatingToTripDetailsScreen() throws Exception{
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
        tripList.clickOnBackButtonInTripDetailsPage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectAssignedStatus();
        tripList.verifyTheTripDetailsPage();
        tripList.verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage();
    }
    
    @Test(groups ={"smoke","p1"})
    public void VerifyTheCompletedTripsInTripDetailsScreen() throws Exception{
    	loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectCancelledStatus();
        tripList.verifyTheTripDetailsPage();
        tripList.verfiyTheStatusIDInTripDetailsPage("CANCELLED");
    }
    
    @Test(groups ={"smoke","p1"})
    public void VerifyTheTripHeaderStatusWithTripInformationInTripDetailsPage() throws Exception{
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
        tripList.verfiyTheStatusIDInTripDetailsPage("ASSIGNED");
        tripList.navigateToTripInformationTabInTripDetails();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage();
        tripList.verifyTheTransportInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage();
        tripList.clickOnBackButtonInTripDetailsPage();
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
