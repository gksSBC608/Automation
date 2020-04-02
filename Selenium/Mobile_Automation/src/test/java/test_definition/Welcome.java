package test_definition;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import PageBase.BasePage;
import PageBase.BasePageRegression;

import com.relevantcodes.extentreports.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ActionUtility;
import utilities.DriverBuilder;

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

/**
 * Created by M1040354 on 10/30/2017.
 */
public class Welcome extends BasePageRegression{

    /*
     * welcome page
     */
    
    @Test(groups ={"smoke","p1"})
    public void VerifyWithoutSelectingTheCompanyTapOnNextButton() throws Exception{
    		loginPage.verifyTheAppIsLaunched();
    		loginPage.enterUserNameAndPasswordInLoginInPage();
    		loginPage.clickOnLoginButton();
    		welcomePage.verifyTheWelcomePageAfterLogin();
    		welcomePage.clickOnNextButtonInWelcomePage();
    }
    
   @Test(groups ={"smoke","p1"})
    public void FT_Sprint1_0200_VerifyTheWelcomePageAfterLogin() throws Exception{
    		loginPage.verifyTheAppIsLaunched();
    		loginPage.enterUserNameAndPasswordInLoginInPage();
    		loginPage.clickOnLoginButton();
    		welcomePage.verifyTheWelcomePageAfterLogin();
    }
    
    

    	@Test(groups ={"smoke","p1"})
    public void FT_Sprint1_0210_verifyUserCanEnterTheValueForCompanyNameByCopyPasting() throws Exception{
    		loginPage.verifyTheAppIsLaunched();  
    		loginPage.enterUserNameAndPasswordInLoginInPage();
    		loginPage.clickOnLoginButton();
    		welcomePage.enterTheValueForCompanyName();
    		//welcomePage.clickOnNextButtonInWelcomePage();
    }
    	
    	@Test(groups ={"smoke","p1"})
    public void FT_Sprint1_0210_verifyOnEnteringTheCompanyNameandTapOnNextButton() throws Exception{
    		loginPage.verifyTheAppIsLaunched();  
    		loginPage.enterUserNameAndPasswordInLoginInPage();
    		loginPage.clickOnLoginButton();
    		welcomePage.enterTheValueForCompanyName();
    		welcomePage.clickOnNextButtonInWelcomePage();
    }

    
    @Test(groups ={"smoke","p1"})
    public void FT_Sprint1_0260_verifyCreatingTheShiftWithOneCrew() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_358_688_verifyCreatingTheShiftWithOneCrew() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
    }

    @Test(groups ={"smoke","p1"})
    public void verifyUserCanTapOnAddCrewButtoninWelcomePage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.clickOnAddCrewMemberButton();
        welcomePage.clickOnAddCrewMemberButton();
    }

    @Test(groups ={"smoke","p1"})
    public void NMA_355_685_verifyShiftSetupAddingOnlyOneCrewMember() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_354_verifyShiftSetupWith2CrewMembers() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnAddCrewMemberButton();
        welcomePage.enterTheSecondCrew();
        welcomePage.enterTheThirdCrew();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_684_verifyWelcomeORShiftSetupWithCrewMembers() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnAddCrewMemberButton();
        welcomePage.enterTheSecondCrew();
        welcomePage.enterTheThirdCrew();
    }


    @Test(groups ={"smoke","p1"})
    public void NMA_1360_verifyTheAlertMessageIFWEProvideIncorrectValuesInHomePage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        //welcomePage.verifyAlertMessageWhenProperDataIsNotEntered();
    }

    @Test(groups ={"smoke","p1"})
    public void verifyWithOutCompanyNameCanWeNavigateToTripListPage() throws Exception{
        loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();
        welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
//        welcomePage.verifyAlertMessageWhenProperDataIsNotEntered();
//        welcomePage.enterTheWrongValueForCompanyName();
//        welcomePage.clickOnNextButtonInWelcomePage();
//        tripList.tripListShouldNotDisplay();
    }
}
