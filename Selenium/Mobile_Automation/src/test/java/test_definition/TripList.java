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

public class TripList extends BasePageRegression{

	
    @Test(groups ={"smoke","p1"})
    public void NMA_202_414_VerifyTheZollRespondSpinnerIsDsiplayedWhenTripListIsSelected() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheValueForSelectVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectEnRouteStatusTrip();
        //tripList.selectOneTripFromTripList();
        //tripList.toTapOnZollRespond();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_727_VerifyTheRespondViewOnTappingTheTopMostTripListScreen() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheValueForSelectVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectEnRouteStatusTrip();
        //tripList.selectOneTripFromTripList();
        //tripList.toTapOnZollRespond();
    }

    @Test(groups ={"smoke","p1"})
    public void NMA_215_VerifyTripListMenuTab() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheValueForSelectVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.selectEnRouteStatusTrip();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_667_VerifyTripViewForAssignedTripAndDetails() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheValueForSelectVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.selectEnRouteStatusTrip();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_213_VerifyTripListHeadersinTripPage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheValueForSelectVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
       
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_203_VerifyTheTimeStampInTripListPage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.toVerifyTheTimeInTripListPage();
       
    }
    
    //@Test(groups ={"smoke","p1"})
    public void NMA_201_VerifyTheLayoutOfTripListIsDisplayed() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.toVerifyTheTripListIsDisplayedinTripPage();
        tripList.selectEnRouteStatusTrip();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_371_372_VerifyThePatientInfoAndNotesInActiveTripTripInformation() throws Exception{
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
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
       
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_368_VerifyPickUpScreeninActiveTrip() throws Exception{
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.clickOnMyLocationIconInGoogleMap();
        tripList.clickOnGPSimageInDropOffTab();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_744_VerifyActiveTripPickUpScreenDetails() throws Exception{
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.clickOnMyLocationIconInGoogleMap();
        //tripList.clickOnGPSimageInDropOffTab();
    }
    
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
        tripList.clickOnGPSimageInDropOffTab();
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
        tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
        tripList.clickOnGPSimageInDropOffTab();
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
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
    	    tripList.clickOnGPSimageInDropOffTab();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_793_VerifyUIElementsInPatientInfoRunNumberNnotesForActiveTrip() throws Exception{
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
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
    	    tripList.clickOnGPSimageInDropOffTab();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_225_VerifyTheCoverageOfTapinRespondScreen() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectOneTripFromTripList();
        //tripList.toTapOnZollRespond();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_721_VerifyTheRespondScreenTapCoverage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        tripList.selectOneTripFromTripList();
        //tripList.toTapOnZollRespond();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_216_662_VerifyTheTripListItemFormat() throws Exception{
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
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_375_VerifyActiveTripDropOffPatientInfo() throws Exception{
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
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
    }
    
    @Test(groups ={"smoke","p1"})
    public void VerifyMapDirectionAddressDropOffPickUpInActiveTripForSelectedTrip() throws Exception{
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
        //tripList.verifyTheGPSimageIsDisplayedInPickUpTab();
        //tripList.clickOnGPSimageInPickUpTab();
        tripList.pickUpLocationAddress();
        tripList.verifyThePickMapIsDisplayed();
        tripList.navigateToTripInformationTabORPatientInformation();
        tripList.verifyThePatientInformationNameAgeGenderweightANdNote();
        tripList.verifyTheDropOffIsDisplayed();
        tripList.navigateToDropOffTab();
        tripList.dropOffLocationAddress();
        tripList.verifyTheGPSimageIsDisplayedInDropOffTab();
        //tripList.clickOnGPSimageInDropOffTab();
        tripList.verifyTheDropOffMapIsDisplayed();
        //tripList.clickOnDropOffMyLocationIconInGoogleMap();
        //tripList.clickOnGPSimageInDropOffTab();
    }
    
    
    
}
