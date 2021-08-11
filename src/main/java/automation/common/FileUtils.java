package automation.common;

import java.io.File;

public class FileUtils {
    public static void copyFile(File srcFile, File destFile, boolean b) {
        copyFile(srcFile,destFile,true);
    }
}
