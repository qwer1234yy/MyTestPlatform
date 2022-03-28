package automation.testmanagement;

import automation.SpringBootApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(
        classes = {SpringBootApp.class}
)
public class BaseTest  extends AbstractTestNGSpringContextTests {
}
