package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;


import java.util.regex.Pattern;


public class CommonUtility {
	public AppiumDriver<MobileElement> driver;
	
	public void setDriver(AppiumDriver<MobileElement> driver){
		this.driver = driver;
	
 
	}
	
	public static int convertStringToInteger(String value){
        // will convertStringToDouble
        try {
            return getIntergerValueFromString(value);
        }catch (NumberFormatException e){
            return 0;
        }catch (NullPointerException e) {
            return 0;
        }
    }
//	public int converStirng(String value){
//		try{
//			return Integer.parseInt(getIntergerValueFromString(value));
//		}catch(NumberFormatException e){
//			return 0;
//		}catch(NullPointerException e){
//			return 0;
//		}
//	}
	private static int getIntergerValueFromString(String Value){
		Pattern regex = Pattern.compile("\\d+");
        Matcher matcher = regex.matcher(Value);
        String val = null;
        while (matcher.find()){
        	val = matcher.group(0);
        }
//		String uniqueIDConfirmPage = driver.findElement(By.id(UniqueIDInConfirmationPage)).getText();
//		int uniqueID = Integer.parseInt(uniqueIDConfirmPage.replace("\\D", ""));
//		System.out.println(uniqueID);
        int intValue = Integer.parseInt(val);
		return intValue;
		
	}
	
	public static String getJobDate(Date dateparam){
		String changedDateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(dateparam);
		return changedDateformat;
	}
	public String getDeliveryJobDate(Date dateparam){
		String changeDeliveryDate = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss.000Z").format(dateparam);
		return changeDeliveryDate;
	}
	
	public static void main(String[] args) {
		Date d = new Date();
		String date = getJobDate(d);
		System.out.println(date);
		
	}

}
