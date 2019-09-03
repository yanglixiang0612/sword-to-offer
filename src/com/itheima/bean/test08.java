package com.itheima.bean;

public class test08 {
}

class Base{
    public Base(String s){
        System.out.println("B");
    }
}
class Bb extends Base{
    public Bb(String s){
        super("1");
        System.out.println("D");
    }
}
