package com.offer.two;

import java.util.ArrayList;

public class Test29 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 8, 10, 2, 9};
        Test29 t = new Test29();
        System.out.println(t.getLeastNumbers_Solution(arr, 6).toString());
    }

    //法一：冒泡排序
    public ArrayList<Integer> getLeastNumbers_Solution(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null || k > arr.length){
            return list;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    //法二：选择排序
    public ArrayList<Integer> getLeastNumbers_Solution1(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null || k > arr.length){
            return list;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    //法三：快速排序法
    public ArrayList<Integer> getLeastNumbers_Solution2(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null || k > arr.length){
            return list;
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public void quickSort(int[] arr, int start, int end) {
        if(start < end){
            int stard = arr[start];
            int low = start;
            int high = end;
            while(low < high){
                while(low < high && stard <= arr[high]){
                    high--;
                }
                arr[low] = arr[high];

                while(low < high && stard >= arr[low]){
                   low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    //法三：归并排序法
    public ArrayList<Integer> getLeastNumbers_Solution3(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null || k > arr.length){
            return list;
        }
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void mergeSort(int[] arr, int low, int high){
        int middle = (low + high)/2;
        if(low < high){
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int index = 0;
        while(i <= middle && j <= high){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i++;
            }else{
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while(i <= middle){
            temp[index] = arr[i];
            index++;
            i++;
        }
        while(j <= high){
            temp[index] = arr[j];
            index++;
            j++;
        }
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }

    }
}
