package automation.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
    public static boolean httpDownload(String key,String httpUrl, String saveFile) throws IOException {
        // 1.下载网络文件
        int byteRead;
        URL url;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return false;
        }

        try {
            //2.获取链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
//            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");
            conn.setRequestProperty("Host","180.163.221.140");
            conn.setRequestProperty("User-Agent","Post_Multipart");
            conn.setRequestProperty("Accept","*/*");
            conn.setRequestProperty("Connection","Keep-Alive");
            conn.setRequestProperty("Pragma","no-cache");
            conn.setRequestProperty("X-360-Cloud-Security-Desc","Scan Suspicious File");
            conn.setRequestProperty("x-360-ver","4");
            conn.setRequestProperty("Content-Length","738");
            conn.setRequestProperty("Content-Type","multipart/form-data; boundary=----------------------------f5a89e7e7271");

            //3.输入流
            InputStream inStream = conn.getInputStream();
            //4.写入文件
            FileOutputStream fs = new FileOutputStream(saveFile);

            byte[] buffer = new byte[1024 * 1000];
            while ((byteRead = inStream.read(buffer)) != -1) {
                System.out.println("writing file: " + key);
                fs.write(buffer, 0, byteRead);
            }
            inStream.close();
            fs.close();
            System.out.println("finished");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
