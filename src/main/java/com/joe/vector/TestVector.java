package com.joe.vector;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        String sql = "year";
        /*String[] split = sql.split("\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }*/
        List<String> list1 = new ArrayList<>();
        list1.add("month.get(0)");
        String str = "month1";
        //System.out.println(sql.substring(0,sql.indexOf(".")));
        System.out.println(list1.stream().filter(s -> s.contains(str)).collect(Collectors.toList()).size());


        String sql9 = "SELECT\n" +
                "a.DATE_ID,\n" +
                "b.CAL_YEAR,\n" +
                "b.CAL_MONTH,\n" +
                "b.CAL_DATE,\n" +
                "a.BILLING_OFFICE_ID,\n" +
                "c.OFFICE_NAME,\n" +
                "a.BILLING_PERSON_ID,\n" +
                "d.USER_NAME,\n" +
                "a.DRUG_MONEY,\n" +
                "a.TOTAL_MONEY \n" +
                "FROM\n" +
                "f_drug_use a,\n" +
                "t_dates b,\n" +
                "t_office_property c,\n" +
                "t_user_property d \n" +
                "WHERE\n" +
                "a.DATE_ID = b.ID \n" +
                "AND a.BILLING_OFFICE_ID = c.ID \n" +
                "AND a.BILLING_PERSON_ID = d.ID \n" +
                "AND b.CAL_DATE >= '${startDate}'" +
                "AND b.CAL_DATE <= '${endDate}'\n" +
                "AND '${CAL_MONTH:camonth}'\n" +
                "and b.CAL_YEAR > '${year}'\n" +
                "and b.CAL_MONTH >= '${month.get(0)}'\n"+
                "and b.CAL_MONTH <= '${month.get(1)}'\n"+
                //"AND b.CAL_MONTH BETWEEN '${month.get(0)}' and '${month.get(1)}'" +
                "";

        Set<String> set = getContentInfo(sql9);

    }


    public static Set<String> getContentInfo(String content) {
        Pattern regex = Pattern.compile("\\$\\{([^}]*)\\}");
        Matcher matcher = regex.matcher(content);
        Set<String> sql = new HashSet<>();
        while(matcher.find()) {
            String group = matcher.group(1);
            if (group.contains(":")) {
                String[] split = group.split(":");
                sql.add(split[1]);
            }else{
                if (matcher.group(1).contains(".")){
                    String[] split = matcher.group(1).split("\\.");
                    sql.add(split[0]);
                }else {
                    sql.add(matcher.group(1));
                }
            }
        }
        return sql;
    }

}
