package com.test;

import java.util.*;

public class HeapTest {

    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<Byte[]>();
        while (true) {
            list.add(new Byte[1024*1024]);
        }
    }
}
