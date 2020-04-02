package test_definition;

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

public class Chat extends BasePageRegression{

	
    
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1450_VerifyOnClickingChatIconInTripListPageChatScreenIsDisplayed() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1253_VerifyThePageWhenIClickOnSendMessageButtonMessageShouldBeSentToIndividualContact() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1249_VerifyTheDeliveryStatusDisplayForSentMessage() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1247_VerifyPageShouldHaveTextboxSoUserCanTypeNewMessage() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.enterMessage();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1246_VerifyPageShouldHaveTextboxSoUserCanTypeNewMessage() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        //chatPage.clickOnGroups();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1245_VerifyUsershouldBeAbleToPickNewContactFromContactPageAndStartNewMessageThread() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnGroups();
        chatPage.selectTheTripInGroups();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1244_VerifyUIElement() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        //chatPage.clickOnGroups();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1239_VerifyDNDTtoggleButtonInFooterMenuOptions () throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1238_VerifyFooterMenuOptionsWithDNDIconIsAbleToSelect () throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1226_VerifyNewMessagePushPreviousToTopInChatScreen() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1225_VerifyLastMessageShownInBottomInChatScreen() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1224_VerifyUserRoleDetailsInHeader() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
       welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSingleChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1222_VerifyUserShouldBeAbleToSeeAllTheMessagesAlongWithTimeStamp() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.verifyTimeForIncomingMessageInChatHomeScreen();
    }
 
    @Test(groups ={"smoke","p1"})
    public void NMA_1215_VerifyListsAreGroupedByPersonalCategoryAndCanExpandedOrCollapsedByTappingArrows() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1211_VerifyContactDetailsForEachContacts() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1209_VerifyListOfAllContactsDisplayedWithUserGroupWhenUserType2CharOfFirstAndLastName() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        //chatPage.verifySelectedContactIsDisplayedInNewChatToTextbox();
        //chatPage.verifySelectedAnotherContactIsDisplayedInNewChatToTextbox();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1204_VerifyMessageCountUpdatedToReflectReadMessages() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
        chatPage.verifyChatCountInChatHomeScreen();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1200_VerifyDNDEnableForInChatHomePage () throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1199_VerifyPageWillShowOnlyLatestMessageFromParticularContactWhenThereAreMoreThanOneMessageReceivedFromHim() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
        chatPage.verifyChatCountInChatHomeScreen();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1198_VerifyPreviewOfAllUnreadNewMessagesFromMultipleContacts() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
        chatPage.verifyChatCountInChatHomeScreen();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyChatCountInChatHomeScreen();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1197_VerifyCickingChatIconOnMenuUserShouldComeToTheChatHomePage() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1196_VerifyUIElement() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        chatPage.enterMessage();
       chatPage.messageSendButtonInNewChatSearch();
        chatPage.messageSecondChatInChatHomeScreen();
        chatPage.verifyTheIncomingMessage();
        chatPage.verifyingTheUserNameFirstAndLastName();
        chatPage.enterMessage();
        chatPage.messagePastePinButtonInNewChatSearch();
        chatPage.verifyChatCountInChatHomeScreen();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyDNDStatusInHeaderInChatPage();
        chatPage.clickOnDNDbuttonInChatPage();
        chatPage.verifyChatCountInChatHomeScreen();
    }
   
    /*
     * Sprint 8
     */
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1578_VerifyPlusButtonDisappearsOnAddingContactFromSearch() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1573_VerifyGroupsCanBeSearchedAndAddedTolist() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        //chatPage.verifySelectedContactIsDisplayedInNewChatToTextbox();
        //chatPage.verifySelectedAnotherContactIsDisplayedInNewChatToTextbox();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1572_VerifyGroupsPrePopulatedANdCursorIsInSearchFiled() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1571_VerifyThatPlusButtonAppearsWhenUserInNewGroup() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnGroups();
        chatPage.selectTheTripInGroups();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1569_VerifyTAddingMultipleContactsBuPerformingSearch() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        //chatPage.verifySelectedContactIsDisplayedInNewChatToTextbox();
        //chatPage.verifySelectedAnotherContactIsDisplayedInNewChatToTextbox();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1568_VerifyKeypadClosesOnTappingMinimizingTheApp() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1567_VerifyContactScreenClosesOnTappingBackButton() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        driver.navigate().back();
    }
    
    @Test(groups ={"smoke","p1"})
    public void NMA_1566_VerifyContactScreenClosesOnTappingCancel() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.tappOnCancel();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1565_VerifyContactCanBeSelectedFromFilteredList() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1563_VerifyContactSearchScreenDisplayedOnTappingPlusButton() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1562_VerifyPlusButtonAppearsInNewChatTextField() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1554_VerifyGroupChatViewScreenForDispatcherCreatedTripListGroup() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        //chatPage.verifySelectedContactIsDisplayedInNewChatToTextbox();
        //chatPage.verifySelectedAnotherContactIsDisplayedInNewChatToTextbox();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.verifyTheGroupChatIncomingMessageInChatHomeScreen();
        chatPage.clickOnISymbolInGroupChatHeader();
    }
   
    @Test(groups ={"smoke","p1"})
    public void NMA_1553_VerifyGroupChatViewScreenForUserCreatedGroup() throws Exception{
       loginPage.enterUserNameAndPasswordInLoginInPage();
        loginPage.clickOnLoginButton();
        welcomePage.enterTheValueForCompanyName();welcomePage.enterTheVehicle();
        //welcomePage.enterTheUnit();
        //welcomePage.enterTheFirstCrew();
        welcomePage.clickOnNextButtonInWelcomePage();
        tripList.verifyTripListHeader();
        tripList.VerifyActiveTripHeader();
        chatPage.clickOnChatIconInTripList();
        chatPage.verifyTheChatScreenIsDisplayed();
        chatPage.clickOnChatIconInChatHomePage();
        chatPage.verifyNewChatScreenIsDisplayed();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectContactInNewChatSearch();
        chatPage.clickOnPlusIconInNewChat();
        chatPage.selectAnotherContactInNewChatSearch();
        //chatPage.verifySelectedContactIsDisplayedInNewChatToTextbox();
        //chatPage.verifySelectedAnotherContactIsDisplayedInNewChatToTextbox();
        chatPage.enterMessage();
        chatPage.messageSendButtonInNewChatSearch();
        chatPage.verifyTheGroupChatIncomingMessageInChatHomeScreen();
        chatPage.clickOnISymbolInGroupChatHeader();
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
