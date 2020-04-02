package test_definition;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
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

import org.openqa.selenium.By;
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
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import utilities.DriverBuilder;

public class LoginPage extends BasePageRegression{

	
	/*
	 * Login Page
	 * 
	 */
	
	@Test(groups ={"smoke", "p1"})
	public void FT_Sprint1_0010_VerifyTheZollNavigatorAppIsLaunched() throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.clickOnLoginButton();	
	}
	
	@Test(groups ={"smoke","p1"})
	public void FT_Sprint1_0020_VerifyTheLoginScreenDisplayed() throws Exception{
		loginPage.verifyTheLoginScreenIsDisplayedWhenAppIsLaunched();
	}
	
	@Test(groups ={"smoke","p1"})
	public void FT_Sprint1_0050_VerifyTheRememberMeOptionIsDisplayedInLoginScreen() throws Exception{
		loginPage.verifyTheRememberMeOptionInLoginPage();
	}
	
	@Test(groups ={"smoke","p1"})
	public void FT_Sprint1_0150_VerifyForgotPasswordOptionIsDisplayedInLoginPage() throws Exception{
		loginPage.verifyTheForgotPasswordOptionIsDisplayed();
	}
	@Test(groups = {"smoke", "p1"})
	public void FT_Sprint1_0070_VerifyTheUserOnceLoggedAndClickedOnBackButtonUserIsNotLogout()throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.enterUserNameAndPasswordInLoginInPage();
		loginPage.clickOnLoginButton();
		loginPage.verifyLandingPageAfterLogin();
		loginPage.verifyTappingOnBackButtonShouldNotLogoutTheUserFromLandingPage();
	}
	
	@Test(groups ={"smoke","p1"})
	public void VerifyLoginButtonIsDisplayedInLoginPage() throws Exception{
		loginPage.verifyloginButtonIsDisplayedInLoginPage();
	}
	
	@Test(groups = {"smoke", "p1"})
	public void FT_Sprint1_0040_VerifyTheUserIsNotAbleToLoginWithBlankUserNameAndPassword() throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.userEnterTheBlankUserNameAndBlankPassword();
		loginPage.clickOnLoginButton();
		loginPage.verifyTheAlertMessageWhenUserNameAndPasswordIsEmpty();
	}
	
	@Test
	public void NMA_664_666_VerifyTheUserIsAbleToLoginWithValidUserNameAndPassword() throws Exception {
		loginPage.verifyTheAppIsLaunched();
		loginPage.enterUserNameAndPasswordInLoginInPage();
		loginPage.clickOnLoginButton();
	}
	
	@Test(groups = {"smoke","p1"})
	public void NMA_665_verifyTheUserIsAbleToLoginWithInvalidUserNameAndPassword() throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.enterInvalidUserNameAndPassword();
		loginPage.clickOnLoginButton();
		loginPage.verifyTheAlertMessageWhenUserNameAndPasswordIsInvalid();
	}
	
	@Test(groups = {"smoke","p1"})
	public void NMA_673_verifyTheUserIsAbleToLoginWithOnlySpecialCharactersUserNameAndPassword() throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.enterInvalidSpecialCharactersUserNameAndPassword();
		loginPage.clickOnLoginButton();
		loginPage.verifyMessageWhenUserEntersOnlySpecialCharactersForUserNameAndPassword();
	}
	
	@Test(groups = {"smoke","p1"})
	public void NMA_671_VerifyTheEnterUserNameAndPasswordMaximumCharactersInLoginPage() throws Exception{
		loginPage.verifyTheAppIsLaunched();
		loginPage.enterUserNameAndPasswordMaximumCharactersInLoginPage();
		loginPage.clickOnLoginButton();
		loginPage.verifyTheAlertMessageWhenUserNameAndPasswordIsInvalid();
	}
	
	@Test(groups = {"smoke","p1"})
	public void FNMA_677_VerifyAppLockedToProtraitModeWhenUserChangesOrientation() throws Exception{
		loginPage.screenOrientation();
	}
	
	
}
