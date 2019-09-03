package com.offer.two;

public class Test31 {
    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN_Solution1(13));
    }

    public static int numberOf1Between1AndN_Solution(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            char[] arr = str.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == '1'){
                    count++;
                }
            }
        }
        return count;
    }

    public static int numberOf1Between1AndN_Solution1(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while(temp != 0){
                if(temp % 10 == 1){
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}
