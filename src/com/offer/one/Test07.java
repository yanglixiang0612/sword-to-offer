package com.offer.one;

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

    //法二：解题思路：斐波那契数列：F[n]=F[n-1]+F[n-2] (n>=3,F[1]=1,F[2]=1)。注意：此题要求F[1]=0。
    public int Fibonacci(int n) {//n<=39
        int[] array = new int[40];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < array.length; i ++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

}
