package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.NetworkMode;

import org.apache.commons.io.FileUtils;
//import org.apache.xpath.operations.Bool;




import io.appium.java_client.MobileElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtility {
    public static ExtentReports reportLog = null;
    public static String TodaysDate;
    public static String reportLocation;

    public static synchronized void initiateReportLog() {
        // creates the report instance
        ZonedDateTime currentTime = ZonedDateTime.now();
        String formattedTime = currentTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyy_hh_mm_ss"));


        String reportLocation = DataUtility.readConfig("report.location");

//        System.out.println(reportLocation);

        String reportPath ="..execution_reports\\reports";
        if (reportLocation != null){
            reportPath = reportLocation+"\\reports";
        }

        ReportUtility.reportLocation = reportPath+"\\report_for_"+formattedTime;

        String filepath = ReportUtility.reportLocation+"\\flybe_automation_report"+formattedTime+".html";
        Boolean replaceExisting = Boolean.TRUE;
        if (reportLog == null) {
            ReportUtility.reportLog = new ExtentReports(filepath, replaceExisting, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);

            URI configUri = null;
            try {
                configUri = ReportUtility.class.getClassLoader().getResource(DataUtility.readConfig("report.config.name")).toURI();
                ReportUtility.reportLog.loadConfig(configUri.toURL());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            ReportUtility.reportLog.setTestRunnerOutput("Report Utility:initiate report log - report initiated");
        }

        return;
    }

    public static synchronized void flushReprotLog(){
        // writes the test case result to HTML file
        if (ReportUtility.reportLog != null) {
            ReportUtility.reportLog.close();
        }
        return;
    }


    public static synchronized void deleteOldReports(){
        // delete the old reports
        String reportLocation = "src\\reports";
        try {
            FileUtils.forceDelete((new File(reportLocation)));
        } catch (Exception e) {
            System.out.println("--- No Reports folder found,that needs to be deleted ---");
        }
    }
    
    public static String Today_Date() throws Exception {
		try {
			Date cur_dt = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			TodaysDate = dateFormat.format(cur_dt);
			
			//Log.info("Current Date is Collected :" + TodaysDate);
		} catch (Exception e) {
			//Log.error("Current Date is not Collected");
			throw (e);
		}
		return TodaysDate;
	}

    public static String captureScreenShot(MobileElement element, String screenShotName){
    	
    	try{
    		
    		//TakeScreenShot ts = (TakeScreenShot)element;
    		
    	}catch(Exception e){
    		
    		
    		
    	}
		return screenShotName;
    	
    }


}
