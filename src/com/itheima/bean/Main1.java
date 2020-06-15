package com.itheima.bean;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();  //大家
        int count = 0;
        for (int i = m; i <= n; i++) {
            if(i%3%2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
