package com.heima.test;

public class Test14 {
    //问题：输入一个链表，输出该链表中倒数第k个结点。
	/*思路：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
	然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。。
	      通俗的讲，相当于制造了一个K长度的尺子，把尺子从头往后移动，当尺子的右端与链表的末尾对齐的时候，尺子
         左端所在的结点就是倒数第k个结点！*/
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for(int i = 1; i < k; i++) {
            if(pre.next != null) {
                pre = pre.next;
            }else {
                return null;
            }
        }
        while(pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
