package automation.testmanagement;

import com.relevantcodes.extentreports.LogStatus;
import org.slf4j.Logger;

public class Testlogger {
    public Testlogger() {
    }
    public static void info(Logger logger, String info){

        if(TestReport.getTest() != null){
            TestReport.getTest().log(LogStatus.INFO,info);
        }
        if(logger !=null){
            logger.info(info);
        }

    }

    public static void warn(Logger logger, String warn){
        logger.warn(warn);
    }

    public static void error(Logger logger, String error){
        logger.error(error);
    }

    public static void fail(Logger logger, String fail){
        logger.info(fail);
    }

    public static void fatal(Logger logger, String info){
        logger.error(info);
    }

    public static void skip(Logger logger, String skip) {
        logger.info(skip);
    }
}
