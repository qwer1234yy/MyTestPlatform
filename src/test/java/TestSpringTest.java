import org.testng.Assert;
import org.testng.annotations.Test;
import automation.testmanagement.BaseTest;
import automation.testmanagement.ResultCheck;

public class TestSpringTest extends BaseTest {
    @Test
    public void test(){
        System.out.println("test test");
        Assert.assertEquals(32323,32323);
        ResultCheck.assertTrue(true);
    }
}
