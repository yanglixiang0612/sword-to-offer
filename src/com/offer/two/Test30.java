package com.offer.two;

public class Test30 {
    public static void main(String[] args) {
        int[] arr = {8, 2, -6, 8, -3, 4};
        System.out.println(findGreatestSumOfSubArray(arr));
    }

    public static int findGreatestSumOfSubArray(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int currentSum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(currentSum <= 0){
                currentSum = arr[i];
            }else{
                currentSum += arr[i];
            }
            if(currentSum > max){
                max = currentSum;
            }
        }
        return max;
    }
}
