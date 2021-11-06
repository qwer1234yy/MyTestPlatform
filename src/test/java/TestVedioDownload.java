import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class TestVedioDownload {

    public static void main(String[] args) throws IOException {
//      英语二强化班
        String courseId_YingYuQiangHuaBan = "2675129";
        String folder_YingYuQiangHuaBan = "英语二强化班\\";
        Map<String,String> mp4Ulr_YingYuQiangHuaBan = new HashMap();
        mp4Ulr_YingYuQiangHuaBan.put("强化阅读第10讲","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/ecc2ba773701925920151152319/kTb47eISfaoA.mp4");

        Map<String,Map<String, String>>  courses = readFileCourseUrls();

        for (String course:courses.keySet()
             ) {
            Map<String, String> courseUrls= courses.get(course);

            httpDownloadByCourseID(course,courseUrls,courseId_YingYuQiangHuaBan);

        }
    }

    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        conn.setRequestProperty("Accept-Encoding","identity;q=1, *;q=0");
        conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
        conn.setRequestProperty("Connection","keep-alive");
        conn.setRequestProperty("Cookie","pc.guoweiedu.com|token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8va3BhcGlvcC5ja2pyMDAxLmNvbS9hcGkvbXAvYXV0aENhbGxiYWNrIiwiaWF0IjoxNjMxMjM5MDIwLCJleHAiOjE2MzM4MzEwMjAsIm5iZiI6MTYzMTIzOTAyMCwianRpIjoiNmZsYmNnYU5ldTVSV2ZaUCIsInN1YiI6bnVsbCwiYyI6ImEyNzYiLCJ1IjoicTYyNW84ZyIsImEiOjEsInAiOm51bGwsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEiLCJzeXMiOiJtaWNybyIsImF1aSI6MTAwMjV9.dIpr5aCtgGNiHrKnm7csa7BEAvSgYdCQk1E4xwq2h0k; pc.guoweiedu.com|companyId=a276; pc.guoweiedu.com|userId=q625o8g; pc.guoweiedu.com|userName=li; pc.guoweiedu.com|userHeadImg=http%3A%2F%2Fthirdwx.qlogo.cn%2Fmmopen%2F3iaIJibIFnu9856M4IH9j17xNK7s4DNlrLdLDb6oZx4tyAXPLBMhp0AEzeXzNK2V6fvV6M6CEh1MwkjJ3axr6hbdtCBdBpHBm0%2F132; pc.guoweiedu.com|vipType=4; pc.guoweiedu.com|uMobile=");

        conn.setRequestProperty("Host","pc.guoweiedu.com");
        conn.setRequestProperty("Range","bytes=0-");
        conn.setRequestProperty("Referer","http://pc.guoweiedu.com/course/coursePlays.html?courseId=2706680");
        conn.setRequestProperty("If-Modified-Since","Mon, 23 Aug 2021 20:27:24 GMT");
        conn.setRequestProperty("Upgrade-Insecure-Requests","1");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");



        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success");

    }



    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
    public static void  httpDownloadByCourseID(String courseFolder, Map<String, String> sourceVideoUrl, String courseId){
        String baseFolder = "D:\\study\\2022届管理类联考精品班课程\\" + courseFolder+"\\";
        sourceVideoUrl.forEach((key, value) -> {
            try {
                System.out.println(key);
                httpDownload(key,value,baseFolder + key + ".mp4",courseId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public static boolean httpDownload(String key,String httpUrl, String saveFile, String courseId) throws IOException {
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

            URLConnection conn = url.openConnection();
//            conn.setRequestProperty("Accept","*/*");
            conn.setRequestProperty("Accept-Encoding","identity;q=1, *;q=0");
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
            conn.setRequestProperty("Connection","keep-alive");
//            conn.setRequestProperty("Cookie","pc.guoweiedu.com|token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8va3BhcGlvcC5ja2pyMDAxLmNvbS9hcGkvbXAvYXV0aENhbGxiYWNrIiwiaWF0IjoxNjMxMjM5MDIwLCJleHAiOjE2MzM4MzEwMjAsIm5iZiI6MTYzMTIzOTAyMCwianRpIjoiNmZsYmNnYU5ldTVSV2ZaUCIsInN1YiI6bnVsbCwiYyI6ImEyNzYiLCJ1IjoicTYyNW84ZyIsImEiOjEsInAiOm51bGwsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEiLCJzeXMiOiJtaWNybyIsImF1aSI6MTAwMjV9.dIpr5aCtgGNiHrKnm7csa7BEAvSgYdCQk1E4xwq2h0k; pc.guoweiedu.com|companyId=a276; pc.guoweiedu.com|userId=q625o8g; pc.guoweiedu.com|userName=li; pc.guoweiedu.com|userHeadImg=http%3A%2F%2Fthirdwx.qlogo.cn%2Fmmopen%2F3iaIJibIFnu9856M4IH9j17xNK7s4DNlrLdLDb6oZx4tyAXPLBMhp0AEzeXzNK2V6fvV6M6CEh1MwkjJ3axr6hbdtCBdBpHBm0%2F132; pc.guoweiedu.com|vipType=4; pc.guoweiedu.com|uMobile=");

//            conn.setRequestProperty("Host","1252433846.vod2.myqcloud.com");
            conn.setRequestProperty("Range","bytes=0-");
//            conn.setRequestProperty("If-Range","Tue, 08 Jun 2021 16:38:29 GMT");
//            conn.setRequestProperty("Referer","http://pc.guoweiedu.com/course/coursePlays.html?courseId=" + courseId);
//            conn.setRequestProperty("If-Modified-Since","Mon, 23 Aug 2021 20:27:24 GMT");
//            conn.setRequestProperty("Upgrade-Insecure-Requests","1");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");



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

    public static Map<String,Map<String, String>> readFileCourseUrls() throws IOException {
        Map<String,Map<String, String>> classUrl = new HashMap<>();

//        String[] courseFile = {"2021年逻辑基础全程通关班","2022年中文写作零基础全程通关班",
//                "2022年数学零基础全程通关班","2022年英语二零基础全程通关班","2022年逻辑零基础全程通关班"};
        String[] courseFile = {"2022年逻辑零基础全程通关班"};
        String base = "src/test/resources/hongli/";
        for (String course:courseFile) {
            try {
                File file=new File(base + course+".txt");
                Map<String, String> courseUrl = new HashMap<>();
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file));//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        courseUrl.put(lineTxt.split(",")[0],lineTxt.split(",")[1]);
                    }
                    classUrl.put(course,courseUrl);
                    read.close();
                }else{
                    System.out.println("找不到指定的文件");
                }
            } catch (Exception e) {
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            }
        }
        return classUrl;
    }
}
