import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class TestVedioDownload {

    public static void main(String[] args) throws IOException {

//        中午写作强化
//        Map<String,String> mp4Ulr_ZhongWenXieZuo = new HashMap();
//        String courseId = "2558324";
//        String folder = "中文写作强化班\\";
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第1课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/92ee3bed3701925919049168923/hghA0pfyUKgA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第2课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/953f8e923701925919049261979/riiOpUuWCf4A.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第3课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/92ee3c0c3701925919049168931/IBhorfMtJCsA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第4课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/953f8eac3701925919049261982/kf1U6TQow9EA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第5课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/c2f5529d3701925921038303826/x5zmX2AQbAIA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第6课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/c121fdc23701925921038279027/pJXD3XTqV7QA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第7课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/d374a4083701925920979271433/EPYGnI8VNnoA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第8课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/c2f552e13701925921038303848/bJozF9wsvTQA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第9课","http://1252433846.vod2.myqcloud.com/e0f98685vodgzp1252433846/c0c66b3c3701925921038227082/Nr598XnFU74A.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第10课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/e3f03fd83701925920979997524/B0fhaOAcbm8A.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第11课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/697383c53701925923237419049/wyityL28QoUA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第12课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/697383de3701925923237419051/ZAlHN44r2zcA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第13课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/697383df3701925923237419052/6aKTLxSD19gA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第14课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/697383e03701925923237419053/emAJf9AMK7wA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第15课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/697383e43701925923237419057/zZqXMaxKiAEA.mp4");
//        mp4Ulr_ZhongWenXieZuo.put("中午写作强化第16课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/28af00ea3701925923236990690/wJ72o08e528A.mp4");
//        httpDownloadByCourseID(folder,mp4Ulr_ZhongWenXieZuo,courseId);

        String courseId = "2558324";
        String folder = "中文写作基础班\\";
        Map<String,String> mp4Ulr_ZhongWenXieZuoJiChu = new HashMap();
        mp4Ulr_ZhongWenXieZuoJiChu.put("中午写作基础第1课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/446e3f085285890814372077421/CFtnTxNzTCgA.mp4");
        mp4Ulr_ZhongWenXieZuoJiChu.put("中午写作基础第2课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/446e3f095285890814372077422/SLwU6moAGy0A.mp4");
        mp4Ulr_ZhongWenXieZuoJiChu.put("中午写作基础第3课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/446e3f0a5285890814372077423/CiEE3hDtodEA.mp4");
        mp4Ulr_ZhongWenXieZuoJiChu.put("中午写作基础第4课","http://1252433846.vod2.myqcloud.com/4fec7368vodcq1252433846/38fe356a5285890814375621830/NkZvECsaBDcA.mp4");
        httpDownloadByCourseID(folder,mp4Ulr_ZhongWenXieZuoJiChu,courseId);



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
        String baseFolder = "D:\\study\\" + courseFolder;
        sourceVideoUrl.forEach((key, value) -> {
            try {
                httpDownload(value,baseFolder + key + ".mp4",courseId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public static boolean httpDownload(String httpUrl, String saveFile, String courseId) throws IOException {
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
            conn.setRequestProperty("Referer","http://pc.guoweiedu.com/course/coursePlays.html?courseId=" + courseId);
//            conn.setRequestProperty("If-Modified-Since","Mon, 23 Aug 2021 20:27:24 GMT");
//            conn.setRequestProperty("Upgrade-Insecure-Requests","1");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");



            //3.输入流
            InputStream inStream = conn.getInputStream();
            //4.写入文件
            FileOutputStream fs = new FileOutputStream(saveFile);

            byte[] buffer = new byte[1024 * 1000];
            while ((byteRead = inStream.read(buffer)) != -1) {
                System.out.println("writing file");
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
