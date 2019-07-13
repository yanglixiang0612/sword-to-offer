package com.heima.test;

public class Test09 {
    //问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //法一：思路：
  /*（1）假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1)；假定第一次跳的是2阶，那么剩下的是n-2个台阶，
	   跳法是f(n-2)；假定第一次跳的是3阶，那么剩下的是n-3个台阶，跳法是f(n-3)......假定第一次跳的是n-1阶，
	   那么剩下的是1个台阶，跳法是f(1)； 假定第一次跳的是n阶，那么剩下的是0个台阶，跳法是1种；
	（2）总跳法为: f(n) = 1+f(n-1) + f(n-2)+....+f(1)  （第一个1是跳n阶只有一种方法）
	（3）根据（2）可以得出有一阶的时候：f(1) = 1;
					有两阶的时候可以有：f(2) = 1+f(1)=2;
					有三阶的时候可以有：f(3) = 1+f(2)+f(1)=4;
					有四阶的时候可以有：f(4) = 1+f(2)+f(1)=8...依次内推，有n阶时f(n)=2^(n-1)。
  */
    public int jumpFloor(int target) {
        return (int) Math.pow(2, target - 1);
    }

    //法二：思路：
		/*因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
		跳1级，剩下n-1级，则剩下跳法是f(n-1)；
		跳2级，剩下n-2级，则剩下跳法是f(n-2)；
		所以f(n)=f(n-1)+f(n-2)+...+f(1)
		因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
		所以f(n)=2*f(n-1)。

					   | -1      ,(n<=0)
			f(n) =     | 1       ,(n=1 )
			           | 2*f(n-1),(n>=2)
		*/
    public int JumpFloor(int target) {
        if(target <= 0) {
            return -1;
        }
        if(target == 1) {
            return 1;
        }
        return 2*JumpFloor(target - 1);
    }
}
