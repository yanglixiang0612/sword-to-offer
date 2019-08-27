package com.itheima.bean;

public class Test07 {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.x);
    }
}
class A{
    int x = 1;
    public A(){
        System.out.println("111");
    }
}

class B extends A{
    int x = 2;
    public B(){
        System.out.println("222");
    }
}