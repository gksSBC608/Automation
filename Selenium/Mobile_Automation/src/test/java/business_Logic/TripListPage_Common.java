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
public class TripListPage_Common {

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
    
    @FindBy(id = "lbl_Timer")
    private MobileElement timerTripList;
    /****to select trips***/
    @FindBy(id = "View_TripListTableCell")
    private MobileElement toSelectFirstTripList;
    
    @FindBy(id = "btn_Triplist")
    private MobileElement tripList;
    @FindBy(id = "btn_ActiveTrip")
    private MobileElement activeTrip;
    @FindBy(id = "lbl_Timer")
    private MobileElement activeTripTime;
    @FindBy(id = "View_TripListTableCell")
    private MobileElement tripListLayout;
    
//    @FindBy(id = "")
//    private MobileElement DeviceLocationAccess;
//    @FindBy(id = "")
//    private MobileElement allowDeviceLocationAccess;
    @FindBy(id = "View_TripListTableCell")
    private MobileElement firstTripList;
    @FindBy(id = "lbl_RespondTimer")
    private MobileElement zollRespondSpinner;
    @FindBy(id = "view_TimerView")
    private MobileElement zollRespondLayout;
    @FindBy(id = "view_IncidentView")
    private MobileElement incidentText;
    
    /***ActiveTrip***/
    //@FindBy(id = "tabs")
    //private MobileElement subMenuTabsInActiveTrip;
    @FindBy(id = "btn_PatientInfo")
    private MobileElement tripInformationActiveTrip;
    @FindBy(id = "btn_TripInfo")
    private MobileElement tripInformationPatientInfo;
    @FindBy(id = "lbl_Name")
    private MobileElement patientName;
    @FindBy(id = "lbl_Age")
    private MobileElement patientAge;
    @FindBy(id = "lbl_Sex")
    private MobileElement patientGender;
    @FindBy(id = "lbl_Weight")
    private MobileElement patientWeight;
    @FindBy(id = "lbl_PatientNote")
    private MobileElement tripInformationNote;
    @FindBy(id = "lbl_PatientAlert")
    private MobileElement patientAlert;
    
    /***Pick up ****/
    @FindBy(id = "btn_PickUp")
    private MobileElement pickUp;
    @FindBy(id = "lbl_Run")
    private MobileElement pickUpRun;
    @FindBy(id = "lbl_TripNo")
    private MobileElement pickUpTripNo;
    @FindBy(id = "lbl_PickUpCenter")
    private MobileElement pickUpLocation;
    @FindBy(id = "lbl_PickUpAddress3")
    private MobileElement pickUpAddress1;
    @FindBy(id = "lbl_PickUpAddress2")
    private MobileElement pickUpAddress2;
    @FindBy(id = "lbl_PickUpPhone")
    private MobileElement pickUpPhoneNumber;
    @FindBy(id = "img_GPS")
    private MobileElement gps;
    @FindBy(id = "view_PickUpMap")
    private MobileElement pickUpMAP;
    @FindBy(id = "")
    private MobileElement myLocationIconInGoogleMap;
    @FindBy(id = "view_DirectionCell")
    private MobileElement navigateDirectionInGoogleMap;
    
    /***Drop Off***/
    @FindBy(id = "btn_DropOff")
    private MobileElement dropOff;
    @FindBy(id = "lbl_Run")
    private MobileElement dropOffRun;
    @FindBy(id = "lbl_TripNo")
    private MobileElement dropOffTripNumber;
    @FindBy(id = "lbl_PickUpCenter")
    private MobileElement dropOffLocation;
    @FindBy(id = "lbl_PickUpAddress3")
    private MobileElement dropOffAddress1;
//    @FindBy(id = "lbl_DropOffAddress")
//    private MobileElement dropOffAddress2;
    @FindBy(id = "lbl_PickUpAddress")
    private MobileElement dropOffPhoneNumber;
    @FindBy(id = "img_GPS")
    private MobileElement gpsDropOff;
    @FindBy(id = "view_PickUpMap")
    private MobileElement dropOffMAP;
    @FindBy(id = "btn_DirectionsDropOff")
    private MobileElement DropOffMyLocationIconInGoogleMap;
    
   ///----------
    /*************Trip Details********/
    @FindBy(id = "lbl_TripDetails")
    private MobileElement verfiyTripDetailsPage;
    @FindBy(id ="lbl_TripStatus")
    private MobileElement tripStatusTipDetails;
    @FindBy(id="btn_Back")
    private MobileElement backButtonTripDetails;
    @FindBy(id = "view_PickUpMap")
    private MobileElement pickUpMAPTripDetails;
    @FindBy(id = "")
    private MobileElement satelliteVeiwButton;
    
    
    /*********Trip Details-Trip Information*****/
    @FindBy(id = "btn_TripInfo")
    private MobileElement tripInformationTripDetails;
    @FindBy(id = "img_ForwardNavigation")
    private MobileElement forwardNavigation;
    @FindBy(id = "img_BackwardNavigation")
    private MobileElement backwardNavigation;
    @FindBy(id = "")
    private MobileElement menu;
    
    @FindBy(id = "lbl_Name")
    private MobileElement patientName2;
    @FindBy(id = "lbl_Location")
    private MobileElement patientLocation2;
    @FindBy(id = "lbl_Age")
    private MobileElement patientAge2;
    @FindBy(id = "lbl_Sex")
    private MobileElement patientGender2;
    @FindBy(id = "lbl_Weight")
    private MobileElement patientWeight2;
    @FindBy(id = "")
    private MobileElement patientAlert2;
    
    @FindBy(id = "lbl_Run")
    private MobileElement run2;
    @FindBy(id = "lbl_Trip")
    private MobileElement trip2;
    @FindBy(id = "lbl_CallType")
    private MobileElement callType2;
    @FindBy(id = "lbl_DispatchPriority")
    private MobileElement dispatch2;
    @FindBy(id = "lbl_Nature")
    private MobileElement nature2;
    @FindBy(id = "lbl_Status")
    private MobileElement status2;
    @FindBy(id = "lbl_Company")
    private MobileElement company2;
    @FindBy(id = "lbl_Crew")
    private MobileElement crew2;
    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"ZOLLRespond\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable[2]")
    private MobileElement notes2;
    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"ZOLLRespond\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextView")
    private MobileElement cadComment2;
    
    @FindBy(id ="view_Status")
    private MobileElement tripListStatusGreenColor;
    @FindBy(id ="lbl_ListRun")
    private MobileElement runNumberTripList;
    @FindBy(id ="lbl_ListTrip")
    private MobileElement tripNumberTripList;
    @FindBy(id ="lbl_ListPickUpLocation")
    private MobileElement pickUpLocationTripList;
    @FindBy(id ="lbl_ListPickuptime")
    private MobileElement pickUpTimeTripList;
    @FindBy(id ="lbl_ListPatientName")
    private MobileElement patientNameTripList;
    @FindBy(id ="lbl_ListNature")
    private MobileElement natureTripList;
    @FindBy(id ="lbl_ListStatus")
    private MobileElement statusTripList;
    @FindBy(id ="lbl_RunNumber")
    private MobileElement tripDetailsHeaderRunNumber;
    @FindBy(id = "lbl_TripId")
    private MobileElement tripDetailsHeaderTripIDNumber;
    
    
    
    

    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        TripListPage_Common.driver = driver;
        actionUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void setLog(ExtentTest logger){

        TripListPage_Common.logger = logger;
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
    
    public void verifyTheEnRouteButtonIsDisplayed() throws Exception{
    	try{
    		 actionUtility.waitForElementVisible(enRouteButton,2);
    		Assert.assertTrue(enRouteButton.isDisplayed(), "en route button is not displayed");
			logger.log(LogStatus.INFO,"en route button is displayed in trip list page");
        }catch(AssertionError e){
        	logger.log(LogStatus.WARNING,"en route button is not displayed in trip list page");
        	throw e;
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to verify en route button in trip list page");
            throw e;
        }
    }
    
    public void verifyAtSceneButtonIsDisplayed(){
    	try{
    		Assert.assertTrue(atSceneButton.isDisplayed(), "at scene button is not displayed");
			logger.log(LogStatus.INFO,"at scene button is displayed in trip list page");
        }catch(AssertionError e){
        	logger.log(LogStatus.WARNING,"at scene button is not displayed in trip list page");
        	throw e;
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to verify at scene button in trip list page");
            throw e;
        }
    }
    
    public void verifyTransportingButtonIsDisplayed(){
    	try{
    		Assert.assertTrue(transportingButton.isDisplayed(), "transporting button is not displayed");
			logger.log(LogStatus.INFO,"transporting button is displayed in trip list page");
        }catch(AssertionError e){
        	logger.log(LogStatus.WARNING,"transporting button is not displayed in trip list page");
        	throw e;
        }catch (Exception e){
            logger.log(LogStatus.WARNING,"unable to verify transporting button in trip list page");
            throw e;
        }
    }
    
    public void verifyCompleteButtonIsDisplayed(){
	    	try{
	    		Assert.assertTrue(completeButton.isDisplayed(), "complete button is not displayed");
				logger.log(LogStatus.INFO,"complete button is displayed in trip list page");
	    	}catch(AssertionError e){
	        	logger.log(LogStatus.WARNING,"complete button is not displayed in trip list page");
	        	throw e;
	    	}catch (Exception e){
	            logger.log(LogStatus.WARNING,"unable to verify complete button in trip list page");
	            throw e;
	    	}
    }
    
    public void verifyTrimerIsDisplayed(){
	    	try{
	    		Assert.assertTrue(timerTripList.isDisplayed(), "trimer button is not displayed");
				logger.log(LogStatus.INFO,"trimer button is displayed in trip list page");
	    	}catch(AssertionError e){
	        	logger.log(LogStatus.WARNING,"trimer button is not displayed in trip list page");
	        	throw e;
	    	}catch (Exception e){
	            logger.log(LogStatus.WARNING,"unable to verify trimer button in trip list page");
	            throw e;
	    	}
	    	
	    	try{
	    		String trimer = timerTripList.getText();
	    		Assert.assertTrue(timerTripList.isDisplayed(), "trimer is not displayed");
				logger.log(LogStatus.INFO,"trimer is displayed in trip list page");
				logger.log(LogStatus.INFO,"trip time started "+trimer);
	    	}catch(AssertionError e){
	        	logger.log(LogStatus.WARNING,"trimer button is not displayed in trip list page");
	        	throw e;
	    	}catch (Exception e){
	            logger.log(LogStatus.WARNING,"unable to verify trimer button in trip list page");
	            throw e;
	    	}
    
    }

    
    public void verifyTripListHeader(){
		// to verify the list list table displayed in trip list page
		try{
    		Assert.assertTrue(tripList.isDisplayed(), "trip list header is not displayed");
    		logger.log(LogStatus.INFO,"trip list header is displayed trip list page");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING,"unable to verfiy the trip list header in trip list page");
	    		throw e;
	    	}
	}
	
	public void VerifyActiveTripHeader(){
		// to verify the list list table displayed in trip list page
		try{
    		Assert.assertTrue(activeTrip.isDisplayed(), "active trip header is not displayed");
    		logger.log(LogStatus.INFO,"active trip header is displayed trip list page");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING,"unable to verfiy the active trip header in trip list page");
	    		throw e;
	    	}
	}
    
	public void toVerifyTheTimeInTripListPage(){
		// to verify the time in tirp list after navigating from welcome page
		try{
			Assert.assertTrue(activeTripTime.isDisplayed(), "active trip time is not displayed");
    		logger.log(LogStatus.INFO,"active trip time is = " +activeTripTime.getText());
			
		}catch(Exception e){
			logger.log(LogStatus.WARNING, "active trip time is not able to verify");
			throw e;
		}
	}
	
	public void toVerifyTheTripListIsDisplayedinTripPage(){
		//to verify the trip list layout in tip page
		try{
			Assert.assertTrue(tripListLayout.isDisplayed(), "trip list layout is not displayed");
			logger.log(LogStatus.INFO, "tipr lists are displayed in trip page");
			
		}catch(AssertionError e){
			logger.log(LogStatus.WARNING, "trip list table is not displayed for verification");
			throw e;
		}catch(Exception e){
			logger.log(LogStatus.WARNING, "trip list table is not able to verify");
			throw e;
		}
		
	}
    public void selectOneTripFromTripList(){
	    	try{
	    		actionUtility.click(firstTripList);
	    		logger.log(LogStatus.INFO,"first trip is selected in trip list");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING,"unable to select the trip in trip list table");
	    		throw e;
	    	}
    }
    
    public void toTapOnZollRespond() throws InterruptedException{
    	//zoll respond UI will display after selecting the trip list
    	Thread.sleep(2000);
	    	try{
	    		if(zollRespondSpinner.isDisplayed()){
	    			logger.log(LogStatus.INFO,"zoll respond layout and spinner is displayed");
	    			logger.log(LogStatus.INFO,"incident was responded in  " +zollRespondSpinner.getText());
	    			actionUtility.click(zollRespondLayout);
	    			//logger.log(LogStatus.INFO,"zoll respond layout and spinner is displayed");
	    			//logger.log(LogStatus.INFO,"incident was responded in  " +zollRespondSpinner.getText());
	    			Thread.sleep(1500);
	    		}else{
	    			
	    			logger.log(LogStatus.INFO,"zoll respond layout and spinner is not displayed");
	    		}
	    	
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify zoll respond  layout and spinner");
	    		throw e;
	    	}
    }
    public void toVerifyTheSubMenuTabsInActiveTrip() throws InterruptedException{
    	Thread.sleep(4000);
	    	try{
	    		Assert.assertTrue(pickUp.isDisplayed(), "pick up tab sub menu tab are not displayed");
	    		Assert.assertTrue(tripInformationActiveTrip.isDisplayed(), "trip info / patient info sub menu tab are not displayed");
	    		//Assert.assertTrue(dropOff.isDisplayed(), "drop off is not displayed in sub menu tab");
	    		logger.log(LogStatus.INFO, "pick-up, tip-information and drop-off tabs are displayed under active trip");
	    	}catch(AssertionError e) {
	    		logger.log(LogStatus.WARNING, "sub menus in avtive trip page is not displayed");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify the sub menu tabs in avtive trip page");
	    		throw e;
	    	}
    }
    public void navigateToTripInformationTabORPatientInformation(){
    	// to verify the patient information 
	    	try{
	    		actionUtility.click(tripInformationActiveTrip);
	    		logger.log(LogStatus.INFO, "navigate to tip inforamtion or patient info page in trip details");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to navigate to trip information page in trip details");
	    		throw e;
	    	}
    }
    
    public void verifyThePatientInformationNameAgeGenderweightANdNote(){
    	// to verify the patient age name gender note and alert
	    	try{
	    		Assert.assertTrue(patientName.isDisplayed(), "patient name is not displayed");
	    		logger.log(LogStatus.INFO, "patient name is - "+patientName.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient name is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient name");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(patientAge.isDisplayed(), "patient age is not displayed");
	    		logger.log(LogStatus.INFO, "patient age is - "+patientAge.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient age is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient age");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(patientGender.isDisplayed(), "patient gender is not displayed");
	    		logger.log(LogStatus.INFO, "patient gender is - "+patientGender.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient age is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient gender");
	    		throw e;
	    	}
	    	try{
//	    		Assert.assertTrue(patientWeight.isDisplayed(), "patient gender is not displayed");
//	    		logger.log(LogStatus.INFO, "patient weight is - "+patientWeight.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient weight is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient weight");
	    		throw e;
	    	}
//	    	try{
//	    		Assert.assertTrue(tripInformationNote.isDisplayed(), "patient gender is not displayed");
//	    		logger.log(LogStatus.INFO, "trip information note is - "+tripInformationNote.getText());
//	    	}catch(AssertionError e){
//	    		logger.log(LogStatus.WARNING, "trip information note is not displayed to verfiy");
//	    		throw e;
//	    	}catch(Exception e){
//	    		logger.log(LogStatus.WARNING, "unable to verify trip information note");
//	    		throw e;
//	    	}
//	    	try{
//	    		Assert.assertTrue(patientAlert.isDisplayed(), "patient gender is not displayed");
//	    		logger.log(LogStatus.INFO, "patient alert note is - "+patientAlert.getText());
//	    	}catch(AssertionError e){
//	    		logger.log(LogStatus.WARNING, "patient alert note is not displayed to verfiy");
//	    		throw e;
//	    	}catch(Exception e){
//	    		logger.log(LogStatus.WARNING, "unable to verify patient alert");
//	    		throw e;
//	    	}
    }
    
    
    public void navigateToPickUpTab(){
    	// to verify the patient information 
	    	try{
	    		actionUtility.click(pickUp);
	    		logger.log(LogStatus.INFO, "navigate to pick-up tab");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to navigate to pick-up tab in trip page");
	    		throw e;
	    	}
    }
    
    public void verifyTheGPSimageIsDisplayedInPickUpTab(){
    	// to verify the gps icon in pick up tab 
	    	try{
	    		Assert.assertTrue(gps.isDisplayed(), "gps icon is not displayed in pick-up tab");
	    		logger.log(LogStatus.INFO, "gps icon is displayed in pick-up tab");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "gps icon is displayed in pick-up tab");
	    		throw e;
	    	}
    }
    
    public void clickOnGPSimageInPickUpTab(){
    	// to click on gps icon in pick-up tab
	    	try{
	    		actionUtility.click(gps);
	    		logger.log(LogStatus.INFO, "clicked on gps icon in pick-up tab");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to click on gps icon in pick-up tab");
	    		throw e;
	    	}
    }
    
    public void pickUpLocationAddress(){
	    	try{
	    		Assert.assertTrue(pickUpRun.isDisplayed(), "pick-up number is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up number is - "+pickUpRun.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up number");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(pickUpTripNo.isDisplayed(), "pick-up trip number is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up trip number is - "+pickUpTripNo.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up trip number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up trip number");
	    		throw e;
	    	}
	    	
	    	try{
    		Assert.assertTrue(pickUpLocation.isDisplayed(), "pick-up location is not displayed");
    		logger.log(LogStatus.INFO, "pick-up location is - "+pickUpLocation.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up location is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up location");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(pickUpAddress1.isDisplayed(), "pick-up address1 is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up address - "+pickUpAddress1.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up address1 is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up address1");
	    		throw e;
	    	}
	    	
//	    	try{
//	    		Assert.assertTrue(pickUpAddress2.isDisplayed(), "pick-up address2 is not displayed");
//	    		logger.log(LogStatus.INFO, "pick-up address continue - "+pickUpAddress2.getText());
//	    	}catch(AssertionError e){
//	    		logger.log(LogStatus.WARNING, "pick-up address2 is not displayed to verfiy");
//	    		throw e;
//	    	}catch(Exception e){
//	    		logger.log(LogStatus.WARNING, "unable to verify pick-up address2");
//	    		throw e;
//	    	}
	    	
	    	try{
	    		Assert.assertTrue(pickUpPhoneNumber.isDisplayed(), "pick-up phone number is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up phone number is - "+pickUpPhoneNumber.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up phone number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up phone numer");
	    		throw e;
	    	}							
    }
    
    public void verifyThePickMapIsDisplayed(){
	    	try{
	    		Assert.assertTrue(pickUpMAP.isDisplayed(), "pick up google map is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up google map is displayed");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up google map is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up google map");
	    		throw e;
	    	}
    }
    
    public void clickOnMyLocationIconInGoogleMap(){
	    	try{
	    		actionUtility.click(myLocationIconInGoogleMap);
	    		logger.log(LogStatus.INFO, "tapped on my location icon in google map");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to tap on my location icon in google map");
	    		throw e;
	    	}
    }
    
//    public void clickOnNavigateDirectionInGoogleMap(){
//    	try{
//    		actionUtility.click(navigateDirectionInGoogleMap);
//    		logger.log(LogStatus.INFO, "tapped on navigate direction icon in google map");
//    	}catch(Exception e){
//    		logger.log(LogStatus.WARNING, "unable to tapp on navigate direction icon in google map");
//    		throw e;
//    	}
//    }
    
    public void verifyTheDropOffIsDisplayed(){
	    	try{
	    		Assert.assertTrue(dropOff.isDisplayed(), "drop-off tab is not displayed");
	    		logger.log(LogStatus.INFO, "drop-off tab is displayed");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "drop-off tab is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop-off tab");
	    		throw e;
	    	}
    }
    
    public void navigateToDropOffTab(){
	    	try{
	    		actionUtility.click(dropOff);
	    		logger.log(LogStatus.INFO, "successfully navigate to drop-off tab");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "successfully navigate to drop-off tab to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop off tab ");
	    		throw e;
	    	}
    }
    
    public void verifyTheGPSimageIsDisplayedInDropOffTab(){
    	// to verify the gps icon in pick up tab 
	    	try{
	    		Assert.assertTrue(gpsDropOff.isDisplayed(), "gps icon is not displayed in drop-Off tab");
	    		logger.log(LogStatus.INFO, "gps icon is displayed in drop-off tab");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "gps icon is displayed in drop-off tab");
	    		throw e;
	    	}
    }
    
    public void clickOnGPSimageInDropOffTab(){
    	// to click on gps icon in pick-up tab
	    	try{
	    		actionUtility.click(gpsDropOff);
	    		logger.log(LogStatus.INFO, "clicked on gps icon in drop-off tab");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to click on gps icon in drop-off tab");
	    		throw e;
	    	}
    }
    
    public void dropOffLocationAddress(){
		    	try{
		    		Assert.assertTrue(dropOffRun.isDisplayed(), "drop - Off number is not displayed");
		    		logger.log(LogStatus.INFO, "drop-off number is - "+dropOffRun.getText());
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off number is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off number");
		    		throw e;
		    	}
		    	
		    	try {
		    		Assert.assertTrue(dropOffTripNumber.isDisplayed(), "drop-off trip number is not displayed");
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off trip number is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off trip number");
		    		throw e;
		    	}
	    	
		    	try{
		    		Assert.assertTrue(dropOffLocation.isDisplayed(), "drop-off location is not displayed");
		    		logger.log(LogStatus.INFO, "drop-off location is - "+dropOffLocation.getText());
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off location is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off location");
		    		throw e;
		    	}
		    	
		    	try{
		    		Assert.assertTrue(dropOffAddress1.isDisplayed(), "drop-off address1 is not displayed");
		    		logger.log(LogStatus.INFO, "drop-off address - "+dropOffAddress1.getText());
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off address1 is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off address1");
		    		throw e;
		    	}
		    	
//		    	try{
//		    		Assert.assertTrue(dropOffAddress2.isDisplayed(), "drop-off address2 is not displayed");
//		    		logger.log(LogStatus.INFO, "drop-off address continue - "+dropOffAddress2.getText());
//		    	}catch(AssertionError e){
//		    		logger.log(LogStatus.WARNING, "drop-off address2 is not displayed to verfiy");
//		    		throw e;
//		    	}catch(Exception e){
//		    		logger.log(LogStatus.WARNING, "unable to verify drop-off address2");
//		    		throw e;
//		    	}
		    	
		    	try{
		    		Assert.assertTrue(dropOffPhoneNumber.isDisplayed(), "drop-off phone number is not displayed");
		    		logger.log(LogStatus.INFO, "drop-off phone number is - "+dropOffPhoneNumber.getText());
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off phone number is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off phone numer");
		    		throw e;
		    	}	
	    }
	    
	    public void verifyTheDropOffMapIsDisplayed(){
		    	try{
		    		Assert.assertTrue(dropOffMAP.isDisplayed(), "drop-off google map is not displayed");
		    		logger.log(LogStatus.INFO, "drop-off google map is displayed");
		    	}catch(AssertionError e){
		    		logger.log(LogStatus.WARNING, "drop-off google map is not displayed to verfiy");
		    		throw e;
		    	}catch(Exception e){
		    		logger.log(LogStatus.WARNING, "unable to verify drop-off google map");
		    		throw e;
		    	}
	    }
    
    public void clickOnDropOffMyLocationIconInGoogleMap(){
	    	try{
	    		actionUtility.click(DropOffMyLocationIconInGoogleMap);
	    		logger.log(LogStatus.INFO, "tapped on my location icon in drop-off google map");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to tap on my location icon in drop-off google map");
	    		throw e;
	    	}
    }
    
    
    public void toGetTheInformationOfSelectedTripListAndSelectTrip() throws Exception{
    	//to get the info of selected trip list
    	try{
    		actionUtility.waitForElementVisible(tripListStatusGreenColor, 10);
    		Assert.assertTrue(tripListStatusGreenColor.isDisplayed(), "Green color status in selected trip list is not displayed");
    		logger.log(LogStatus.INFO, "Green color status in selected trip list is displayed in green color");
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "Green color status in selected trip list is not displayed to verfiy");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify Green color status in selected trip list");
    		throw e;
    	}
    	
    	try{
    		Assert.assertTrue(runNumberTripList.isDisplayed(), "run number in trip list is not displayed");
    		logger.log(LogStatus.INFO, "run number in trip list is -  "+runNumberTripList.getText());
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "run number in trip list is not displayed to verfiy");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify run number in trip list");
    		throw e;
    	}
    	
    	try{
    		if(tripNumberTripList.isDisplayed()){
    			Assert.assertTrue(tripNumberTripList.isDisplayed(), "trip number in trip list is not displayed");
        		logger.log(LogStatus.INFO, "trip number in trip list is -  "+tripNumberTripList.getText());
    		}else{
    			logger.log(LogStatus.INFO, "trip number in trip list is not displayed");
    		}
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "trip number in trip list is not displayed to verfiy");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify trip number in trip list");
    		throw e;
    	}
    	
    	try{
    		if(pickUpLocationTripList.isDisplayed()){
    			Assert.assertTrue(pickUpLocationTripList.isDisplayed(), "pick up location in trip list is not displayed");
        		logger.log(LogStatus.INFO, "pick up location in trip list is -  "+pickUpLocationTripList.getText());
    		}else{
    			logger.log(LogStatus.INFO, "pick up location in trip list is not displayed");
    		}
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "pick up location in trip list is not displayed to verfiy");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify pick up location in trip list");
    		throw e;
    	}
    	
    	try{
    			Assert.assertTrue(pickUpTimeTripList.isDisplayed(), "pick up time in trip list is not displayed");
        		logger.log(LogStatus.INFO, "pick up time in trip list is -  "+pickUpTimeTripList.getText());
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "pick up time in trip list is not displayed to verfiy");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify pick up time in trip list");
    		throw e;
    	}
    	
//    	try{
//    		if(statusTripList.isDisplayed()){
//    			Assert.assertTrue(statusTripList.isDisplayed(), "status in selected trip list is not displayed");
//        		logger.log(LogStatus.INFO, "status in selected trip list is -  "+statusTripList.getText());
//        		//actionUtility.click(firstTripList);
//        		//logger.log(LogStatus.INFO,"first trip is selected in trip list");
//    		}else{
//    			logger.log(LogStatus.ERROR, "status in selected trip list is not displayed");
//    		}
//    	}catch(AssertionError e){
//    		logger.log(LogStatus.WARNING, "status in trip list is not displayed to verfiy");
//    		throw e;
//    	}catch(Exception e){
//    		logger.log(LogStatus.WARNING, "unable to verify status in trip list");
//    		throw e;
//    	}
    	
    }
    
    public void clickOnHmabergerMenu(){
    	try{
    			//actionUtility.click(hambergerMenu);
        		logger.log(LogStatus.INFO,"clicked on hamberger menu");
    		
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to click on hamberger menu");
    		throw e;
    	}
    }
    
    public void verifyTheMenuHeaderIsdisplayed(){
    	try{
    			Assert.assertTrue(menu.isDisplayed(), "normal menu is not displayed");
    			logger.log(LogStatus.INFO, "normal menu is displayed, so its a table version");
    	}catch(AssertionError e){
    		logger.log(LogStatus.WARNING, "not able to verfiy menu");
    		throw e;
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify menu");
    		throw e;
    	}
    }


@SuppressWarnings("unused")
	public void selectEnRouteStatusTrip() throws Exception{
    	
    	try{
    		List <MobileElement> list1 = driver.findElements(By.id("View_TripListTableCell"));
    		List <MobileElement> list2 = driver.findElements(By.id("lbl_ListStatus"));
    		logger.log(LogStatus.INFO, "number of trip list displayed is " +list1.size());
    		
    		int n = list1.size();
    		int m = list2.size();
    		System.out.println(n);
    		System.out.println(m);
    		for(int i=0;i<=n;i++)
    		{
        		for(int j=0; j<=list2.size();j++){
        			 
        				 String Expt = "EN ROUTE";
        				 
             			String Act = list2.get(j).getText();
        	                if (Act.equals("EN ROUTE")){
        	                	System.out.println(list2.get(j).getText());
        	                	list2.get(j).click();
        	                	logger.log(LogStatus.INFO, "tapped on trip list ");
        	                	break;
        	                }
        		}
        		break;
    		}
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to click on Assigned button");
    		throw e;	
    	}
    }
    
    @SuppressWarnings("unused")
	public void selectAssignedStatus() throws Exception{
    	try{
    		List <MobileElement> list1 = driver.findElements(By.id("View_TripListTableCell"));
    		List <MobileElement> list2 = driver.findElements(By.id("lbl_ListStatus"));
    		logger.log(LogStatus.INFO, "number of trip list displayed is " +list1.size());
    		
    		int n = list1.size();
    		System.out.println(n);
    		for(int i=0;i<=n;i++)
    		{
        		for(int j=0; j<=list2.size();j++){
        			 
        				 String Expt1 ="ASSIGNED";
        				 String Expt2 ="Cancelled";
        				 String Expt3 ="Complete";
             			String Act = list2.get(j).getText();
//             			if(Expt.equals(Act)){
//             				list1.get(j).click();
//             				logger.log(LogStatus.INFO, "clicked on Assigned status");
//             			}break;
        	                if (Act.equals("ASSIGNED")){
        	                	System.out.println(list2.get(j).getText());
        	                	list2.get(j).click();
        	                	logger.log(LogStatus.INFO, "tapped on trip list ");
        	                	break;
        	                }else if(Act.equals("CANCELLED")){
        	                	System.out.println(list2.get(j).getText());
        	                	list2.get(j).click();
        	                	logger.log(LogStatus.INFO, "tapped on trip list ");
        	                	break;
        	                }else if(Act.equals("COMPLETE")){
        	                	System.out.println(list2.get(j).getText());
        	                	list2.get(j).click();
        	                	logger.log(LogStatus.INFO, "tapped on trip list ");
        	                	break;
        	                }
        		}
        		break;
    		}
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to select the triplist");
    		throw e;
    	}
    }
    
    @SuppressWarnings("unused")
	public void selectCancelledStatus() throws Exception{
    	try{
    		List <MobileElement> list1 = driver.findElements(By.id("View_TripListTableCell"));
    		List <MobileElement> list2 = driver.findElements(By.id("lbl_ListStatus"));
    		logger.log(LogStatus.INFO, "number of trip list displayed is " +list1.size());
    		
    		int n = list1.size();
    		System.out.println(n);
    		for(int i=1;i<=n;i++)
    		{
        		for(int j=1; j<=list2.size();j++){
        			 
        				 String Expt2 ="CANCELLED";
             			String Act = list2.get(j).getText();
        	                if (Act.equals("CANCELLED")){
        	                	System.out.println(list2.get(j).getText());
        	                	list2.get(j).click();
        	                	logger.log(LogStatus.INFO, "tapped on trip list ");
        	                	break;
        	                }
        	                	
        		}
        		break;
    		}
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to select the triplist");
    		throw e;
    	}
    }
    
    public void verifyTheTripDetailsPage() throws Exception{
    	try{
    		 actionUtility.waitForElementVisible(verfiyTripDetailsPage,10);
    		logger.log(LogStatus.INFO, "trip details page displayed successfully");
    		
    	}catch(Exception e){
    		logger.log(LogStatus.WARNING, "unable to verify trip details page ");
    		throw e;
    	}
}
    
    public void verifyTheTripStatusInTripDetailsPage() throws Exception{
	    	try{
	    		 actionUtility.waitForElementVisible(tripStatusTipDetails,10);
	    		logger.log(LogStatus.INFO, "trip status in trip details page displayed successfully");
	    		
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify trip status in trip details page ");
	    		throw e;
	    	}
    }


	public void verfiyTheTripStatusAndRunNumberAndTripIDInTripDetailsPage(){
	    	// to verify the trip status Assigned or cancelled or complete 
	    	try{
	    		Assert.assertTrue(tripStatusTipDetails.isDisplayed(), "trip status in pick-up page trip details");
	    		logger.log(LogStatus.INFO, "trip status - "+tripStatusTipDetails.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip status pick-up number is not displayed to verfiy in trip details");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up number in trip details");
	    		throw e;
	    	}
	}
	
	public void verfiyTripDetailsPageHeaderTripStatusAndRunNumberWithTripInformation(){
    	// to verify the trip status Assigned or cancelled or complete 
	    	try{
	    		Assert.assertEquals(tripDetailsHeaderRunNumber.getText(), run2.getText(), "run number is not matching in trip details header and trip information");
	    		
	    		logger.log(LogStatus.INFO, "run number is matching in trip details header and trip information Expected - "+tripDetailsHeaderRunNumber.getText() +" Actual - " +run2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "run number is not matching in trip details header and trip information Expected - "+tripDetailsHeaderRunNumber.getText() +" Actual - " +run2.getText());
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify header run number with tip info page in trip details");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertEquals(tripDetailsHeaderTripIDNumber.getText(), trip2.getText(), "trip ID is not matching in trip details header and trip information");
	    		logger.log(LogStatus.INFO, "trip ID is matching in trip details header and trip information Expected - "+tripDetailsHeaderTripIDNumber.getText() +" Actual - " +trip2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip ID is not matching in trip details header and trip information Expected - "+tripDetailsHeaderTripIDNumber.getText() +" Actual - " +trip2.getText());
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify header trip ID with tip info page in trip details");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(tripStatusTipDetails.isDisplayed(), "trip status in pick-up page trip details");
	    		logger.log(LogStatus.INFO, "trip status - "+tripStatusTipDetails.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip status pick-up number is not displayed to verfiy in trip details");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up number in trip details");
	    		throw e;
	    	}
    }


public void verifyThePickUpdetailsForAssignedOrCancelledOrCompletedInTripDetails() throws Exception{
    	
        	try{
        		//Assert.assertTrue(pickUpRun.isDisplayed(), "pick-up number is not displayed in trip details");
        		//logger.log(LogStatus.INFO, "pick-up number is - "+pickUpRun.getText());
        	}catch(AssertionError e){
        		logger.log(LogStatus.WARNING, "pick-up number is not displayed to verfiy in trip details");
        		throw e;
        	}catch(Exception e){
        		logger.log(LogStatus.WARNING, "unable to verify pick-up number in trip details");
        		throw e;
        	}
        	
        	try{
        		Assert.assertTrue(pickUpLocation.isDisplayed(), "pick-up location is not displayed in trip details");
        		logger.log(LogStatus.INFO, "pick-up location is - "+pickUpLocation.getText());
        	}catch(AssertionError e){
        		logger.log(LogStatus.WARNING, "pick-up location is not displayed to verfiy in trip details");
        		throw e;
        	}catch(Exception e){
        		logger.log(LogStatus.WARNING, "unable to verify pick-up location in trip details");
        		throw e;
        	}
        	
        	try{
        		Assert.assertTrue(pickUpAddress1.isDisplayed(), "pick-up address1 is not displayed in trip details");
        		logger.log(LogStatus.INFO, "pick-up address - "+pickUpAddress1.getText());
        	}catch(AssertionError e){
        		logger.log(LogStatus.WARNING, "pick-up address1 is not displayed to verfiy in trip details");
        		throw e;
        	}catch(Exception e){
        		logger.log(LogStatus.WARNING, "unable to verify pick-up address1 in trip details");
        		throw e;
        	}
    	
    }
    
    public void verifyTheDropOfFdetailsForAssignedOrCancelledOrCompletedInTripDetails() throws Exception{
    	
	    	try{
	    		Assert.assertTrue(dropOffRun.isDisplayed(), "drop - Off number is not displayed");
	    		logger.log(LogStatus.INFO, "drop-off number is - "+dropOffRun.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "drop-off number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop-off number");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(dropOffLocation.isDisplayed(), "drop-off location is not displayed");
	    		logger.log(LogStatus.INFO, "drop-off location is - "+dropOffLocation.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "drop-off location is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop-off location");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(dropOffAddress1.isDisplayed(), "drop-off address1 is not displayed");
	    		logger.log(LogStatus.INFO, "drop-off address - "+dropOffAddress1.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "drop-off address1 is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop-off address1");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(dropOffPhoneNumber.isDisplayed(), "drop-off phone number is not displayed");
	    		logger.log(LogStatus.INFO, "drop-off phone number is - "+dropOffPhoneNumber.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "drop-off phone number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify drop-off phone numer");
	    		throw e;
	    	}
    }
    
    public void pickUpLocationAddressInTripDetailsPageForAssignedOrCancelledOrCompletedTrips(){
	    	try{
	    		Assert.assertTrue(pickUpRun.isDisplayed(), "pick-up number is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up number is - "+pickUpRun.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up number");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(pickUpLocation.isDisplayed(), "pick-up location is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up location is - "+pickUpLocation.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up location is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up location");
	    		throw e;
	    	}
	    	
	    	try{
	    		Assert.assertTrue(pickUpAddress1.isDisplayed(), "pick-up address1 is not displayed");
	    		logger.log(LogStatus.INFO, "pick-up address - "+pickUpAddress1.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up address1 is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up address1");
	    		throw e;
	    	}
	    	
	    	try{
	    		
	    			Assert.assertTrue(pickUpPhoneNumber.isDisplayed(), "pick-up phone number is not displayed");
	        		logger.log(LogStatus.INFO, "pick-up phone number is - "+pickUpPhoneNumber.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up phone number is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up phone numer");
	    		throw e;
	    	}
    }
    
    public void clickOnBackButtonInTripDetailsPage(){
    	try{
    		
			Assert.assertTrue(backButtonTripDetails.isDisplayed(), "back button in trip details page is not displayed");
			actionUtility.click(backButtonTripDetails);
    		logger.log(LogStatus.INFO, "tapped on back button in trip details page");
		}catch(AssertionError e){
			logger.log(LogStatus.WARNING, "notabel to click on back button in trip details page");
			throw e;
		}catch(Exception e){
			logger.log(LogStatus.WARNING, "unable to click on back button in trip details page");
			throw e;
		}
    }
    
    
    public void verifyThePatientInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage(){
    	// to verify the patient age name gender note and alert
	    	try{
	    		Assert.assertTrue(patientName2.isDisplayed(), "patient name is not displayed");
	    		logger.log(LogStatus.INFO, "patient name is - "+patientName2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient name is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient name");
	    		throw e;
	    	}
//	    	try{
//	    		Assert.assertTrue(patientLocation2.isDisplayed(), "patient location is not displayed");
//	    		logger.log(LogStatus.INFO, "patient location is - "+patientLocation2.getText());
//	    	}catch(AssertionError e){
//	    		logger.log(LogStatus.WARNING, "patient location is not displayed to verfiy");
//	    		throw e;
//	    	}catch(Exception e){
//	    		logger.log(LogStatus.WARNING, "unable to verify patient location");
//	    		throw e;
//	    	}
	    	try{
	    		Assert.assertTrue(patientAge2.isDisplayed(), "patient age is not displayed");
	    		logger.log(LogStatus.INFO, "patient age is - "+patientAge2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient age is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient age");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(patientGender2.isDisplayed(), "patient gender is not displayed");
	    		logger.log(LogStatus.INFO, "patient gender is - "+patientGender2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient age is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient gender");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(patientWeight2.isDisplayed(), "patient gender is not displayed");
	    		logger.log(LogStatus.INFO, "patient weight is - "+patientWeight2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient weight is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient weight");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(patientAlert2.isDisplayed(), "patient gender is not displayed");
	    		logger.log(LogStatus.INFO, "patient alert note is - "+patientAlert2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "patient alert note is not displayed to verfiy");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify patient alert");
	    		throw e;
	    	}
    }
    
    public void verifyTheTransportInformationNameAgeGenderweightANdNoteInTripInfoTripDetailsPage(){
    	// to verify the patient age name gender note and alert
	    	try{
	    		Assert.assertTrue(run2.isDisplayed(), "run number is not displayed");
	    		logger.log(LogStatus.INFO, "run number is - "+run2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "run number is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify run number is in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(trip2.isDisplayed(), "trip 2 is not displayed");
	    		logger.log(LogStatus.INFO, "trip umber is - "+trip2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip number is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify trip number in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(callType2.isDisplayed(), "call type is not displayed");
	    		logger.log(LogStatus.INFO, "call type is - "+callType2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "call type is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify call type in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(dispatch2.isDisplayed(), "dispatch is not displayed");
	    		logger.log(LogStatus.INFO, "dispatch is - "+dispatch2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "dispatch is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify dispatch in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(nature2.isDisplayed(), "nature is not displayed");
	    		logger.log(LogStatus.INFO, "nature is - "+nature2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "nature is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify nature in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(status2.isDisplayed(), "status is not displayed");
	    		logger.log(LogStatus.INFO, "status is - "+status2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip information note is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify trip status in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(company2.isDisplayed(), "company is not displayed");
	    		logger.log(LogStatus.INFO, "company is - "+company2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "company is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify company in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(crew2.isDisplayed(), "crew is not displayed");
	    		logger.log(LogStatus.INFO, "crew is - "+crew2.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "crew is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify crew in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(notes2.isDisplayed(), "notes is not displayed in trip details");
	    		logger.log(LogStatus.INFO, "notes is - "+notes2.getText() +"in trip details");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "notes is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify notes in trip details page");
	    		throw e;
	    	}
	    	try{
	    		Assert.assertTrue(cadComment2.isDisplayed(), "cad comment is not displayed in trip details");
	    		logger.log(LogStatus.INFO, "notes is - "+cadComment2.getText() +"in trip details");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "cad comment is not displayed to verfiy in trip details page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify cad comments in trip details page");
	    		throw e;
	    	}
    }
    
    public void verifyThePickMapIsDisplayedForTripDetails(){
	    	try{
	    		Assert.assertTrue(pickUpMAPTripDetails.isDisplayed(), "pick up google map is not displayed in trip details");
	    		logger.log(LogStatus.INFO, "pick-up google map is displayed in trip details");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "pick-up google map is not displayed to verfiy in trip details");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up google map in trip details");
	    		throw e;
	    	}
    }
    
    public void clickOnSatelliteViewButtonInMap() throws Exception{
	    	try{
	    		actionUtility.click(satelliteVeiwButton);
	    		logger.log(LogStatus.INFO, "tapped on satellite view in map");
	    		Thread.sleep(2000);
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify pick-up google map in trip details");
	    		throw e;
	    	}
    }
    
    public void clickOnForwardNavigationInTripDetailsPage()throws Exception{
	    	try{
	    		Assert.assertTrue(forwardNavigation.isDisplayed(), "forward navigation is not displayed");
	    		actionUtility.click(forwardNavigation);
	    		logger.log(LogStatus.INFO, "successfully clicked on forward arrow");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "forward navigation is not displayed in trip list page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unabel to click onn forward navigation arrow");
	    		throw e;
	    	}
    }
    public void clickOnBackwardNavigationInTripDetailsPage()throws Exception{
	    	try{
	    		Assert.assertTrue(backwardNavigation.isDisplayed(), "back navigation is not displayed");
	    		actionUtility.click(backwardNavigation);
	    		logger.log(LogStatus.INFO, "successfully clicked on back arrow");
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "back navigation is not displayed in trip list page");
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unabel to click onn back navigation arrow");
	    		throw e;
	    	}
    }
    
    
    public void selectTheMapDirectionInAddress() throws Exception{
    	//to select MapDirection
	    	try{
	    		List <MobileElement> list1 = driver.findElements(By.id("mapdirection_Item"));
	    		//List <MobileElement> list2 = driver.findElements(By.id("textview_Status"));
	    		logger.log(LogStatus.INFO, "number of map direction displayed is " +list1.size());
	    		
	    		int n = list1.size();
	    		for(int i=1;i<=n;i++)
	    		{
	        	                if (list1.get(i).isDisplayed()){
	        	                	System.out.println(list1.get(i).getText());
	        	                	list1.get(i).click();
	        	                	logger.log(LogStatus.INFO, "map direction is tapped");
	        	                	break;
	        	                }else{
	        	                	logger.log(LogStatus.WARNING, "Map directions are not displayed");
	        	                }
	    		}
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to ta on map directions");
	    		throw e;
	    	}
    }
    
    public void selectTheMapDirectionInAddressSearchDropOff() throws Exception{
    	//to select MapDirection
	    	try{
	    		List <MobileElement> list1 = driver.findElements(By.id("mapdirection_Item"));
	    		//List <MobileElement> list2 = driver.findElements(By.id("textview_Status"));
	    		logger.log(LogStatus.INFO, "number of map direction displayed is " +list1.size());
	    		
	    		int n = list1.size();
	    		for(int i=1;i<=n;i++)
	    		{
	        	                if (list1.get(i).isDisplayed()){
	        	                	System.out.println(list1.get(i).getText());
	        	                	list1.get(i).click();
	        	                	logger.log(LogStatus.INFO, "map direction is tapped");
	        	                	break;
	        	                }else{
	        	                	logger.log(LogStatus.WARNING, "Map directions are not displayed");
	        	                }
	    		}
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to ta on map directions");
	    		throw e;
	    	}
    }
    
    public void verfiyTheStatusIDInTripDetailsPage(String status){
    	// to verify the trip status Assigned or cancelled or complete 
	    	try{
	    		Assert.assertTrue(tripStatusTipDetails.isDisplayed(), "trip status in trip details");
	    		Assert.assertEquals(tripStatusTipDetails.getText(), status);
	    		
	    		logger.log(LogStatus.INFO, "trip status - "+tripStatusTipDetails.getText());
	    	}catch(AssertionError e){
	    		logger.log(LogStatus.WARNING, "trip status is not matching in trip details  Expected = " +status+"  Actual - "+tripStatusTipDetails.getText());
	    		throw e;
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to verify trip status in trip details");
	    		throw e;
	    	}
    }
    
    public void tripListShouldNotDisplay() throws Exception{
		// to verify the list list table displayed in trip list page
		try{
			if(tripList.isDisplayed()){
				Assert.assertTrue(tripList.isDisplayed(), "trip list header is not displayed");
	    		logger.log(LogStatus.WARNING,"trip list header is displayed trip list page");
			}else{
				logger.log(LogStatus.INFO,"trip list header is not displayed trip list page");
			}
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING,"unable to verfiy the trip list header in trip list page");
	    		throw e;
	    	}
	}
    
    public void navigateToTripInformationTabInTripDetails(){
    	// to verify the patient information 
	    	try{
	    		actionUtility.click(tripInformationTripDetails);
	    		logger.log(LogStatus.INFO, "navigate to tip inforamtion in trip details");
	    	}catch(Exception e){
	    		logger.log(LogStatus.WARNING, "unable to navigate to trip information page in trip details");
	    		throw e;
	    	}
    }

    
}
