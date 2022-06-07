package com.joe.error;

import java.io.UnsupportedEncodingException;

public class Test2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "";
        s.getBytes("utf-8");
    }

}
