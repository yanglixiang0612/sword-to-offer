package com.heima.test;

import java.util.Scanner;

public class Test01 {
	/*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
	每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
	判断数组中是否含有该整数。*/

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int target = input.nextInt();
        System.out.println(find(arr,target));

    }
    //方法一：把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案。
    public static boolean find(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int low = 0;
            int high = arr[i].length - 1;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(target > arr[i][mid]) {
                    low = mid + 1;
                }else if(target < arr[i][mid]) {
                    high = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    //方法二：利用二维数组由上到下，由左到右递增的规律，那么选取右上角(或者左下角)的元素a[row][col]与target进行比较，
    //当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,即col--;
    //当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,即row++.
    public static boolean find1(int[][] arr,int target) {
        int row = 0;
        int col = arr[0].length - 1;
        while(row <= arr.length - 1&&col >= 0) {
            if(target == arr[row][col]) {
                return true;
            }else if(target > arr[row][col]) {
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
