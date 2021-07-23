package com.Callable;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        DownloadTest downloadTest = new DownloadTest();
        downloadTest.downloader(url,name);
        System.out.println("下载图片名称："+name);
        return true;
    }

    //主线程
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //子线程
        TestCallable t1 = new TestCallable("https://pics4.baidu.com/feed/6c224f4a20a4462307304e9f6ac52f060ef3d741.jpeg?token=35273112da772e2d6f6164f385aeb07d", "1.jpeg");
        TestCallable t2 = new TestCallable("https://pics3.baidu.com/feed/203fb80e7bec54e7abb7b9f349dfc6584dc26af0.jpeg?token=c6fab2b93a123117c712d5b275d4e56a", "2.jpeg");
        TestCallable t3 = new TestCallable("https://pics5.baidu.com/feed/d62a6059252dd42ab7946e61ffdc06bdcbeab84f.jpeg?token=73b2d744d2d60b8977266da9af09ab95", "3.jpeg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> f1 = ser.submit(t1);
        Future<Boolean> f2 = ser.submit(t2);
        Future<Boolean> f3 = ser.submit(t3);
        //获取结果
        Boolean b1 = f1.get();
        Boolean b2 = f2.get();
        Boolean b3 = f3.get();
        //关闭服务
        ser.shutdown();
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
