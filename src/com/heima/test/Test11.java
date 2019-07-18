package com.heima.test;

public class Test11 {
    //问题：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	/*法一：思路：如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
	  原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。

  	       举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而
  	   前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再
  	   把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.也就是
  	   说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少
  	   次这样的操作。

  	   	  负数也是用二进制表示的，只不过使用补码，最高位的符号位是1，用补码减1时，运算规则和正数用原码是一样的。每次 n & (n-1)
  	   都会使得二进制数据的最右边的一个1变为0，所以有多少个1就会执行循环多少次，直至没有1（也就是0）。
	 */
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n&(n - 1);
        }
        return count;
    }

    //法二：
    public int NumberOf2(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1)    //法2：count+=n&1;  //逐个判断低位是否为1；
                count++;
            n=n>>>1;		//无符号右移，例如从11101变成1110
        }
        return count;
    }
}
