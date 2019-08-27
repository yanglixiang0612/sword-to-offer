package com.offer.one;

import java.util.Arrays;

public class Test28 {

    //问题：(数组中出现次数超过数组长度一半的数字) 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    //由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
	/*法一：思路：(时间复杂度是O(n))
		如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
		在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
	          若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。(第一个循环只
	          能求出出现次数最多的元素，不能保证这个元素出现的次数大于数组长度的一半，所以要进行验证).
	 */
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int num = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == num) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == num) {
                count++;
            }
        }
        if(2 * count > array.length) {
            return num;
        }else {
            return 0;
        }
    }

    //法二：思路：数组排序(快排)后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
    //这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优.
    public int MoreThanHalfNum_Solution1(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int mid = array[array.length/2];
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == mid) {
                count++;
            }
        }
        if(count > array.length/2) {
            return mid;
        }else {
            return 0;
        }
    }
}
