package automation.testmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ResultCheck {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    private ResultCheck(){logger.info("Private constructor of ResultCheck");}

    public static void assertTrue(boolean actual){

        String msg = messagePackage("Assert-True",String.valueOf(actual),"true");

        try {
            Assert.assertTrue(actual);
            Testlogger.info(logger,msg);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    private static String messagePackage(String assertType, String actual, String expect){
        StringBuilder message = new StringBuilder(assertType);
        message.append(" Actual: ");
        message.append(actual);
        message.append(", Expect: ");
        message.append(expect);
        return message.toString();
    }
}
