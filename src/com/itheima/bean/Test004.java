package com.itheima.bean;

import java.util.Scanner;

public class Test004 {

    //(贝壳笔试)把纸带撕成两半，仍然使得两边的数值之和是相等的
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();

                int p = i > 0 ? arr2[i - 1] : 0;
                arr2[i] = p + arr1[i];

            }
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                if(arr2[i] == arr2[n - 1] - arr2[i]){
                    result++;
                }
            }
            System.out.println(result);
        }

    }
}
