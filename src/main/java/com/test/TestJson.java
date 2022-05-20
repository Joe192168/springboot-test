package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

    public static void main(String[] args) {
        String str = "[{\"key\":\"hehe1hehe\",\"val\":\"住院天数\",\"table\":\"6677ffff\"},{\"key\":\"hehe2hehe\",\"val\":\"入径天数\",\"table\":\"6677ffff\"}]";
        JSONArray sw = JSON.parseArray(str);
        Object[] objects = sw.stream().toArray();
        for (Object object : objects) {
            JSONObject jsonObject = JSON.parseObject(object.toString());
            System.out.println(jsonObject.get("val"));
        }
    }

}
