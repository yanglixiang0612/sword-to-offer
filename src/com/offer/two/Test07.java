package com.offer.two;

public class Test07 {

    public static void main(String[] args) {
        System.out.println(fibonacci2(8));
    }

    //法一   非递归
    public static int fibonacci(int n){

        int preTwo = 0;
        int preOne = 1;
        int result = 0;

        if(n == 0){
            return preTwo;
        }
        if(n == 1){
            return preOne;
        }
        for (int i = 2; i <= n; i++) {
            result = preTwo + preOne;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    //法二  非递归
    public static int fibonacci2(int n){
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
