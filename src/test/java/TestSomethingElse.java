import automation.testmanagement.BaseTest;
import automation.testmanagement.Testlogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestSomethingElse extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestSelenium.class);


    @Test
    public void test(){
        Testlogger.info(logger,"test1");
    }
    @Test
    public void test2(){
        Testlogger.info(logger,"test2");
    }
}
