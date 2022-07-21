package com.joe.lambda;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ListMapTest {

    public static void main(String[] args) {

        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<>();
        map1.put("id",1);
        map1.put("target_value",1);

        list.add(map1);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("id",2);
        map2.put("target_value",1);

        list.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("id",1);
        map3.put("target_value",1);

        list.add(map3);

        //根据id重复合并重复数据
        List<Map<String, Object>> mapList = list.stream().collect(Collectors.toMap(a -> a, v -> v, (o1, o2) -> {
            if (o1.get("id").equals(o2.get("id"))) {
                Integer v1 = 0;
                Integer v2 = 0;
                if (o1.get("target_value") != null) {
                    v1 = (Integer) o1.get("target_value");
                }
                if (o2.get("target_value") != null) {
                    v2 = (Integer) o2.get("target_value");
                }
                int v = v1 + v2;
                o1.put("id", o1.get("id"));
                o1.put("target_value", v);
            }
            return o1;
        })).values().stream().collect(Collectors.toList());

        for (Map<String, Object> map : mapList) {
            System.out.println(map.get("id")+":"+map.get("target_value"));
        }
    }
}
