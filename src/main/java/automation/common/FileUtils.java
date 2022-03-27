package automation.common;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;
import java.util.Map;

public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    XSSFWorkbook workbookl;

    public static void copyFile(File srcFile, File destFile, boolean b) throws IOException {
        org.apache.commons.io.FileUtils.copyFile(srcFile,destFile,true);
    }
}