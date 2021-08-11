package automation.testmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileExtractor {

    private static final Logger logger = LoggerFactory.getLogger(FileExtractor.class);
    private static String OS_NAME_PROPERTY = "os.name";
    private static String WINDOWS_PLATFORM = "win";
    private static String EXE_FILE = ".exe";

    public static void deleteFile(String fileName) {
        if(null != fileName){
            File file = new File(fileName);
            if (file.exists()){
                file.delete();
            }
        }
    }

    public static void deleteFile(File file) {
        if(file.isFile()){
            file.delete();
        }else {
            File[] files = file.listFiles();
            File[] fs = files;
            int length = files.length;

            for (int i =0; i < length;i++){
                File f = fs[i];
                deleteFile(f);
            }
        }
    }

    public static void deleteTestNGFiles() {
        File currentDir = new File(System.getProperty("user.dir"));
        File[] files = currentDir.listFiles();

        for(int i=0;i<files.length;i++){
            if(files[i].isFile() && files[i].getName().contains("TestNG_")  && files[i].getName().contains(".xml")){
                logger.info("Delete TestNG file: " + files[i].getName());
                files[i].delete();

            }
        }
    }

    public static void exactFile(URL srcURL, String dst) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try{
            if(System.getProperty(OS_NAME_PROPERTY).toLowerCase().indexOf(WINDOWS_PLATFORM) >= 0){
                File file = new File(dst);
                if(srcURL.toString().contains(EXE_FILE)){
                    file.setExecutable(true);
                }
            }else{
                Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rwxr--r--");
                FileAttribute<?> permission = PosixFilePermissions.asFileAttribute(ownerWritable);
                Files.createFile(Paths.get(dst),permission);
             }

            inputStream = srcURL.openStream();
            outputStream = new FileOutputStream(dst);
            byte[] buffer = new byte[4096];

            for(int bytesRead = inputStream.read(buffer);bytesRead !=-1;bytesRead = inputStream.read(buffer)){
                outputStream.write(buffer,0,bytesRead);
            }

        }catch (Exception e){
            logger.error("Fail to extract FIle with exception " + e.getMessage());
        }finally {
            try{
            if(null != outputStream){
                outputStream.close();
            }

            if(null != inputStream){
                inputStream.close();
            }}catch (IOException ioe){
                logger.error("Fail to close while extracting files");
            }
        }
    }
}
