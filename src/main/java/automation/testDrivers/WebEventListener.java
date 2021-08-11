package automation.testDrivers;

import automation.testmanagement.Testlogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebEventListener implements WebDriverEventListener {

    private static final Logger logger = LoggerFactory.getLogger(DriverProvider.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        Testlogger.info(logger,"beforeAlertAccept");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        Testlogger.info(logger,"afterAlertAccept");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        Testlogger.info(logger,"afterAlertDismiss");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        Testlogger.info(logger,"beforeAlertDismiss");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        Testlogger.info(logger,"beforeNavigateTo");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        Testlogger.info(logger,"afterNavigateTo");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        Testlogger.info(logger,"beforeNavigateBack");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        Testlogger.info(logger,"afterNavigateBack");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        Testlogger.info(logger,"beforeNavigateForward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        Testlogger.info(logger,"afterNavigateForward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        Testlogger.info(logger,"beforeNavigateRefresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        Testlogger.info(logger,"afterNavigateRefresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Testlogger.info(logger,"beforeFindBy");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Testlogger.info(logger,"afterFindBy");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Testlogger.info(logger,"beforeClickOn");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        Testlogger.info(logger,"afterClickOn");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Testlogger.info(logger,"beforeChangeValueOf");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Testlogger.info(logger,"afterChangeValueOf");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        Testlogger.info(logger,"beforeScript");
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        Testlogger.info(logger,"afterScript");
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        Testlogger.info(logger,"beforeSwitchToWindow");
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        Testlogger.info(logger,"afterSwitchToWindow");
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        Testlogger.info(logger,"onException");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        Testlogger.info(logger,"beforeGetScreenshotAs");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        Testlogger.info(logger,"afterGetScreenshotAs");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        Testlogger.info(logger,"beforeGetText");
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        Testlogger.info(logger,"afterGetText");
    }
}
