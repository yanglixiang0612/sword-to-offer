package com.offer.two;

import java.util.HashMap;
import java.util.Map;

public class Test28 {
    public static void main(String[] args) {

    }

    public int moreThanHalfNum_Solution(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int num = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == num){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                num = arr[i];
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                count++;
            }
        }
        if(count > arr.length/2){
            return num;
        }else{
            return 0;
        }
    }

    //法二：MAP
    public int moreThanHalfNum_Solution1(int[] arr){
        if(arr.length == 0 || arr == null){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > arr.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
