package com.offer.one;
class Test10 {
    //问题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	/*法一：思路用归纳法归纳如下：斐波那契数列（递归）
	（1）当 n < 1时，显然不需要用2*1块覆盖，按照题目提示应该返回 0。
	（2）当 n = 1时，只存在1种情况。
	（3）当 n = 2时，存在2种情况。
	（4）当 n = 3时，存在3种情况。
	（5）当 n = 4时，存在5种情况。
	        新增加的2*1 方块与临近的2*1方块组成 2*2结构，然后可以变形成 “=”。于是 n = 4在原来n = 3基础上增加了"| | ="、“= =”。
	再自己看看这多出来的两种形式，是不是只比n = 2多了“=”。其实这就是关键点所在...因为，只要2*1或1*2有相同的两个时，就会组成2*2形式，于是就又可以变形了。
	所以，自然而然可以得出规律： f(n) = f(n-1) + f(n-2)， (n > 2)。

	如果看了这一套理论还存在疑惑。可以尝试将题目改成1*3方块覆盖3*n、1*4方块覆盖4*n。
	相应的结论应该是：
	（1）1 * 3方块 覆 盖3*n区域：f(n) = f(n-1) + f(n - 3)， (n > 3)
	（2） 1 *4 方块 覆 盖4*n区域：f(n) = f(n-1) + f(n - 4)，(n > 4)
	更一般的结论，如果用1*m的方块覆盖m*n区域，递推关系式为f(n) = f(n-1) + f(n-m)，(n > m)。
	*/
    public int RectCover(int target) {
        if(target < 1) {
            return 0;
        }
        if(target == 1 || target == 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    //法二：循环
    public int rectCover(int target) {
        if(target < 1) {
            return 0;
        }
        if(target == 1 || target == 2) {
            return target;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 3; i <= target; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
