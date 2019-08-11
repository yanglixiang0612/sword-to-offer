package com.offer.two;

public class Test11 {
    public static void main(String[] args) {
        System.out.println(numberOf1(-9));
    }

    //法一(推荐)
    public static int numberOf1(int n){
        int count = 0;
        while(n != 0){
            n = n&(n - 1);
            count++;
        }
        return count;
    }

    //法二
    public static int numberOf11(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
