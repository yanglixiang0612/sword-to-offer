package com.offer.one;

import java.util.ArrayList;

public class Test33 {
    //(丑数) 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
    //习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    //思路：假定若干丑数已经在数组中排好序，记最大的丑数M，那么如何求下一个丑数？
	   /*（1）
	    1.任意一个丑数一定是另一个丑数乘以2或3或5得到的，我们可以使用一个数组将已经确认为丑数的数按照从小到大的顺序记录下来，每个丑数都是前面的丑数乘以2、3或5得来的。
	     2.如何确保数组中的丑数是排好序的？假设数组中已经有若干个排好序的丑数，并且其中最大的丑数为M。那么下一个丑数一定是数组中某个数乘以2或3或5的结果，所以我们把数组
	               中的每个数都乘以2，找到第一个大于M的结果M2（小于等于M的结果肯定已经在数组中了，不需要考虑）；同理，把数组中的每个数都乘以3，找到第一个大于M的结果M3；把数组
	               中的每个数都乘以5，找到第一个大于M的结果M5。那么下一个丑数一定是M2、M3、M5当中的最小值。
	　     　3.实际上，在寻找M2、M3、M5的过程中，不需要每次都从头开始遍历，只要记住上一次遍历到的位置，继续往后遍历即可。
	  */
		/*（2）
		 1.下一个丑数肯定是已排序数组arr内某一个数乘以2/3/5的结果后的最小值
		 Note: 数组内某一个数乘以2/3/5可能会小于M;
		 2.记第一个乘以2后，大于M的数的位置为idx2，同理idx3，idx5;
		 3.则下一个数为min([arr[idx2] * 2, arr[idx3] * 3, arr[idx5] * 5]);
		 4.求得下一个丑数后，更新idx2，idx3，idx5（乘以2/3/5后大于M的数！）
		*/
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);									//add进第一个丑数1
        int i2 = 0, i3 = 0, i5 = 0;						//三个下标用于记录丑数的位置
        while(list.size() < index) {
            int n2 = list.get(i2) * 2;
            int n3 = list.get(i3) * 3;
            int n5 = list.get(i5) * 5;
            int min = Math.min(n2, Math.min(n3, n5));	//三个数都是可能的丑数，取最小的放进丑数数组里面
            list.add(min);
            if(min == n2) {
                i2++;
            }
            if(min == n3) {
                i3++;
            }
            if(min == n5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
