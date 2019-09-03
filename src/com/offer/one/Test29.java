package com.offer.one;

import java.util.ArrayList;
import java.util.Arrays;

public class Test29 {
    //问题：(最小的K个数) 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
    //法一：思路：冒泡排序
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> a = new ArrayList<>();
        if(input == null || k > input.length) {
            return a;
        }
        for(int i = 0; i < input.length - 1; i++) {
            for(int j = 0; j < input.length - 1 - i; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }

    //法二：选择排序
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k){
        ArrayList<Integer> a = new ArrayList<>();
        if(input == null || k > input.length) {
            return a;
        }
        for(int i = 0; i < input.length - 1; i++) {
            for(int j = i + 1; j < input.length; j++) {
                if(input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        for(int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }

    //法三：Arrays.sort(input).
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k){
        ArrayList<Integer> a = new ArrayList<>();
        if(input == null || k > input.length) {
            return a;
        }
        Arrays.sort(input);
        for(int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }

    //法四: 快速排序。
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k){
        ArrayList<Integer> a = new ArrayList<>();
        if(input == null || k > input.length) {
            return a;
        }
        quickSort(input, 0, input.length - 1);
        for(int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }

    public void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int stard = arr[start];							//把数组中的第0个数作为标准数
            int low = start;
            int high = end;          					    //记录需要排序的下标
            while(low < high) {								//循环找比标准数大的数和比标准数小的数
                while(low < high && stard <= arr[high]) {	//右边的数比标准数大
                    high--;
                }
                arr[low] = arr[high];						//使用右边的数字替换左边的数
                while(low < high && stard >= arr[low]) {	//如果左边的数字比标准数小
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;								//把标准数赋给低所在的位置的元素
            quickSort(arr, start, low);						//处理所有的小的数字
            quickSort(arr, low+1, end);						//处理所有的大的数字
        }
    }

    //法五: 归并排序。(递归-合并)
    public ArrayList<Integer> GetLeastNumbers_Solution4(int[] input, int k){
        ArrayList<Integer> a = new ArrayList<>();
        if(input == null || k > input.length) {
            return a;
        }
        mergeSort(input, 0, input.length - 1);
        for(int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }
    public static void mergeSort(int[] arr,int low,int high) {
        int middle = (low+high)/2;
        if(low<high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle+1,high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr,int low,int middle,int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;
        while(i<=middle&&j<=high) {
            if(arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            }else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while(j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while(i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }

        for (int k = 0; k < temp.length; k++) {
            arr[k+low] = temp[k];
        }
    }
}
