package com.offer.one;

import java.util.HashMap;

public class Test34 {
    //问题：(第一个只出现一次的字符) 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    //如果没有则返回 -1（需要区分大小写）.
    //思路：法一：用哈希表的方式来统计字符出现的次数，时间复杂度O(n).
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(hashMap.containsKey(str.charAt(i))) {
                int value = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i), value + 1);
            }else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        for(int i = 0; i < str.length(); i++) {
            if(hashMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //法二：用类似哈希表的方式用来统计字符出现的次数，时间复杂度O(n)
    public int FirstNotRepeatingChar1(String str) {
        if(str == null || str.length() == 0) {
            return -1;
        }
        int[] hash = new int[256];
        //统计字符出现的次数，存在hash数组中
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            hash[temp]++;
        }

        //按顺序进行遍历，将出现的此处为1的字符打印出来
        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)] == 1){
                return i;
                /*char c = (char) temp;
                System.out.println(c);
                break;*/
            }
        }
        return -1;
    }
}
