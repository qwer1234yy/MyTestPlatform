import automation.common.ExcelReader;
import automation.testmanagement.BaseTest;
import automation.testmanagement.Testlogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestSomethingElse {
    private static final Logger logger = LoggerFactory.getLogger(TestSelenium.class);


    @Test
    public void test(){
        String[] asf= {"",""};
        System.out.println(PrimeSum.sm(20));
    }
    @Test
    public void test4(){
        System.out.println(PrimeSum.sm(20));
    }
    @Test
    public void test3(){
        Assert.fail();
        System.out.println(PrimeSum.sm(20));
    }
    public static boolean isPrimeNum(int num) {

        if (num < 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                return false;
            }

        }

        return true;
    }
    @Test
    public void test2(){
        Testlogger.info(logger,"test2");
    }

    @Test
    public void testReadExcel() throws IOException {
        String path = "test_data/test_data.xlsx";
        String sheetName = "test";
        ExcelReader reader = new ExcelReader(path);
        List<Map<String,String>> data = reader.getDataWithHeader(sheetName);
    }
}
