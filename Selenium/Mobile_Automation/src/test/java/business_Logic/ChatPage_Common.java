package business_Logic;

import com.relevantcodes.extentreports.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
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
public class ChatPage_Common {

    private static AppiumDriver<MobileElement> driver;
    private static ActionUtility actionUtility = new ActionUtility();
    Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports report ;
    public static ExtentTest logger;

  //*********TripList page***********
//  @FindBy(id = "main_contentFrame")
//  private MobileElement tripListMainFrame;
  @FindBy(id = "switchDnd")
  private MobileElement dnd;
  @FindBy(id ="btnDnD")
  private MobileElement dntStatus;
  @FindBy(id = "Mobile_Chat_PPT_Icon.png")
  private MobileElement chatIconTripList;
  @FindBy(id = "lbl_Trips")
  private MobileElement ChatPageTitle;
  @FindBy(id = "Chat_Selected.png")
  private MobileElement chatIconChatHome;
  @FindBy(id = "New Chat")
  private MobileElement newChatTitleHeaderActual;
  @FindBy(id = "view_TokenInputView")
  private MobileElement contactToTextbox;
  @FindBy(id = "txt_typeMessage")
  private MobileElement typeMessage;
  @FindBy(id = "btn_AddContacts")
  private MobileElement plus;
  @FindBy(id = "btn_sendMessage")
  private MobileElement sendMessageButton;
  @FindBy(id = "CellSingleChat")
  private MobileElement singleChatINChatHomeScreen;
  @FindBy(xpath = "")
  private MobileElement incomingMessage;
  @FindBy(id = "lbl_participants")
  private MobileElement firstNameLastName;
  @FindBy(id = "lblContactGroups")
  private MobileElement groups;
  @FindBy(name = "lbl_ContactName")
  private MobileElement selectTripNumberInGroup;
 
  @FindBy(id = "btn_sendMessage")
  private MobileElement pastePinButton;
  @FindBy(name = "LblTimestamp")
  private MobileElement messageTimeInChatHomeScreen;
  @FindBy(name = "lblMessage")
  private MobileElement chatCountInChatHomeScreen;
  @FindBy(id = "lbl_cancel")
  private MobileElement cancel;
  @FindBy(id = "lblGroupName")
  private MobileElement groupChatHeader;
  @FindBy(id = "Header Info")
  private MobileElement iSymbol;
  @FindBy(id = "")
  private MobileElement iSymbolGroupChatHeader; 
  @FindBy(name = "LblName")
  private MobileElement senderName;
  @FindBy(name = "LblTimestamp")
  private MobileElement timeIncomingMessage;
  @FindBy(id = "btn_Back")
  private MobileElement backButton;
  
  
  //****Search contact
  @FindBy(name = "lbl_ContactName")
  private MobileElement searchContact;
    

    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        ChatPage_Common.driver = driver;
        actionUtility.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void setLog(ExtentTest logger){

        ChatPage_Common.logger = logger;
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
    
    
    public void clickOnChatIconInTripList(){
        try{
              actionUtility.click(chatIconTripList);
              logger.log(LogStatus.INFO,"successfully tapped on chat icon in trip list page");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tap in chat icon in trip list page");
              throw e;
        }
     }
    
     public void verifyTheChatScreenIsDisplayed(){
        String chatPageTitle = "lblChat/ppt";
        try{
              Assert.assertEquals(ChatPageTitle.getText(), chatPageTitle, "chat screen is not displayed");
              logger.log(LogStatus.INFO,"chat screen is not displayed");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify chat screen");
              throw e;
        }
     }
    
     public void clickOnChatIconInChatHomePage(){
       
        try{
              actionUtility.click(chatIconChatHome);
              logger.log(LogStatus.INFO,"tapped on chat icon in chat home screen");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tap on chat icon in chat home screen");
              throw e;
        }
     }
       
     public void verifyNewChatScreenIsDisplayed(){
        String newChatTitleHeaderExpected = "New Chat";
        try{
              driver.hideKeyboard();
              Assert.assertEquals(newChatTitleHeaderActual.getText(), newChatTitleHeaderExpected, "new chat screen is not displayed");
              logger.log(LogStatus.INFO,"New chat screen is displayed after tapping on chat icon in chat home screen");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify New chat screen after tapping on chat icon in chat home screen");
              throw e;
        }
     }
    
     
     public void enterTheSingleContactNameInNewChatScreen()throws Exception{
         try{
             MobileElement element = driver.findElement(By.id("flexbox"));
             actionUtility.click(contactToTextbox);
             actionUtility.sendKeys(contactToTextbox, "Joe");
             int x = element.getLocation().getX();
             int y = element.getLocation().getY();
             //List<MobileElement> element =  driver.findElements(By.id(""));
             System.out.println("X value: "+x+" Y value: "+y);
             TouchAction action = new TouchAction(driver).tap(x, y);
             action.perform();
            
//             System.out.println("X value: "+x+" Y value: "+y);
//             TouchAction action = new TouchAction(driver).tap(x+60, y+260).release();
//             action.perform();
            
             
             
             //actionUtility.sendKeys(contactToTextbox, p.getProperty("newContactTo"));
             logger.log(LogStatus.INFO, "contact name entered in new chat "+p.getProperty("newContactTo"));
             driver.hideKeyboard();
         }catch (AssertionError e){
             logger.log(LogStatus.WARNING, "not able to enter the contact name in new chat");
             throw e;
         }
     }
    
     
     public void clickOnPlusIconInNewChat(){
    	 try {
    		 //actionUtility.click(By.xpath("/XCUIElementTypeButton[@name='btn_AddContacts']"));
    		 driver.findElement(By.id("btn_AddContacts")).click();
    		 logger.log(LogStatus.INFO,"successfully tapped on plus icon in  new chat");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on plus icon in new chat");
              throw e;
        }
     }
    
     public void selectContactInNewChatSearch(){
        driver.hideKeyboard();
        try{
              actionUtility.click(searchContact);
              logger.log(LogStatus.INFO,"successfully selected the contact ");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to select the contact in search new chat");
              throw e;
        }
     }
    
     public void enterMessage() throws Exception{
        try{
             
              actionUtility.click(typeMessage);
              try {
                 fis = new FileInputStream("DataSource/Chat.Properties");
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
             p.load(fis);
             Thread.sleep(50);
             actionUtility.sendKeys(typeMessage, p.getProperty("typeMessage"));
              logger.log(LogStatus.INFO,"successfully enterd the message as  : " +p.getProperty("typeMessage"));
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to enter the message in text area");
              throw e;
        }
     }
    
     public void messageSendButtonInNewChatSearch(){
        try{
        		driver.findElement(By.id("btn_sendMessage")).click();
              //actionUtility.click(sendMessageButton);
              logger.log(LogStatus.INFO,"successfully tapped on send button in new chat screen ");
              //driver.hideKeyboard();
              //driver.navigate().back();
              clickOnBackButton();
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on end button in new chat screen");
              throw e;
        }
     }
    
     public void messageSingleChatInChatHomeScreen(){
       
               try{
                     List <MobileElement> list1 = driver.findElements(By.id("CellSingleChat"));
                     logger.log(LogStatus.INFO, "chat count in chat home screen " +list1.size());
                     int n = list1.size();
                     System.out.println(n);
                     for(int i=0;i<=n;i++){
                            if (list1.get(i).isDisplayed()){
                            System.out.println(list1.get(i).getText());
                            list1.get(i).click();
                            logger.log(LogStatus.INFO, "selected the chat incoming meesage");
                            break;
                        }else{
                            logger.log(LogStatus.WARNING, "no new message in chat home screen");
                        }
                     }
               }catch(Exception e){
                     logger.log(LogStatus.WARNING, "unable to select the new message in chat home screen");
                     throw e;
               }
               driver.hideKeyboard();
       
//     try{
//            actionUtility.click(singleChatINChatHomeScreen);
//            logger.log(LogStatus.INFO,"successfully tapped on send button in new chat screen ");
//            driver.hideKeyboard();
//     }catch(Exception e){
//            logger.log(LogStatus.WARNING,"unable to tapp on end button in new chat screen");
//            throw e;
//     }
     }
    
     public void messageSecondChatInChatHomeScreen(){
       
        try{
              List <MobileElement> list1 = driver.findElements(By.id("chatlistSingleItem"));
              logger.log(LogStatus.INFO, "chat count in chat home screen " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=1;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "selected the chat incoming meesage");
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "no new message in chat home screen");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to select the new message in chat home screen");
              throw e;
        }
        driver.hideKeyboard();
       
//      try{
//            actionUtility.click(singleChatINChatHomeScreen);
//            logger.log(LogStatus.INFO,"successfully tapped on send button in new chat screen ");
//            driver.hideKeyboard();
//      }catch(Exception e){
//            logger.log(LogStatus.WARNING,"unable to tapp on end button in new chat screen");
//            throw e;
//      }
 }
    
     public void verifyTheIncomingMessage(){
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("textView"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=1;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     logger.log(LogStatus.INFO, "Incoming message is - " +list1.get(i).getText());
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "replied message is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to verify the replied message");
              throw e;
        }
     }
    
     public void clickOnGroups(){
        try{
        		driver.findElement(By.id("lblContactGroups")).click();
              //actionUtility.click(groups);
              logger.log(LogStatus.INFO, "tapped on groups");
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to tapp on groups");
              throw e;
        }
     }
    
     public void selectTheTripInGroups(){
        try{
              //driver.hideKeyboard();
              //actionUtility.click(selectTripNumberInGroup);
              driver.findElement(By.id("lbl_ContactName")).click();
              logger.log(LogStatus.INFO,"successfully selected trip for group chat : " +selectTripNumberInGroup.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on end button in new chat screen");
              throw e;
        }
     }
    
     public void verifyingTheUserNameFirstAndLastName(){
        try{
              Assert.assertTrue(firstNameLastName.isDisplayed(), "first name and last name is not displayed");
              logger.log(LogStatus.INFO,"successfully verified the first name and last name is : "+firstNameLastName.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on end button in new chat screen");
              throw e;
        }
       
     }
    
     public void clickOnDNDbuttonInChatPage(){
        try{
              actionUtility.click(dnd);
              logger.log(LogStatus.INFO,"successfully tapped on DND in chat page");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on DND button in chat screen");
              throw e;
        }
     }
       
     public void verifyDNDStatusInHeaderInChatPage(){
        try{
              Assert.assertTrue(dntStatus.isDisplayed(), "dnd status is not displayed in header");
              logger.log(LogStatus.INFO,"successfully verified DND status in chat header");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify DND status in chat header");
              throw e;
        }
     }
    
     public void selectAnotherContactInNewChatSearch(){
        driver.hideKeyboard();
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("lbl_ContactName"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=1;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "successfully selected another user ");
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "another user is not is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to select another user in new chat search");
              throw e;
        }
     }
    
     public void messagePastePinButtonInNewChatSearch(){
        try{
              actionUtility.click(pastePinButton);
              logger.log(LogStatus.INFO,"successfully tapped on send/PastePin button");
              //driver.hideKeyboard();
              //driver.navigate().back();
              clickOnBackButton();
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on send/PastePin button");
              throw e;
        }
     }
    
     public void verifyTimeForIncomingMessageInChatHomeScreen(){
        try{
              Assert.assertTrue(messageTimeInChatHomeScreen.isDisplayed(), "time cannot be read for incoming message in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified time for incoming message in chat home screen : " +messageTimeInChatHomeScreen.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify time for incoming message in chat home screen");
              throw e;
        }
     }
    
     public void verifySelectedContactIsDisplayedInNewChatToTextbox(){
        //driver.hideKeyboard();
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("chip_text"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=0;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "successfully selected another user ");
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "another user is not is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to select another user in new chat search");
              throw e;
        }
     }
    
     public void verifySelectedAnotherContactIsDisplayedInNewChatToTextbox(){
        actionUtility.click(typeMessage);
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("chip_text"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=1;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "successfully selected another user ");
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "another user is not is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to select another user in new chat search");
              throw e;
        }
     }
    
     public void verifyChatCountInChatHomeScreen(){
        try{
              Assert.assertTrue(chatCountInChatHomeScreen.isDisplayed(), "chat count is not displayed in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified chat count in chat home screen : " +chatCountInChatHomeScreen.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify chat count in chat home screen");
              throw e;
        }
     }
    
     public void tappOnCancel(){
        try{
              actionUtility.click(cancel);
              logger.log(LogStatus.INFO,"successfully tapped on cancel in new chat screen");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on cancel in new chat screen");
              throw e;
        }
     }
    
     public void verifyTheGroupChatIncomingMessageInChatHomeScreen() throws Exception{
        try{
              Assert.assertTrue(groupChatHeader.isDisplayed(), "Group chat incoming message is not displayed in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified Group chat incoming message in chat home screen : " +groupChatHeader.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to Group chat incoming message in chat home screen");
              throw e;
        }
       
        try{
              Assert.assertTrue(iSymbolGroupChatHeader.isDisplayed(), "Group chat incoming message i symbol is not displayed in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified i sysmbol Group chat incoming message header in chat home screen");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify i symbol in Group chat header incoming message in chat home screen");
              throw e;
        }
       
        try{
              Assert.assertTrue(senderName.isDisplayed(), "Group chat incoming message sender name is not displayed in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified sender name Group chat incoming message in chat home screen  :" +senderName.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify sender name in Group chat incoming message in chat home screen");
              throw e;
        }
       
        try{
              Assert.assertTrue(timeIncomingMessage.isDisplayed(), "Group chat incoming message time is not displayed in chat home screen");
              logger.log(LogStatus.INFO,"successfully verified Group chat incoming message time in chat home screen  :" +timeIncomingMessage.getText());
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to verify Group chat incoming message time in chat home screen");
              throw e;
        }
       
     }
    
     public void clickOnISymbolInGroupChatHeader(){
        try{
              actionUtility.click(iSymbol);
              logger.log(LogStatus.INFO,"successfully tapped on i sysmbol Group chat incoming message header in chat home screen");
        }catch(Exception e){
              logger.log(LogStatus.WARNING,"unable to tapp on i symbol in Group chat header incoming message in chat home screen");
              throw e;
        }
       
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("txt_username"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=0;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "successfully verified the details page first user is : " +list1.get(i).getText());
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "first user is not is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to verfiy first user in details");
              throw e;
        }
       
        try{
             
              List <MobileElement> list1 = driver.findElements(By.id("txt_username"));
              //logger.log(LogStatus.INFO, "Message recieved is " +list1.size());
              int n = list1.size();
              System.out.println(n);
              for(int i=1;i<=n;i++){
                     if (list1.get(i).isDisplayed()){
                     System.out.println(list1.get(i).getText());
                     list1.get(i).click();
                     logger.log(LogStatus.INFO, "successfully verified the details page second user is : " +list1.get(i).getText());
                     break;
                 }else{
                     logger.log(LogStatus.WARNING, "second user is not is not displayed");
                 }
              }
        }catch(Exception e){
              logger.log(LogStatus.WARNING, "unable to verfiy second user in details");
              throw e;
        }
        driver.navigate().back();
        
     }
    

     public void clickOnBackButton() {
    	 
    	 try {
    		 actionUtility.click(backButton);
    	 }catch(Exception e) {
    		 logger.log(LogStatus.WARNING, "unable to click on back button");
    		 throw e;
    	 }
     }
    
}
