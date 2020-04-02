package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryUtility implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = Integer.parseInt(DataUtility.readConfig("retry.count"));
    private String testName=null;
    AppiumDriver<MobileElement> driver;


 // Below method returns 'true' if the test method has to be retried else 'false'
//and it takes the 'Result' as parameter of the test method that just ran
    public boolean retry(ITestResult result) {
        System.out.println("From __________RetryUtility_______");
        System.out.println(result.getMethod().getMethodName()+"METHODName%%%%%%");
        System.out.println(Thread.currentThread().getId()+"ID%%%%%%%");
        System.out.println(Thread.currentThread().hashCode()+"HASHCODE%%%%%%%");
        System.out.println(driver +"DRiverFROmEXECUTION listner--%%%%%%%");
        System.out.println("From __________END RetryUtility_______");

        // checks if the retry is to be done based on no. of allready done retries
        if (this.retryCount < this.maxRetryCount) {
            System.out.println("_*retry count*__");
            this.retryCount++;
            System.out.println("_~~~~~~From retry utility count___: "+retryCount+" ~~~~~~~~~_");
            return true;
        }

//        if(this.testName== null){
//            this.testName = result.getMethod().getMethodName();
////            logReport(result);
////            reportTearDown();
//        }
        return false;
    }


//    private void logReport(ITestResult testResult) {
    //kept this methods for future use
//        //log the status of each test and takes the screenShot in case of failure,
//        // call the tearDown process after each test
//
//        if (testResult.getMethod().isTest()) {
//            ZonedDateTime currentTime = ZonedDateTime.now();
//            String formattedTime = currentTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyy_hh_mm_ss"));
//
//            if (testResult.getStatus() == 2) {
////                ActionUtility.takeScreenShot(testResult.getMethod().getMethodName(),formattedTime);
//                TestManager.getReportLogger().log(LogStatus.FAIL, testResult.getName() + "**FAILED***");
//                TestManager.getReportLogger().log(LogStatus.INFO, testResult.getThrowable());
//                TestManager.getReportLogger().log(LogStatus.INFO, "Snapshot below: ", TestManager.getReportLogger().addScreenCapture("screenshots\\" + testResult.getMethod().getMethodName()+"_"+formattedTime+".png"));
//            } else if (testResult.getStatus() == 1) {
//                TestManager.getReportLogger().log(LogStatus.PASS, testResult.getName() + "**PASSED***");
//            } else if (testResult.getStatus() == 3) {
//                TestManager.getReportLogger().log(LogStatus.SKIP, testResult.getName() + "**SKIPPED***");
//            }
//        }
//
//    }


//    private void reportTearDown(){
    //kept this methods for future use
//        if ((TestManager.getReportLogger() != null))  {
//            reportLog.endTest(TestManager.getReportLogger());
//            reportLog.flush();
//            TestManager.tearDownReport();
//
//        }
//    }

}
