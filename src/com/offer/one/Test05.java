package com.offer.one;

import java.util.Stack;

//问题：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

	/*思路： 用两个栈实现队列是非常典型的面试问题，想要写出这道题，只要想明白栈和队列的联系和区别就好了。
		         栈最大的特点是先进后出，而队列的特点是先进先出。想要shi'实现先出这个问题，只要把第一个栈里面先进
		         去的那个数放在栈顶就好了，所以就用到了第二个栈，把第一个里面栈的元素再拿出来放在第二个栈里面就好了。
	         即：把数字放在栈1里面，然后把所有栈1的元素放在栈2里面，再把数从栈2里面拿出来，就可以实现先进先出的队列了。

		   1.java.util.Stack<E>继承类 java.util.Vector
	       2.empty()方法是Stack自己实现的方法
	       3. isEmpty() 是从Vector继承的方法
	       4.其实两者用法差不多一样
	 */

public class Test05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
