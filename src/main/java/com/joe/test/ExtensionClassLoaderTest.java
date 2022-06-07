package com.joe.test;

import java.io.File;
import java.util.StringTokenizer;

public class ExtensionClassLoaderTest {

    private static File[] getExtDirs(){
        String property = System.getProperty("java.ext.dirs");
        File[] files;
        if (property!=null){
            StringTokenizer stringTokenizer = new StringTokenizer(property, File.pathSeparator);
            int count = stringTokenizer.countTokens();
            files = new File[count];
            for (int i = 0; i < count; i++) {
                files[i] = new File(stringTokenizer.nextToken());
            }
        }else {
            files = new File[0];
        }
        return files;
    }

    public static void main(String[] args) {
        File[] extDirs = ExtensionClassLoaderTest.getExtDirs();
        for (int i = 0; i < extDirs.length; i++) {
            System.out.println("输出："+extDirs[i]);
        }
    }

}
