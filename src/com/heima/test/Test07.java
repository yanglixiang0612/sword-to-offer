package com.heima.test;

public class Test07 {
    //问题：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
    //思路：递归的效率低，使用循环方式。
    public int fibonacci(int n) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;
        if(n == 0) {
            return preTwo;
        }
        if(n == 1) {
            return preOne;
        }
        for(int i = 2; i <= n; i++) {
            result = preTwo + preOne;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

}
