package automation.testmanagement;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import automation.common.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestReport {
    private static final Logger logger = LoggerFactory.getLogger(TestReport.class);
    private static String testReportPath = System.getProperty("user.dir") + "/reports/";
    private static String testScreenShotFolder = "screenshots";
    private static String testReportName = "";
    private static ExtentReports extentReports = null;
    private static ExtentTest test;

    public static String getTestReportPath() {
        return testReportPath;
    }

    public static String getTestScreenShotFolder() {
        return testScreenShotFolder;
    }

    public static String getTestReportName() {

        if(testReportName.length() == 0){
            Calendar calendar = Calendar.getInstance();
            String strCurrentTIme = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(calendar.getTime());
            testReportName = testReportPath + strCurrentTIme + ".html";
        }

        return testReportName;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public TestReport() {
    }
    public static ExtentReports getExtentReports(){return extentReports;}

    public static void initReport(){
        Testlogger.info(logger,"Initialize a test report");

        // construct  a ExtentReports class with report name and allow it to replace old extent report
        if(null == extentReports){
            extentReports = new ExtentReports(getTestReportName(),true);
        }
    }

    public static void startTest(String testCaseName){
        test = extentReports.startTest(testCaseName);
    }

    public static void update(){
        if(null != extentReports){
            extentReports.endTest(test);
            extentReports.flush();
        }
    }

    public static void  failureScreenshot(ITestResult result, EventFiringWebDriver driver){
        if(result.getStatus() == 2 && null != driver){
            try{
                String screenFile = captureScreen(driver);
                Testlogger.fail(logger,test.addScreenCapture("screenshots/" + screenFile));
            }catch (Exception v){
                Testlogger.fail(logger,"Capture fialed with exception: " + v.getClass());
            }
        }
    }
    public static String captureScreen(EventFiringWebDriver driver) throws IOException {
        File srcFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(getTestScreenShotName());
        FileUtils.copyFile(srcFile,destFile, true);
        Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a");
        return destFile.getName();
    }

    private static String getTestScreenShotName() {
        String failScreenshotPath = testReportPath + testScreenShotFolder;
        Calendar calendar = Calendar.getInstance();
        String strCurrentTime = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(calendar.getTime());
        return failScreenshotPath + File.separator + strCurrentTime +".png";
    }

    public static void cleanTestResult() {
        File file = new File(testReportPath);
        FileExtractor.deleteFile(file);
    }
}
