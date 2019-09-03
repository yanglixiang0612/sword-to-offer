package com.offer.two;

public class Test35 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 3};
        Test35 t = new Test35();
        System.out.println(t.inversePairs(arr));
    }

    int cnt;
    public int inversePairs(int[] arr){
        if(arr.length != 0){
            divide(arr, 0, arr.length - 1);
        }
        return cnt;
    }

    public void divide(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                cnt = (cnt + mid - i + 1) % 1000000007;
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }
    }
}
