package com.joe.vector;

import java.util.ArrayList;
import java.util.List;

public class TestVector {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        for (int i = 0; i < list.size(); i++) {
            if("lisi".equals(list.get(i))){
                list.remove(i);
            }
            System.out.println("姓名："+list.get(i));
        }
    }

}
