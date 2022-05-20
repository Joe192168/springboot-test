package com.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 1、分隔符
 * 2、文件操作
 * 3、文件夹操作
 */
public class FileTest {

    public static void main(String[] args) throws Exception {
        //fengefu();
        //filecaozuo();
        wenjianjiacaozuo();
    }

    //分隔符
    public static void fengefu(){
        System.out.println("路径分隔符："+File.pathSeparator);
        System.out.println("名称分隔符："+File.separator);
    }

    //文件操作
    public static void filecaozuo()throws Exception{
        //1、创建文件
        File file = new File("g:\\com.test.txt");
        //2、判断不存在创建，否则删除
        if (file.exists()){
            //直接删除
            //file.delete();
            //使用jvm退出时删除
            file.deleteOnExit();
            TimeUnit.SECONDS.sleep(3);
        }else {
            file.createNewFile();
        }
        //3、获取文件夹信息
        System.out.println("获取文件的绝对路径："+file.getAbsolutePath());
        //文件是绝对路径就获取绝对路径，文件是相对路径就获取的是相对路径
        System.out.println("获取路径："+file.getPath());
        System.out.println("获取文件名称："+file.getName());
        System.out.println("获取文件的父目录："+file.getParent());
        System.out.println("获取文件内容的长度："+file.length());
        System.out.println("获取文件创建的时间："+new Date(file.lastModified()).toLocaleString());

        //4、判断
        System.out.println("文件是否可写："+file.canWrite());
        System.out.println("是否是文件："+file.isFile());
        System.out.println("是否隐藏："+file.isHidden());
    }



    //文件夹操作
    public static void wenjianjiacaozuo()throws Exception{
        //1、创建文件夹
        File dir = new File("g:\\测试\\新建文件夹");
        //2、创建
        //3、判断是否存在
        if (!dir.exists()){
            //这个方法只能创建单个目录
            //dir.mkdir();
            //创建多级目录
            dir.mkdirs();
        }
        //4、删除文件夹
        //直接删除，目录必须是空的，而且只是删除一级
        //System.out.println("删除："+dir.delete());
        //jvm退出时删除
        //dir.deleteOnExit();
        //TimeUnit.SECONDS.sleep(3);
        //5、获取文件夹信息
        System.out.println("获取文件的绝对路径："+dir.getAbsolutePath());
        //文件是绝对路径就获取绝对路径，文件是相对路径就获取的是相对路径
        System.out.println("获取路径："+dir.getPath());
        System.out.println("获取文件名称："+dir.getName());
        System.out.println("获取文件的父目录："+dir.getParent());
        System.out.println("获取文件创建的时间："+new Date(dir.lastModified()).toLocaleString());
        //6、判断
        System.out.println("是否是文件夹："+dir.isDirectory());
        System.out.println("是否隐藏："+dir.isHidden());
        //7、遍历文件夹
        File dir2 = new File("g:\\大数据工具包");
        for (String s : dir2.list()) {
            System.out.println(s);
        }
        System.out.println("--------------------------");
        //8、FileFilter过滤接口使用
        File[] listFiles = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".png")) {
                    return true;
                }
                return false;
            }
        });
        List<File> collect = Arrays.stream(listFiles).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
