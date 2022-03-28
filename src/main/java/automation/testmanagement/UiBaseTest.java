package automation.testmanagement;



import automation.SpringBootApp;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import automation.testDrivers.DriverProvider;

import java.lang.reflect.Method;

public class UiBaseTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(UiBaseTest.class);
    private ExtentTest test;
    
    public EventFiringWebDriver driver;
    @Autowired
    public DriverProvider driverProvider;

    @BeforeClass
    public void beforeTestClass(){
        driver = driverProvider.initDriverInstance();
        logger.info("[BeforeClass] ......");
    }

    @AfterClass
    public void afterClass(){
        logger.info("afterClass: driver.close ");
    }
}
