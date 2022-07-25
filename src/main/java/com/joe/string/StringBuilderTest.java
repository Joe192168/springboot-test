package com.joe.string;

public class StringBuilderTest {

    public static void main(String[] args) {
        //无参构造初始容量为: 16
        StringBuilder sb = new StringBuilder();

        //使用StringBuffer的capacity()方法可以查看其当前容量
        System.out.println("a.capacity():"+sb.capacity()+"------- a.length():"+sb.length());

        //一次添加20个长度，因为超过了初始容量，因此会扩容16*16+2=34
        sb.append("00000000001111111111");
        System.out.println("a.capacity():"+sb.capacity()+"------- a.length():"+sb.length());
    }

}
