package automation.testmanagement;



import automation.SpringBootApp;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import automation.testDrivers.DriverProvider;

import java.lang.reflect.Method;

@SpringBootTest(
        classes = {SpringBootApp.class}
)
public class BaseTest extends AbstractTestNGSpringContextTests {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private ExtentTest test;
    
    public EventFiringWebDriver driver;
    @Autowired
    public DriverProvider driverProvider;
    @Value("${environment.name}")
    private String environmentName;

    //construct a baseTest class with TestReport
    public BaseTest() {
        TestReport.initReport();
    }

    public void initTestSuite(){
        logger.info("[BefoereSuite] ......");
        TestReport.cleanTestResult();
    }

    public void cleanTestSuite(String envName){
        logger.info("[AfterSuite] ......");
        FileExtractor.deleteTestNGFiles();
    }

    public void beforeTestClass(){
        driver = driverProvider.initDriverInstance();
        logger.info("[BeforeClass] ......");
    }

    public void cleanTestClass(){
        logger.info("[AfterClass] ......");
//        BaseDatabase.close();
//        BaseSftp.exit();
//        DriverProvider.clearDriverInstance();
    }

    public void initTestMethod(Method method){
        Testlogger.info(logger,"[BeforeMethod] ......");
        TestReport.startTest(this.getClass().getCanonicalName()+"." + method.getName());
        this.test = TestReport.getTest();
    }

    public void cleantestMethod(ITestResult result){
        logger.info("[AfterMethod] ......");
        TestReport.failureScreenshot(result, DriverProvider.getDriver());
        TestReport.update();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){this.initTestSuite();}

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){this.cleanTestSuite(this.environmentName);}

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
        super.springTestContextPrepareTestInstance();
        this.beforeTestClass();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
        super.springTestContextAfterTestClass();
        this.cleanTestClass();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws Exception {
        super.springTestContextBeforeTestMethod(method);
        this.initTestMethod(method);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result, Method method) throws Exception {
        super.springTestContextAfterTestMethod(method);
        this.cleantestMethod(result);
    }

//    public ExtentTest getTest(){return this.test;}
//
//    @BeforeClass(alwaysRun = true)
//    @Override
//    protected void springTestContextBeforeTestClass() throws Exception {
//        super.springTestContextBeforeTestClass();
//    }
//
//    @BeforeClass(alwaysRun = true, dependsOnMethods = {"springTestContextBeforeTestClass"})
//    @Override
//    protected void springTestContextPrepareTestInstance() throws Exception {
//        super.springTestContextPrepareTestInstance();
//    }
//
//    @BeforeMethod(alwaysRun = true)
//    @Override
//    protected void springTestContextBeforeTestMethod(Method testMethod) throws Exception {
//        super.springTestContextBeforeTestMethod(testMethod);
//    }
//
//    @Override
//    public void run(IHookCallBack callBack, ITestResult testResult) {
//        super.run(callBack, testResult);
//    }
//
//    @AfterMethod(alwaysRun = true)
//    @Override
//    protected void springTestContextAfterTestMethod(Method testMethod) throws Exception {
//        super.springTestContextAfterTestMethod(testMethod);
//    }
//
//    @AfterClass(alwaysRun = true)
//    @Override
//    protected void springTestContextAfterTestClass() throws Exception {
//        super.springTestContextAfterTestClass();
//    }
}
