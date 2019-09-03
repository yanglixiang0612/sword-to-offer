package com.offer.one;

public class Test35 {
    //问题：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
    //求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007.
    //思路：归并排序的改进
	/*
	  1.归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项),合并数组, 合并时, 出现前面的数组值array[i]大于
	     后面数组值array[j]时; 则前面数组array[i]~array[mid]都是大于array[j]的, count += mid+1 - i.
	  2.参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余.
	*/
    int cnt;											//统计逆序对的个数
    public int InversePairs(int[] array) {
        if(array.length != 0) {
            divide(array, 0, array.length - 1);
        }
        return cnt;
    }

    public void divide(int[] arr, int start, int end) {	//归并排序的分治---分
        if(start >= end) {								//递归的终止条件
            return;
        }
        int mid = start + (end - start) / 2;			//计算中间值，注意溢出
        divide(arr, start, mid);						//递归分
        divide(arr, mid + 1, end);

        merge(arr, start, mid, end);					//治
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;									//存一下变量
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end) {					//下面就开始两两进行比较，若前面的数大于后面的数，就构成逆序对
            if(arr[i] <= arr[j]) {						//若前面小于后面，直接存进去，并且移动前面数所在的数组的指针即可
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
                cnt = (cnt + mid - i + 1) % 1000000007;	//a[i]>a[j]了，那么这一次，从a[i]开始到a[mid]必定都是大于这个a[j]的，因为此时分治的两边已经是各自有序了
            }
        }
        while(i <= mid) {								//各自还有剩余的没比完，直接赋值即可
            temp[k++] = arr[i++];
        }
        while(j <= end) {
            temp[k++] = arr[j++];
        }
        for(k = 0; k < temp.length; k++) {				//覆盖原数组
            arr[start + k] = temp[k];
        }
    }
}
