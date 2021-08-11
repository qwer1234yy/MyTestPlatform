package automation.testmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
    public Listener(){}

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

    }

    public void onTestStart(ITestResult result) {
    Testlogger.info(logger,
            "Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        Testlogger.info(logger,
                "Test Successful: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        Testlogger.fail(logger,
                "Test failed with exception" + result.getThrowable().getClass());
    }

    public void onTestSkipped(ITestResult result) {
        Testlogger.skip(logger,
                "Test skipped: " + result.getThrowable().getClass());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        Testlogger.info(logger,
                "Test context started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        Testlogger.info(logger,
                "Test context finished: " + context.getName());
    }
}
