package com.offer.two;

import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        System.out.println(jumpFloor(n));
    }

    public static int jumpFloor(int n){
        int n1 = 1;
        int n2 = 2;
        int result = 0;
        if(n <= 0){
            return -1;
        }
        if(n == 1 || n == 2){
            return n;
        }
        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
