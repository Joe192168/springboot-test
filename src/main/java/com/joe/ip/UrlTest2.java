package com.joe.ip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest2 {
    public static void main(String[] args) throws IOException {
        //下载地址
        URL url = new URL("https://ss.csdn.net/p?https://mmbiz.qpic.cn/mmbiz_gif/wtxb0ibmp702ve5RvHicvIYI0kPe0wt1g2nibT38PQm6KBdXKJrqtiaynxWe0hnUay7jyXZQWHUiaD2uGyKryDjw8YA/640?wx_fmt=gif");
        //连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("tss.gif");
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //释放资源
        urlConnection.disconnect();//断开连接
        is.close();
        fos.close();
    }
}
