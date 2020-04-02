package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.NetworkMode;

import org.apache.commons.io.FileUtils;
//import org.apache.xpath.operations.Bool;






import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class ActionUtility {
    // Defining of Basic selenium actions
	public AppiumDriver<MobileElement> driver;
	public static String TodaysDate;
//	 public ActionUtility(AppiumDriver<MobileElement> driver) {
//		 this.driver = driver;
//	 }


//	private IOSClient iosClient;

    public void setDriver(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }

    public AppiumDriver<MobileElement> getAndroidDriver(){
        return driver;
    }
//	 public WebElement driver(By by) {
//		return driver.findElement(by);
//	 }

    public void click (MobileElement element){
        // wait for element and click
        try{
            waitForElementClickable(element,15);
            element.click();
        }catch (TimeoutException e){
            Reporter.log("Element not visible to click",3);
            throw e;
        }
    }


    public boolean click(By by){
   	  try{
   		  driver.findElement(by).click();
   		  return true;
   	  }catch(NoSuchElementException e){
   		  Reporter.log("Element not visible to click",3);
   		  return false;
   	  }
     }
	 public void waitForVisible(By by, int waitTime) {
   	  WebDriverWait wait = new WebDriverWait(driver, waitTime);
   	    for (int attempt = 0; attempt < waitTime; attempt++) {
   	        try {
   	            driver.findElement(by);
   	            break;
   	        } catch (Exception e) {
   	            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
   	        }
   	    }
//   	    wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
   	
     }
	 public boolean isElementPresent(By by) {
		 try {
				driver.findElement(by);
				return true;
		 } catch (NoSuchElementException e) {
				return false;
		 }
	 }
    
	public void waitForElementClickable(By by, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));

	}
	public void waitForElementClick(MobileElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

//	public void scrollDirection(String Id, SwipeElementDirection arg) {
//		MobileElement e = (MobileElement) driver.findElementById(Id);
//		e.swipe(arg, 1000);
//	}
    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementToDisAppear(By by, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }


//    public void swipeRightUntilLogOutScreen() {
//        do {
//            swipeRight();
//        } while (!isElementPresent(By.id("org.wordpress.android:id/me_login_logout_text_view"), 12));
//    }
//
//    public void swipeLeftUntilTextExists(String expected) {
//        do {
//            swipeLeft();
//        } while (!driver.getPageSource().contains(expected));
//    }

//    public void swipeRight() {
//        Dimension size = driver.manage().window().getSize();
//        int startx = (int) (size.width * 0.9);
//        int endx = (int) (size.width * 0.20);
//        int starty = size.height / 2;
//        driver.swipe(startx, starty, endx, starty, 5000);
//    }
//
//    public void swipeLeft() {
//        Dimension size = driver.manage().window().getSize();
//        int startx = (int) (size.width * 0.8);
//        int endx = (int) (size.width * 0.20);
//        int starty = size.height / 2;
//        driver.swipe(startx, starty, endx, starty, 1000);
//    }
//
//    public void scrollDirection(MobileElement Id, SwipeElementDirection arg) {
//        MobileElement e = Id;
//        e.swipe(arg, 1000);
//    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        //logger.info("Current context" + driver.getContext());
    }

    public void clickBackButton() {
        driver.navigate().back(); //Closes keyboard
        //driver.navigate().back(); //Comes out of edit mode
    }


    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void logStepIntoExtentReport(String elementDescription, String action,String typeString) {
        //ExtentTestManager.getTest().log(Status.INFO,elementDescription + "; " + withBoldHTML("Text") + ": " + typeString);
    }

    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty()) {
            return "<b>" + string + "</b>";
        } else {
            return "";
        }
    }

//    public String getPageObjectElemetDescription(Object pageObject, String fieldName) {
//        try {
//            return this.getClass().getAnnotation(PageName.class).value() + "::" +
//                pageObject.getClass().getField(fieldName).getAnnotation(ElementDescription.class)
//                    .value();
//        } catch (NoSuchFieldException e) {
//
//            e.printStackTrace();
//        }
//        return "";
//    }

    public enum SelectionType {
        //Selection types used to select the value in the dropdown
        SELECTBYTEXT,
        SELECTBYVALUE,
        SELECTBYINDEX
    }

    public enum FrameLocator {
        //Locator types used to find the webelements
        NAMEORID,
        INDEX,
        WEBELEMENT
    }

//    private void setReportLocation(String timeStamp){
//        if (reportLocation!=null){
//            reportLocation = DataUtility.readConfig("report.location")+"\\screenShort" + timeStamp;
//        }
//    }

//    public static void takeScreenShot(String methodName, String timeStamp) throws Exception {
//
//        // captures the screen shot
//
//
////
//        try {
//            EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(TestManager.getDriver());
//          File scrFile = eventFiringWebDriver.getScreenshotAs(OutputType.FILE);
////            File scrFile = ((TakesScreenshot)TestManager.getDriver()).getScreenshotAs(OutputType.FILE);
//        //below steps will save the screen shot in specified path with test method name
//
//
//
//            FileUtils.copyFile(scrFile, new File(reportLocation+"\\"+"screenshots\\"+methodName+"_"+timeStamp+".png"));
//            System.out.println("***Placed screen shot in "+reportLocation+"\\ screenshots\\ ***");
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw e;
//
//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//
//        }
//    }
    public boolean isElementPresent(By by, int waitTime) {
  		try {
  			driver.findElement(by);
  			return true;
  		} catch (NoSuchElementException e) {
  			return false;
  		}
      }
    
    public boolean isClickable(By by){
    	try{
     		  driver.findElement(by).isEnabled();
     		  return true;
     	  }catch(NoSuchElementException e){
     		  Reporter.log("Element not visible to click",3);
     		  return false;
     	  }
    }
    
//    public void clickElement(WebElement el) {
//    	try {
//    		if(Base.platformName.equalsIgnoreCase(ConstantName.ANDROID))
//    	((JavascriptExecutor) Base.base.getDriver()).executeScript("window.scrollTo(0," +el.getLocation().x+ ")");
//    		TouchActions ta = new TouchActions(Base.base.getDriver());
//    		ta.singleTap(el).perform();
//    	} catch (WebDriverException ex) {
//    		throw ex;
//    	}
//    }

//    public void sendKeysByAction(WebElement element, String keysToEnter){
//        // send key by actions
//        try {
//            waitForElementVisible(element, 10);
//            action.sendKeys(keysToEnter).build().perform();
//        }catch (TimeoutException e){
//            Reporter.log("Element not visible",3);
//            throw e;
//        }catch (StaleElementReferenceException ex){
//            Reporter.log("Element not present on page");
//            throw ex;
//        }
//    }

    
    public void waitForPageLoad(int time){
        //will verify the DOM with java script
        //try{
//            TestManager.getDriver().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
            //WebDriverWait wait = new WebDriverWait(driver,time);

//            //wait.until( new Predicate<WebDriver>() {
//                            public boolean apply(WebDriver driver) {
//                                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//                            }
//                        }
//            );}catch (Exception e){}


    }

    public void waitForPageTitle(String pageTitle,int timeFactor){
        // Wait for the page to have the respective title
        try{
            WebDriverWait wait = new WebDriverWait(driver,timeFactor);
            //wait.until(ExpectedConditions.titleContains(pageTitle));
        }catch (TimeoutException e){
            Reporter.log("page title does not match");
            throw e;
        }
    }

    public void waitForPageURL(String pageURL,int timeFactor){
        // Wait for the page to have the respective title
        try{
            WebDriverWait wait = new WebDriverWait(driver,timeFactor);
            //wait.until(ExpectedConditions.urlContains(pageURL));
        }catch (TimeoutException e){
            Reporter.log("page URL does not match");
            throw e;
        }
    }

    public void waitForInvisibility(MobileElement element, int maxSeconds) {
        Long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && element.isDisplayed()) {}
        } catch (StaleElementReferenceException e) {
            return;
        }
    }
    public void waitForElementVisible(MobileElement element, int time) throws InterruptedException{
        // wait till the element is visible
        boolean flag = true;
        int attempt =0;
        try {

            while (flag && attempt < 3) {
                try {
                   
                	WebDriverWait wait = new WebDriverWait(driver, time);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    flag = false;
                }catch (StaleElementReferenceException e){}

                attempt++;
            }
        }catch (TimeoutException e){
            Reporter.log("Element not visible",3);
            throw e;
        }

    }

    public void waitForElementClickable( MobileElement element,int time){
        // wait till the element is clickable
        try{

            WebDriverWait wait = new WebDriverWait(driver,time);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
            Reporter.log("Element not clickable",3);
            throw e;
        }

    }

    public void waitForElementNotPresent(String locator,int time){
        // wait till the element is invisible
        try {
            WebDriverWait wait = new WebDriverWait(driver,time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        }catch (TimeoutException e){
            Reporter.log("Element is still visible",3);
            throw e;
        }
    }


    public boolean isAlertPresent(){
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            //wait.until(ExpectedConditions.alertIsPresent());
            flag = true;
        }catch (TimeoutException e){}
        return flag;

    }

    public boolean checkAlertAndPerform(String alertAction) {
        // wait till the alert is available and switches the to it
        if (isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            if (alertAction.toLowerCase().equals("accept")){
                alert.accept();
            }else if (alertAction.toLowerCase().equals("dismiss")){
                alert.dismiss();
            }
            return true;
        }else {
            return false;
        }
    }

    
    public void hardSleep(int timeInMillsec){
        // will suspend the thread for specified amount of time
        try {
            Thread.sleep(timeInMillsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dropdownSelect(MobileElement element, SelectionType selectedMethod, String valueToSelect) {
        // select the value in the dropdown
        Select select = new Select(element);
        switch (selectedMethod) {
            case SELECTBYTEXT:
                select.selectByVisibleText(valueToSelect);
                break;
            case SELECTBYVALUE:
                select.selectByValue(valueToSelect);
                break;
            case SELECTBYINDEX:
                int index = Integer.parseInt(valueToSelect);
                select.selectByIndex(index);
                break;
        }
    }

    public String getValueSelectedInDropdown(MobileElement element) {
        // select the value in the dropdown
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();

    }

    public void selectOption(MobileElement element) {
        //select the checkbox and radio button with 5 attempts
        try {
            waitForElementClickable(element,20);
            int attempt = 0;
            while ((!element.isSelected()) && attempt < 5) {
//                click(element);
                attempt++;
            }
            if(!element.isSelected() && (attempt >=5)){
                throw new RuntimeException("Unable to select the element");
            }
        }catch (TimeoutException e){
            Reporter.log("Element not visible to select",3);
            throw e;
        }catch (RuntimeException e){
            Reporter.log("Unable to select the element",3);
            throw  e;
        }
    }

//    public void hardSelectOption(WebElement element) {
//        //select the checkbox and radio button with 5 attempts using java script
//        try {
//            waitForElementClickable(element,20);
//            int attempt = 0;
//            boolean flag = false;
//            while ((!element.isSelected()) && attempt < 5) {
//                hardClick(element);
//                attempt++;
//            }
//            if(!element.isSelected() && (attempt >=5)){
//                throw new RuntimeException("Unable to select the element");
//            }
//
//        }catch (TimeoutException e){
//            Reporter.log("Element not visible to select",3);
//            throw e;
//        }catch (RuntimeException e){
//            Reporter.log("Unable to select the element",3);
//            throw  e;
//        }
//
//
//
//    }



//    public void clickByAction(WebElement element){
//        // wait for element and click it by actions
//        try {
//            waitForElementClickable(element, 20);
//            action.moveToElement(element).click(element).build().perform();
//        }catch (TimeoutException e){
//            Reporter.log("Element not visible",1);
//            throw e;
//        }
//    }

    public void  mouseHoverAndClick(MobileElement element, MobileElement elementTobeClicked){
        //mouse hover by actions and click
//        waitForElementClickable(element,10);
//        action.moveToElement(element).build1().perform();
//        click(elementTobeClicked,10);
        hardClick(elementTobeClicked);

    }

    public void hardClick (MobileElement element){
        // javascript to click on the element
        try {
            waitForElementClickable(element,20);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }catch (TimeoutException e){
            Reporter.log("Element not visisble to click",3);
            throw e;
        }
    }

    public void unSelectOption(MobileElement element) throws Exception {
        //unselect the checkbox and radio button with 5 attempts
        try {
            waitForElementClickable(element,20);
            int attempt = 0;
            while ((element.isSelected()) && attempt < 5) {
                element.click();
                attempt++;
            }
            if (element.isSelected() && (attempt >= 5)) {
                throw new RuntimeException("Unable to Unselect the element");
            }
        }catch (TimeoutException e){
            Reporter.log("Element not visible to unselect",3);
            throw e;
        }catch (Exception e){
            Reporter.log("Unable to Unselect the element");
            throw  e;
        }

    }

    private String  calculateDate(int dateOffset, String format) {
        // will calculate the date as per the offset
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.add(Calendar.DATE, dateOffset);

        Date calculatedDate = now.getTime();

        String frmtdDate = dateFormatter.format(calculatedDate);

        return frmtdDate;
    }

    public String[] getDate(int dateOffset){
        // will return the calculated date as string array
        String frmtdDate = calculateDate(dateOffset, "d/MMM/yyyy");
        return frmtdDate.split("/");

    }

    public String getDateAsString(int dateOffset,String format){
        // will return the calculated date as string
        String frmtdDate = calculateDate(dateOffset,format);
        return frmtdDate;
    }

    public int getRandomNumber(){
        // return the random number
        Random rand = new Random(System.currentTimeMillis());
        int random=rand.nextInt();
        return random;
    }

    

    public boolean verifyIfElementIsDisplayed(MobileElement element) throws InterruptedException{
        //checks whether element is present in the web page
        boolean flag=false;
        try{
            waitForElementVisible(element,25);
            int attempt =0;

            while(attempt<3 && !flag){
                try {
                    flag = element.isDisplayed();
                }catch (StaleElementReferenceException e){}
            }

        }catch(NoSuchElementException e){
            //If the element is not present in the DOM then it will come here
        }catch (TimeoutException e){}
        return flag;
    }
    
    public boolean verifyIfElementVisibility(MobileElement element) throws InterruptedException{
        //checks whether element is present in the web page
        boolean flag=false;
        try{
            waitForElementVisible(element,30);
            int attempt =0;

            while(attempt<3 && !flag){
                try {
                    flag = element.isDisplayed();
                }catch (StaleElementReferenceException e){}
            }

        }catch(NoSuchElementException e){
            //If the element is not present in the DOM then it will come here
        }catch (TimeoutException e){}
        return flag;
    }
    
    
    public String Today_Date() throws Exception {
		try {
//			Date cur_dt = new Date();
//			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//			TodaysDate = dateFormat.format(cur_dt);
//			
//			Log.info("Current Date is Collected :" + TodaysDate);
		} catch (Exception e) {
//			Log.error("Current Date is not Collected");
			throw (e);
		}
		return TodaysDate;
	}

    
    public void sendKeys(MobileElement element,String keysToEnter) throws Exception{
    	try{
    		waitForElementVisible(element, 50);
    		element.clear();
    		element.sendKeys(keysToEnter);
    	}catch(Exception e){
    		throw e;
    	}
    }
    public void clickAt(MobileElement element){
        // wait for element and click
        try{
            waitForElementClick(element,15);
            element.click();
        }catch (TimeoutException e){
            Reporter.log("Element not visible to click",3);
            throw e;
        }
    }
    
    
    public void selectAutoSuggestionDisplayBottom(MobileElement elementID, String textToEnter) throws Exception {

//        String elementNameEnterText = "Enter Text In: " + elementName;

        try {
              elementID.sendKeys(textToEnter);
              int x = elementID.getLocation().getX();
              int y = elementID.getLocation().getY();
              System.out.println("X value: " + x + " Y value: " + y);
              Thread.sleep(2000);
              TouchAction action = new TouchAction(driver).tap(x + 60, y + 130).release();
              action.perform();
        } catch (Exception e) {
        		throw e;
        }

  }



  public void selectAutoSuggestionDisplayTop(MobileElement elementID, String textToEnter) throws Exception {

//        String elementNameEnterText = "Enter Text In: " + elementName;

        try {
              elementID.sendKeys(textToEnter);
              int x = elementID.getLocation().getX();
              int y = elementID.getLocation().getY();
              System.out.println("X value: " + x + " Y value: " + y);
              Thread.sleep(2000);
              TouchAction action = new TouchAction(driver).tap(x + 60, y - 130).release();
              action.perform();
        } catch (Exception e) {
        		throw e;
        }

  }

	
    
}

