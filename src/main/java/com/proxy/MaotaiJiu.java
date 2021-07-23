package com.proxy;

//实现Market接口，卖茅台酒
public class MaotaiJiu implements Market {

    @Override
    public void maiJiu() {
        System.out.println("我卖的是茅台酒");
    }
}
