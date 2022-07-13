package com.joe.generics;

public class ListDemo implements IListTypeValue<String> {

    public volatile String str = "";

    @Override
    public String add(String str) {
        return str;
    }

}

interface IListTypeValue<T>{

    String add(T t);

}
