package com.joe.test;

public class TestValues {

    public static void main(String[] args) {
        String str = "CAL_MONTH is null and CAL_MONTH like '2021%'";
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i].equals("is")+":"+split[i]);
        }
    }

}
