package com.offer.two;

public class Test12 {

    public static void main(String[] args) {
        System.out.println(power1(5, -2));
    }

    public static double power(double base, int exponent){
        if(exponent == 0){
            return 1;
        }else if(exponent > 0){
            double num = 1;
            for (int i = 0; i < exponent; i++) {
                num = num * base;
            }
            return num;
        }else{
            if(base == 0){
                throw new RuntimeException("分母不能为0");
            }
            double nums = 1;
            int flag = -exponent;
            for (int i = 0; i < flag; i++) {
                nums = nums * base;
            }
            return 1/nums;
        }
    }

    //法二
    public static double power1(double base, int exponent){
        int n = 0;
        if(exponent == 0){
            return 1;
        }
        if (exponent > 0){
            n = exponent;
        }
        if (exponent < 0){
            n = -exponent;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * base;
        }
        if(exponent < 0){
            return 1/res;
        }else{
            return res;
        }
    }
}
