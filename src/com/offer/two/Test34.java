package com.offer.two;

import java.util.HashMap;
import java.util.Map;

public class Test34 {
    public static void main(String[] args) {
        String str = "twwfewrsuegfvfwhuqmqsat";
        Test34 t = new Test34();
        int n = t.firstNotRepeatingChar1(str);
        System.out.println(n);



    }

    public int firstNotRepeatingChar(String str){
        if(str == null || str.length() == 0){
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstNotRepeatingChar1(String str){
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] hash = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            hash[temp]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if(hash[str.charAt(i)]  == 1){
                return i;
            }
        }
        return -1;
    }

}
