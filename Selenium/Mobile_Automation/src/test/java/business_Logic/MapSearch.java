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
 * Created by M1040354 on 01/12/2018.
 */
public class MapSearch {

    private static AppiumDriver<MobileElement> driver;
    private static ActionUtility actionUtility = new ActionUtility();
    Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports report ;
    public static ExtentTest logger;

    //*********Maps PickUp***********
    @AndroidFindBy(className = "Search")
    private MobileElement mapSearchPickupActiveTrip;
    @AndroidFindBy(id = "txtTextSearch")
    private MobileElement mapSearchDropOffActiveTrip;
    @AndroidFindBy(id = "txtTextSearch")
    private MobileElement mapSearchPickupTripDetails;
    @AndroidFindBy(id = "txtTextSearch")
    private MobileElement mapSearchDropOffTripDetails;
    @AndroidFindBy(id = "txtTextSearch")
    private MobileElement clickOnMapSearch;
    @AndroidFindBy(id = "hybrid")
    private MobileElement satellite;
   
    @AndroidFindBy(id ="loadingProgressBar")
    private MobileElement spinner;
    @AndroidFindBy(id = "directions_Layout")
    private MobileElement mapsDirectionLayout;
    @AndroidFindBy(id ="view_DirectionCell")
    private MobileElement turnByTurn;
    
    

    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        MapSearch.driver = driver;
        actionUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void setLog(ExtentTest logger){

        MapSearch.logger = logger;
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
    
    public void enterAddressInMapSearchPickupTripDetails() throws Exception{
        
	    	try {
	        	
	    		fis = new FileInputStream("./DataSource/MapSearch.Properties");
	    	} catch (FileNotFoundException e) {
	                      e.printStackTrace();
	    	}
	       p.load(fis);
	       Thread.sleep(200);
	       actionUtility.click(clickOnMapSearch);
	       actionUtility.click(mapSearchPickupActiveTrip);
	       actionUtility.sendKeys(mapSearchPickupActiveTrip, p.getProperty("pickupSearchTripDetails"));
	       logger.log(LogStatus.INFO, "searched text in map is *** " +p.getProperty("pickupSearchTripDetails"));
    }

	public void clickOnSatellite(){
	        try{
                   actionUtility.click(satellite);
                   logger.log(LogStatus.INFO, "tapped on satellite button in map");
	        }catch (Exception e) {
                   logger.log(LogStatus.WARNING, "unable to tapped on satellite button in map");
                   throw e;
	        }
	}

	public void verifyTheDirectionLayoutDisplayedAfterClickingOnGPSIcon() throws Exception{
	        try{
               actionUtility.waitForElementVisible(turnByTurn, 10);
              
                              List <MobileElement> list1 = driver.findElements(By.id("mapdirection_Item"));
                              logger.log(LogStatus.INFO, "number of turn by turn direction is : " +list1.size());
                             
                              int n = list1.size();
               System.out.println(n);
               for(int i=0;i<=n;i++){
                              list1.get(i).click();
                              logger.log(LogStatus.INFO, "tapped on turn by turn direction list");
                              break;
               }
	        }catch (Exception e) {
	                       logger.log(LogStatus.WARNING, "unable to tapped on turn by turn direction in direction list");
	                       throw e;
	        }
	}
	

	public void verifyTheSpinnerAfterTappingGPSIcon() throws InterruptedException{
	        try{
	                       actionUtility.waitForElementVisible(spinner, 10);
	                       logger.log(LogStatus.INFO, "spinner or progress bar is displayed");
	        }catch(Exception e ){
	                       logger.log(LogStatus.INFO, "spinner or progress bar is not displayed");
	                       throw e;
	        }
	        //WebDriverWait wait = new WebDriverWait((WebDriver) spinner, 20);
	        //wait.until(ExpectedConditions.visibilityOf(spinner));
	}

       

    
}
