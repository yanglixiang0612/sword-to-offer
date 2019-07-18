package com.heima.test;

public class Test12 {
    //问题：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	/*法一：思路：算法的本质就是模拟数学规律，我们可以先模拟一下幂运算就是乘法的连乘，那么用算法写出来，
	    然后再考虑几个测试用例的极端情况，如exponent==0或者exponent<0的情况，然后按逻辑写出你
	    的代码就好了，不要把他想的有多难，羞愧是负能量最高的能量场。
	 */
    public double Power(double base,int exponent) {
        if(exponent == 0) {
            return 1;
        }else if(exponent > 0) {
            double num = 1;
            for(int i = 0; i < exponent; i++) {
                num = num * base;
            }
            return num;
        }else {
            if(base == 0) {
                throw new RuntimeException("0不能做分母");
            }
            double nums = 1;
            int flag = -exponent;
            for(int i = 0; i < flag; i++) {
                nums = nums * base;
            }
            return 1/nums;
        }

    }
    //法二：
    public double Power1(double base, int exponent) {
        int n=0;
        if(exponent>0)
            n=exponent;
        if(exponent<0)
            n=-exponent;
        double re=1;
        for(int i=0; i<n; i++)
            re*=base;
        if(exponent>0)
            return re;
        else
            return 1/re;
    }
    //法三：思路：不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况。
    public double Power2(double base, int exponent) {
        double res = 0;
        if(equal(base,0)) {
            return 0;
        }
        if(exponent == 0) {
            return 1.0;
        }
        if(exponent > 0) {
            res = mutiply(base,exponent);
        }else {
            res = mutiply(1/base,-exponent);
        }
        return res;
    }

    public double mutiply(double base, int e) {
        double sum = 1;
        for (int i = 0; i < e; i++) {
            sum = sum * base;
        }
        return sum;
    }

    public boolean equal(double a, double b) {
        if (a - b < 0.000001 && a - b > -0.000001) {
            return true;
        }
        return false;
    }
}
