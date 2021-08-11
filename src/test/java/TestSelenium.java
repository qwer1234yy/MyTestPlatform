import automation.testDrivers.DriverProvider;
import automation.testmanagement.Testlogger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import automation.testmanagement.BaseTest;

public class TestSelenium extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestSelenium.class);

    @Autowired
    DriverProvider driverProvider;

    @Test
    public void testSelenium(){
        EventFiringWebDriver driver = driverProvider.initDriverInstance();
        driver.get("https://www.baidu.com");
        By byID_kw = By.id("kw");
        driver.findElement(byID_kw).sendKeys("selenium");
        Testlogger.info(logger,"findElement(byID_kw).sendKeys('selenium')");
        By byID_su = By.id("su");
        driver.findElement(byID_su).click();
        Testlogger.info(logger,"findElement(byID_su).click()");
    }
}
