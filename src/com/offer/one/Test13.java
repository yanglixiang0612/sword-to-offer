package com.offer.one;

public class Test13 {
    //问题：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    //所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    //法一：插入排序
    public static void reOrderArray1(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            if(arr[i]%2 == 1){
                int j = i;
                while(j >= 1 && arr[j - 1]%2 == 0){
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = target;
            }
        }
    }

    //法二：
    public void reOrderArray2(int[] array) {
        int[] a = new int[array.length];
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2 != 0) {
                a[count] = array[i];
                count++;
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2 == 0) {
                a[count] = array[i];
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }

    //法三：
    public void reOrderArray3(int[] array) {
        int[] a = new int[array.length];		//存放偶数
        int[] b = new int[array.length];		//存放奇数和排好后的数组
        int m = 0;
        int n = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2 == 0) {
                a[m] = array[i];
                m++;
            }else {
                b[n] = array[i];
                n++;			//记录奇数的个数
            }
        }
        for(int i = 0; i < m; i++) {
            b[i+n] = a[i];
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = b[i];
        }
    }
}
