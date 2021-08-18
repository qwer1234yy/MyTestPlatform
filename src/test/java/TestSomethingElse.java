import automation.common.ExcelReader;
import automation.testmanagement.BaseTest;
import automation.testmanagement.Testlogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestSomethingElse extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestSelenium.class);


    @Test
    public void test(){
        Testlogger.info(logger,"test11");
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
