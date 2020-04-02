package business_Logic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ActionUtility;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import static io.appium.java_client.android.AndroidKeyCode.BACK;

public class LoginPage_Common {
    private static AppiumDriver<MobileElement> driver;
    private static ActionUtility actionUtility = new ActionUtility();
    Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports report ;
    public static ExtentTest logger;

    //*********Login page***********
    @FindBy(id = "txt_LoginUserName")
	private MobileElement userName;
    @FindBy(id = "txt_LoginPassword")
	private MobileElement passwordLogin;
    @FindBy(id = "img_Checkbox")
	private MobileElement rememberMe;
	@FindBy(id = "lbl_RememberMe")
	private MobileElement rememberMeText;
	@FindBy(id = "btn_LoginButton")
	private MobileElement loginButton;
	@FindBy(id ="txt_LoginUserName")
	private MobileElement loginPage;
	
//	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'pre '")
//	private List<IOSElement> yourList;
	
	@FindBy(id = "lbl_ForgotPassword")
	private MobileElement forgotPassword;
	@FindBy(id = "imageView_Logo")
	private MobileElement zollLogo;
	@FindBy(id = "Alert")
	private MobileElement alertLogin;
	@FindBy(id = "Ok")
	private MobileElement alerOKButton;
	@FindBy(id = "Both username and password are mandatory")
	private MobileElement alertLoginMessages;
	@FindBy(id = "Login username is not an valid email address")
	private MobileElement alertInvalidLoginMessages;
	@FindBy(id = "message")
	private MobileElement alertOnlySpecialCharactersLoginMessages;
	@FindBy(id = "button1")
	private MobileElement alertLoginOkButton;
	@FindBy(id = "lbl_Welcome")
	private MobileElement landingPage;

   	public void setDriver(AppiumDriver<MobileElement> driver)
	{
		LoginPage_Common.driver = driver;
		actionUtility.setDriver(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}

	public void setLog(ExtentTest logger){
   		LoginPage_Common.logger = logger;
	}
	
	public void beforeExtentReport(String testName){
		report = new ExtentReports("Extent_Report/MobileAndroidReport.html", true, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
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

	public void verifyTheAppIsLaunched()throws Exception{
		try{
			actionUtility.waitForElementVisible(loginPage,15);
			logger.log(LogStatus.INFO,"zoll navigator app is launched successfully");
			
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to launched zoll navigator app");
			throw e;
		}
	}

	public void verifyTheLoginScreenIsDisplayedWhenAppIsLaunched()throws Exception{
		try{
			//actionUtility.waitForElementVisible(loginPage,2);
			//driver.findElement(By.id("view_LoginFrame")).isDisplayed();
			Assert.assertTrue(loginPage.isDisplayed(), "login page is not displayed");
			logger.log(LogStatus.INFO,"login screen is displayed when zoll navigator app is launched");
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify login screen when zoll navigator app is launched");
			throw e;
		}
	}
	
	public void enterUserNameAndPasswordInLoginInPage() throws Exception {
		try {
			fis = new FileInputStream("DataSource/LoginData.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		//driver.hideKeyboard();
		//actionUtility.waitForElementVisible(loginPage, 30);
		actionUtility.sendKeys(userName, p.getProperty("login.username"));
		logger.log(LogStatus.INFO, "your user name is " +p.getProperty("login.username"));
		driver.hideKeyboard();
		actionUtility.sendKeys(passwordLogin, p.getProperty("login.password"));
		logger.log(LogStatus.INFO, "your password is " +p.getProperty("login.password"));
		driver.hideKeyboard();
	}

	public void enterInvalidUserNameAndPassword () throws Exception{
		try {
			fis = new FileInputStream("DataSource/LoginData.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(200);
//		driver.hideKeyboard();
		actionUtility.sendKeys(userName, p.getProperty("invalid.username"));
		logger.log(LogStatus.INFO, "your user name is " +p.getProperty("invalid.username"));
		driver.hideKeyboard();
		actionUtility.sendKeys(passwordLogin, p.getProperty("invalid.password"));
		logger.log(LogStatus.INFO, "your password is " +p.getProperty("invalid.password"));
		driver.hideKeyboard();
	}
	public void enterInvalidSpecialCharactersUserNameAndPassword () throws Exception{

			try {
				fis = new FileInputStream("DataSource/LoginData.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p.load(fis);
			Thread.sleep(200);
			actionUtility.sendKeys(userName, p.getProperty("special.username"));
			logger.log(LogStatus.INFO, "your special character user name is " +p.getProperty("special.username")+" not allowed");
			driver.hideKeyboard();
			actionUtility.sendKeys(passwordLogin, p.getProperty("special.password"));
			logger.log(LogStatus.INFO, "your special character password is " +p.getProperty("special.password")+" not allowed");
			driver.hideKeyboard();
	}
	
	public void enterUserNameAndPasswordMaximumCharactersInLoginPage () throws Exception{

		try {
			fis = new FileInputStream("DataSource/LoginData.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(200);
		actionUtility.sendKeys(userName, p.getProperty("maxchar.un"));
		logger.log(LogStatus.INFO, "your special character user name is " +p.getProperty("maxchar.un")+" not allowed");
		driver.hideKeyboard();
		actionUtility.sendKeys(passwordLogin, p.getProperty("maxchar.pw"));
		logger.log(LogStatus.INFO, "your special character password is " +p.getProperty("maxchar.pw")+" not allowed");
		driver.hideKeyboard();
}
	public void clickOnLoginButton() throws Exception {
		// to click on login button
		try{
			//driver.findElement(By.id("btn_LoginButton")).click();
			actionUtility.click(loginButton);
			logger.log(LogStatus.INFO,"clicked on login button in login page");
			driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to clicked on login button");
			throw e;
		}
		//Thread.sleep(500);
	}
	public void verifyTheRememberMeOptionInLoginPage() throws Exception{
		try{
			Assert.assertTrue(actionUtility.verifyIfElementIsDisplayed(rememberMe), "Remember Me is not displayed in login page");
			logger.log(LogStatus.INFO,"Remember Me option is displayed in login page");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING, "Remember Me is not displayed in login page" );
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify the Remember Me option is login page");
			throw e;
		}
	}

	public void verifyTheForgotPasswordOptionIsDisplayed() throws Exception{
		// to verify the forgot password option in login page
		try{
			Assert.assertTrue(actionUtility.verifyIfElementIsDisplayed(forgotPassword), "forgot password is not displayed in login page");
			logger.log(LogStatus.INFO,"forgot password is displayed in login page");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING, "forgot password is not displayed in login page" );
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify forgot password in login page");
			throw e;
		}
	}
	public void verifyloginButtonIsDisplayedInLoginPage() throws Exception{
		//to verify the login button in login page
    	try{
    		Assert.assertTrue(actionUtility.verifyIfElementIsDisplayed(loginButton), "login button is not displayed in login page");
    		actionUtility.waitForElementClickable(loginButton,2);
    		logger.log(LogStatus.INFO,"login button is displayed in login page");
    	}catch (AssertionError e){
            logger.log(LogStatus.WARNING, "login button is not displayed in login page" );
            throw e;
        }catch (Exception e){
    		logger.log(LogStatus.WARNING,"unable to verify login button in login page");
    		throw e;
    	}
    }

	public void userEnterTheBlankUserNameAndBlankPassword() throws Exception{
		// to enter the blank user name and blank password
		try {
			fis = new FileInputStream("DataSource/LoginData.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(200);
//		driver.hideKeyboard();
		actionUtility.waitForElementVisible(loginPage, 2);
		driver.findElement(By.id("txt_LoginUserName")).clear();
		driver.hideKeyboard();
		//actionUtility.sendKeys(userName, p.getProperty("login.username"));
		logger.log(LogStatus.INFO, "your user name is empty");
		driver.findElement(By.id("txt_LoginPassword")).clear();
		driver.hideKeyboard();
		//actionUtility.sendKeys(passwordLogin, p.getProperty("login.password"));
		logger.log(LogStatus.INFO, "your password is empty");
		
	}
    public void verifyTheAlertMessageWhenUserNameAndPasswordIsEmpty()throws Exception{
		// to verify the alert message when user clicks on login button without user name and password
		String alertMessage = "Both username and password are mandatory";
		
		try{
			//actionUtility.waitForElementVisible(alertLogin,1);
			Assert.assertTrue(alertLogin.isDisplayed(), "login alert is not displayed");
			logger.log(LogStatus.INFO,"alert dialog is displayed when user name & password is empty");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"alert dialog is not displayed when user name & password is empty");
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify the alert dialog when use name & password is empty in login page");
			throw e;
		}
		try{
			Assert.assertEquals(alertLoginMessages.getText().toLowerCase(),alertMessage.toLowerCase(), "alert Message is not matching");
			logger.log(LogStatus.INFO,"alert message is displayed and its matching the expected message");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"alert message is not matching");
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify the alert message in login page");
			throw e;
		}
		try{
			actionUtility.click(alerOKButton);
			logger.log(LogStatus.INFO,"successfully clicked on OK button in alert dialog");
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to click on OK button in alert dialog login page");
			throw e;
		}
	}
    
	public void verifyTheAlertMessageWhenUserNameAndPasswordIsInvalid()throws Exception{
		// to verify the alert message when user clicks on login button when user name and password invalid
		String invalidAlertMessage = "Login username is not an valid email address";
		try{
			Assert.assertEquals(alertInvalidLoginMessages.getText().toLowerCase(),invalidAlertMessage.toLowerCase(), "invalid alert Message is not matching");
			logger.log(LogStatus.INFO,"invalid alert message is displayed and its matching the expected message");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"invalid alert message is not matching");
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify the invalid alert message in login page");
			throw e;
		}
		try{
			actionUtility.click(alerOKButton);
			logger.log(LogStatus.INFO,"successfully clicked on OK button in invalid alert dialog");
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to click on OK button in invalid alert dialog login page");
			throw e;
		}
	}

	public void verifyMessageWhenUserEntersOnlySpecialCharactersForUserNameAndPassword()throws Exception{
		// to verify the alert message when user clicks on login button when user name and password invalid
		String invalidAlertMessage = "Please enter a valid email";
		try{
			Assert.assertEquals(alertOnlySpecialCharactersLoginMessages.getText().toLowerCase(),invalidAlertMessage.toLowerCase(), "alert Message is not matching");
			logger.log(LogStatus.INFO,"for special characters alert message is displayed and its matching the expected message");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"for special characters alert message is not matching, Expected: "+invalidAlertMessage );
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify special characters alert message in login page");
			throw e;
		}
		try{
//			actionUtility.click(alertLoginOkButton);
			logger.log(LogStatus.INFO,"successfully clicked on OK button in special characters alert dialog login page");
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to click on OK button in special characters alert dialog login page");
			throw e;
		}
	}

	public void verifyLandingPageAfterLogin()throws Exception{
		try{
			actionUtility.waitForElementVisible(landingPage,1);
			Assert.assertTrue(landingPage.isDisplayed(), "landing page is not displayed");
			logger.log(LogStatus.INFO,"welcome page is displayed after successful login");
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"welcome page is not displayed after successful login");
			throw e;
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to verify the welcome page after login");
			throw e;
		}
	}

	public void verifyTappingOnBackButtonShouldNotLogoutTheUserFromLandingPage()throws  Exception{
		try{
			actionUtility.clickBackButton();
			logger.log(LogStatus.INFO,"clicked on back button from landing page without logged out");
		}catch (Exception e){
			logger.log(LogStatus.WARNING,"unable to click on back button from landing page");
			throw e;
		}
		try{
			if (loginButton.isDisplayed()){
				Assert.assertTrue(loginPage.isDisplayed());
				logger.log(LogStatus.WARNING,"login page is displayed when user is logged in and just pressed on back button");

			}else {
				//Assert.assertTrue(landingPage.isDisplayed(), "landing page is not displayed");
				logger.log(LogStatus.INFO,"login page is not displayed when user is logged in and just pressed on back button");
			}
		}catch (AssertionError e){
			logger.log(LogStatus.WARNING,"login page got displayed ");
			throw e;
		}

	}
	
	public String getNum(String para){
		StringTokenizer st = new StringTokenizer(para);
		String  number="";
		while (st.hasMoreElements()){
			if(isNum((String)st.nextElement())){
				number= (String)st.nextElement();
			}
		}
		return number;
	}
	
	public boolean isNum(String st){

		return st.matches("[-+]?\\d*\\.?\\d+");
	}

	public void navigateBackWithMobileBackButton()throws Exception{
		try{
			actionUtility.clickBackButton();
			logger.log(LogStatus.INFO,"successfully clicked on back button or navigate back button");
		}catch(Exception e){
			logger.log(LogStatus.WARNING,"unable to clicked on back button or navigate back button");
			throw e;
		}
	}

	public void screenOrientation()throws Exception{
		try{
			driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
			logger.log(LogStatus.INFO,"successfully clicked on back button or navigate back button");
		}catch(Exception e){
			logger.log(LogStatus.WARNING,"unable to clicked on back button or navigate back button");
			throw e;
		}
	}
}
