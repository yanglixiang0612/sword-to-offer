package com.offer.one;

import java.util.Stack;
//问题：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
	/*思路一：1.看到这个问题, 我们最开始可能会想, 添加一个成员变量用于保存最小元素, 每次压栈时如果压栈元素比当前最小元素更小, 就更新最小元素。
		2.但是这样会有一个问题, 如果最小元素被弹出了呢, 如何获得下一个最小元素呢? 分析到这里可以发现, 仅仅添加一个成员变量存放最小元素
		是不够的, 我们需要在最小元素弹出后还能得到次小元素, 次小的弹出后, 还要能得到次次小的。
		3. 因此, 用另一个栈来保存这些元素是再合适不过的了. 我们叫它最小元素栈。
		4. 每次压栈操作时, 如果压栈元素比当前最小元素更小, 就把这个元素压入最小元素栈, 原本的最小元素就成了次小元素. 同理, 弹栈时, 如果弹
		出的元素和最小元素栈的栈顶元素相等, 就把最小元素的栈顶弹出。
			举例：
          	入栈顺序： 7 5 3 6 4 9 2
         	stack ： 7 5 3 6 4 9 2
          	minStack ：7 5 3 2
             思路二：
		解题思路：
		1.题目对时间复杂度要求很高，入栈、出栈、求最小值都要求O（1）的时间复杂度，因此如果只使用一个栈，肯定达不到要求。
		2.使用2个栈，stack1正常保存元素，stack2保存当前最小元素；
		3.入栈策略：对于一个需要入栈的元素x，stack1入栈x；stack2如果为空则直接入栈x，如果不为空，则将x和stack2栈顶元素之间最小的那个入栈；
		4.出栈策略：stack1和stack2都直接出栈即可；
		5.求min策略：返回stack2的栈顶元素即可，stack2不需要出栈。
		6.异常处理：当栈空时，继续出栈，会造成异常，无需自己定义异常，使用Stack自带的异常抛出机制；
		空间复杂度：O（n）
	*/

public class Test20 {
    Stack<Integer> data = new Stack<>();     //存放元素栈
    Stack<Integer> min = new Stack<>();      //辅助栈，data栈中每次进入一个元素，min辅助栈就存放当前data栈中的最小元素
    public void push(int node) {
        data.push(node);
        if(min.empty()) {					// 当min为空，或者当前值小于min栈顶元素是，入栈
            min.push(node);
        }else if(node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        if(data.peek() == min.peek()) {    //如果min的栈顶元素与data栈顶元素相同，同时pop;否则只弹data
            min.pop();
        }
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
