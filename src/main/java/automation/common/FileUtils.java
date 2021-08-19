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

    public static void copyFile(File srcFile, File destFile, boolean b) {
        copyFile(srcFile,destFile,true);
    }
    
    public void deleteFiles(String path) throws IOException {

        File f = new File(path);
        if(f.exists()){
            if(f.isDirectory()){
                File[]  fs = f.listFiles();
                for (File file: fs) {
                    if(file.isFile())
                    {
                        file.delete();
                    }else {
                        try {
                            deleteFiles(file.getCanonicalPath());
                        } catch (IOException e) {
                            logger.error(e.getmessage());
                        }
                    }
                }
            }
        }else {
            logger.error("the delete file does not exist");
        }
    }
}
