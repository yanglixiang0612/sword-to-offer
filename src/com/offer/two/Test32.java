package com.offer.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test32 {
    public static void main(String[] args) {

    }

    public String printMinNumber(int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = Integer.valueOf(arr[i] + "" + arr[j]);
                int b = Integer.valueOf(arr[j] + "" + arr[i]);
                if(a > b){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            str += String.valueOf(arr[i]);
        }
        return str;
    }

    public String printMinNumber1(int[] arr){
        String str = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for(int a : list){
            str += a;
        }
        return str;
    }

}
