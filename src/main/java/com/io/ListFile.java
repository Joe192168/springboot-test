package com.io;

import java.io.File;

public class ListFile {

    public static void main(String[] args) {
        File dir = new File("g:\\测试");
        //listDir(dir);
        deleteDir(dir);
    }

    //遍历文件夹
    private static void listDir(File dir){
        File[] files = dir.listFiles();
        System.out.println("文件夹绝对路径："+dir.getAbsolutePath());
        if (files!=null&&files.length>0){
            for (File file : files) {
                if (file.isDirectory()){
                    listDir(file);//递归
                }else{
                    System.out.println("文件绝对路径："+file.getAbsolutePath());
                }
            }
        }
    }

    //遍历删除文件和文件夹
    //先删除文件，才能删除文件夹
    private static void deleteDir(File dir){
        File[] files = dir.listFiles();
        if (files!=null&&files.length>0){
            for (File file : files) {
                if (file.isDirectory()){
                    deleteDir(file);//递归
                }else{
                    //删除文件
                    System.out.println(file.getAbsoluteFile()+"文件删除："+file.delete());
                }
            }
        }
        System.out.println(dir.getAbsoluteFile()+"文件夹删除："+dir.delete());
    }

}
