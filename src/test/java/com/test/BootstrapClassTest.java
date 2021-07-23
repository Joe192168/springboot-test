package com.test;

import sun.misc.Launcher;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BootstrapClassTest {

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        List<URL> collect = Arrays.stream(urLs).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
