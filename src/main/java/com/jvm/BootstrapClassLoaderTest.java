package com.jvm;

import java.net.URL;

public class BootstrapClassLoaderTest {

    public static void main(String[] args) {
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }
    }
}