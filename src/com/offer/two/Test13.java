package com.offer.two;

import java.util.Scanner;

public class Test13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            reOrderArray2(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    //法一：插入排序
    public static void reOrderArray(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            if(arr[i]%2 == 1){
                int j = i;
                while(j >= 1 && arr[j - 1]%2 == 0){
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = target;
            }
        }
    }

    //法二
    public static void reOrderArray2(int[] arr){
        int[] a = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 1){
                a[count] = arr[i];
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 0){
                a[count] = arr[i];
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
    }
}
