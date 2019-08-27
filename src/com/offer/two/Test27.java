package com.offer.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test27 {
    public static void main(String[] args) {

        Test27 t = new Test27();
        System.out.println(t.permutation("abc").toString());
    }

    public ArrayList<String> permutation(String str){
        List<String> res = new ArrayList<>();
        if(str != null && str.length() > 0){
            permutationHelper(str.toCharArray(), 0, res);
        }
        Collections.sort(res);
        return (ArrayList<String>)res;
    }

    public void permutationHelper(char[] arr, int i, List<String> list) {
        if(i == arr.length - 1){
            String val = String.valueOf(arr);
            if(!list.contains(val)){
                list.add(val);
            }
        }else{
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                permutationHelper(arr, i + 1, list);
                swap(arr, j, i);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
