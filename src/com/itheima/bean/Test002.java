package com.itheima.bean;

import java.util.Scanner;

public class Test002 {
    public static void main(String[] args) {
        //键盘录入数组
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        /*System.out.println("该数组为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }
}
