package com.com.thread;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

//模拟多线程下载图片
public class TestThread extends Thread {

    private String url;
    private String name;

    public TestThread(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        DownloadTest downloadTest = new DownloadTest();
        downloadTest.downloader(url,name);
        System.out.println("下载图片名称："+name);
    }

    //主线程
    public static void main(String[] args) {
        //子线程
        TestThread t1 = new TestThread("https://pics4.baidu.com/feed/6c224f4a20a4462307304e9f6ac52f060ef3d741.jpeg?token=35273112da772e2d6f6164f385aeb07d", "1.jpeg");
        TestThread t2 = new TestThread("https://pics3.baidu.com/feed/203fb80e7bec54e7abb7b9f349dfc6584dc26af0.jpeg?token=c6fab2b93a123117c712d5b275d4e56a", "2.jpeg");
        TestThread t3 = new TestThread("https://pics5.baidu.com/feed/d62a6059252dd42ab7946e61ffdc06bdcbeab84f.jpeg?token=73b2d744d2d60b8977266da9af09ab95", "3.jpeg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class DownloadTest {

    //下载方法
    public void downloader(String url,String name) {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("文件下载失败");
        }

    }

}
