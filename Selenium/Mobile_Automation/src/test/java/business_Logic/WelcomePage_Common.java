package business_Logic;

import com.relevantcodes.extentreports.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ActionUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by M1040354 on 10/30/2017.
 */
public class WelcomePage_Common {

    private static AppiumDriver<MobileElement> driver;
    private static ActionUtility actionUtility = new ActionUtility();
    Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports report ;
    public static ExtentTest logger;

    //*********Welcome page***********
    @FindBy(name = "img_AddCrew")
    private MobileElement AddCrewMemberButtons;
    @FindBy(id = "img_AddCrew")
    private MobileElement AddCrewMemberButton;
    @FindBy(id = "lbl_AddCrewMember")
    private MobileElement AddCrewLable;
    @FindBy(id = "Btn_Next")
    private MobileElement nextButton;
    @FindBy(id = "lbl_Welcome")
    private MobileElement welcomePage;
    @FindBy(id = "OK")
    private MobileElement alertOKbutton;
//    @FindBy(id = "crewDetailsLayout")
//    private MobileElement welcomeCrewDetailsLayout;
    @FindBy(id = "btn_CompanyName")
    private MobileElement companyName;
    @FindBy(id = "txt_VehicleNumber")
    private MobileElement SelectVehicle;
    @FindBy(id = "txt_Unit")
    private MobileElement unit;
    @FindBy(id = "lbl_CrewMember1")
    private MobileElement crewMemeber1;
    @FindBy(id = "lbl_CrewMember2")
    private MobileElement crewMemeber2;
    @FindBy(id = "txt_CrewMember3")
    private MobileElement crewMemeber3;
    @FindBy(id = "txt_CrewMember4")
    private MobileElement crewMemeber4;
    @FindBy(id = "txt_CrewMember5")
    private MobileElement crewMemeber5;
    @FindBy(id = "txt_CrewMember6")
    private MobileElement crewMemeber6;
    @FindBy(id = "txt_CrewMember7")
    private MobileElement crewMemeber7;
    @FindBy(id = "txt_CrewMember8")
    private MobileElement crewMemeber8;
    @FindBy(id = "txt_CrewMember3")
    private MobileElement crewMemeber9;
    
    @FindBy(id = "lbl_Timer")
    private MobileElement timer;
    @FindBy(id = "lbl_Username")
    private MobileElement welcomeUserName;
    
    @FindBy(id = "message")
    private MobileElement WithoutDataTapNextAlertMessage;
    @FindBy(id = "button1")
    private MobileElement okButtonNextAlertMessage;
    

    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        WelcomePage_Common.driver = driver;
        actionUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void setLog(ExtentTest logger){

        WelcomePage_Common.logger = logger;
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

    
    public void clickOnNextButtonInWelcomePage()throws Exception{
        try{
            actionUtility.waitForElementVisible(nextButton,2);
            actionUtility.click(nextButton);
            logger.log(LogStatus.INFO,"clicked on next button in welcome page");
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to clicked on next button in welcome page");
            throw e;
        }
    }

    public void verifyTheWelcomePageAfterLogin()throws Exception {
        try {
            actionUtility.waitForElementVisible(welcomePage, 10);
            Assert.assertTrue(welcomePage.isDisplayed(), "Welcome page is not displayed");
            logger.log(LogStatus.INFO, "Welcome page is displayed after successful login");
            driver.hideKeyboard();
        } catch (AssertionError e) {
            logger.log(LogStatus.WARNING, "Welcome screen with crew member is not displayed after successful login");
            throw e;
        } catch (Exception e) {
            logger.log(LogStatus.WARNING, "unable to verify the crew member in welcome screen after login");
            throw e;
        }
    }

    public void enterTheValueForCompanyName()throws Exception{
        try{
        	
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            //Thread.sleep(200);
            actionUtility.waitForElementVisible(companyName, 50000);
            actionUtility.click(companyName);
            actionUtility.selectAutoSuggestionDisplayBottom(companyName, p.getProperty("company.name1"));
            //actionUtility.sendKeys(companyName, p.getProperty("company.name1"));
            logger.log(LogStatus.INFO, "company name "+p.getProperty("company.name1")+" entered successfully" );
            driver.hideKeyboard();
            Thread.sleep(500);
        }catch (Exception e){
            logger.log(LogStatus.WARNING, "Not able to enter company name "+p.getProperty("company.name1"));
            throw e;
        }
    }
    
    public void enterTheWrongValueForCompanyName() throws Exception {
    	try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(companyName, p.getProperty("wrongCompany.name2"));
            logger.log(LogStatus.INFO, "company name "+p.getProperty("wrongCompany.name2")+" entered successfully" );
            driver.hideKeyboard();
            Thread.sleep(1500);
        }catch (Exception e){
            logger.log(LogStatus.WARNING, "Not able to enter company name "+p.getProperty("company.name1"));
            throw e;
        }
    	
    }

    public void enterTheVehicle()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.click(SelectVehicle);
            actionUtility.selectAutoSuggestionDisplayBottom(SelectVehicle, p.getProperty("select.Vehicle"));
            //actionUtility.sendKeys(SelectVehicle, p.getProperty("select.Vehicle"));
            logger.log(LogStatus.INFO, "vehicle "+p.getProperty("select.Vehicle")+" selected successfully" );
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "Not able to select vehicle "+p.getProperty("company.name1"));
            throw e;
        }
    }
    
    public void enterORSelectTheVehicle()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(SelectVehicle, p.getProperty("select.Vehicle"));
            logger.log(LogStatus.INFO, "unit "+p.getProperty("unit1")+" selected successfully" );
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to select unit "+p.getProperty("unit1"));
            throw e;
        }
    }

    public void enterTheUnit()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(unit, p.getProperty("unit1"));
            logger.log(LogStatus.INFO, "unit "+p.getProperty("unit1")+" selected successfully" );
            driver.hideKeyboard();
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to select unit "+p.getProperty("unit1"));
            throw e;
        }
    }

    public void clickOnAddCrewMemberButton() throws Exception{
    	try{
    		AddCrewMemberButtons.isDisplayed();
//    			String a = AddCrewMemberButton.getAttribute("id");
//    			System.out.println(a);
			//actionUtility.click(AddCrewMemberButtons);
    			actionUtility.click(AddCrewMemberButton);
            logger.log(LogStatus.INFO,"clicked on Add Crew Member button in welcome page");
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to clicked on Add Crew Member button in welcome page");
            throw e;
        }
    }
    
    public void enterTheFirstCrew()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(crewMemeber1, p.getProperty("crew.member1"));
            logger.log(LogStatus.INFO, "first crew member "+p.getProperty("crew.member1")+" added successfully" );
            driver.hideKeyboard();
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to add first crew member "+p.getProperty("crew.member1"));
            throw e;
        }
    }
    public void enterTheSecondCrew()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(crewMemeber2, p.getProperty("crew.member2"));
            logger.log(LogStatus.INFO, "first crew member "+p.getProperty("crew.member2")+" added successfully" );
            driver.hideKeyboard();
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to add second crew member "+p.getProperty("crew.member2"));
            throw e;
        }
    } 
    public void enterTheThirdCrew()throws Exception{
        try{
            try {
                fis = new FileInputStream("DataSource/WelcomePageData.Properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            p.load(fis);
            Thread.sleep(200);
            actionUtility.sendKeys(crewMemeber3, p.getProperty("crew.member3"));
            logger.log(LogStatus.INFO, "first crew member "+p.getProperty("crew.member2")+" added successfully" );
            driver.hideKeyboard();
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to add second crew member "+p.getProperty("crew.member3"));
            throw e;
        }
    } 
    
    public void verifyAlertMessageWhenClickedOnNextButtonWithOutData() throws Exception{
    	// click on OK button and verified the error message when we clicked on next button without filling any data in welcome page
    	String AlertMessageClickOnNextButton = "Some of the values captured are invalid to proceed";
    	try{
    		Assert.assertEquals(WithoutDataTapNextAlertMessage.getText().toLowerCase(),AlertMessageClickOnNextButton.toLowerCase(), "invalid alert Message is not matching");
    		logger.log(LogStatus.INFO,"successfully verified the alert message when we click on next button with out filling data in welcome page");
            actionUtility.click(WithoutDataTapNextAlertMessage);
            logger.log(LogStatus.INFO,"clicked on Ok button in alert message, when we clicked on next button without filling any data in welcome page");
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to verify the alert message, when we clicked on next button without filling any data in welcome page");
            throw e;
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to clicked on OK button in alert message, when we clicked on next button without filling any data in welcome page");
            throw e;
        }
    }
    
    public void verifyAlertMessageWhenProperDataIsNotEntered() throws Exception{
    	// click on OK button and verified the error message when we clicked on next button without filling proper data in welcome page
    	String AlertMessageClickOnNextButton = "Some of the values entered is incorrect.";
    	try{
    		Assert.assertEquals(WithoutDataTapNextAlertMessage.getText().toLowerCase(),AlertMessageClickOnNextButton.toLowerCase(), "alert Message is not matching");
    		logger.log(LogStatus.INFO,"successfully verified the alert message when we click on next button with out filling data in welcome page");
            actionUtility.click(WithoutDataTapNextAlertMessage);
            logger.log(LogStatus.INFO,"clicked on Ok button in alert message in welcome page");
        }catch (AssertionError e){
            logger.log(LogStatus.WARNING, "not able to verify the alert message in welcome page");
            throw e;
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to clicked on OK button in alert message in welcome page");
            throw e;
        }
    }
    
    
    
}
