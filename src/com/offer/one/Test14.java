package com.offer.one;

import java.util.Scanner;

public class Test14 {
    //问题：输入一个链表，输出该链表中倒数第k个结点。
	/*思路：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
	然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。。
	      通俗的讲，相当于制造了一个K长度的尺子，把尺子从头往后移动，当尺子的右端与链表的末尾对齐的时候，尺子
         左端所在的结点就是倒数第k个结点！*/

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);*/
        int k = 1;    //当k=1时，不会经过for、while直接返回last（head）.
        System.out.println(FindKthToTail(head, k).val);

    }

    public static ListNode FindKthToTail(ListNode head, int k) {
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

    /*ListNode head=null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        com.offer.two.Test14 t = new com.offer.two.Test14();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                t.addNode(arr[i]);          //键盘录入链表
            }
            //temp = head;
           *//* while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }*//*
            int k = sc.nextInt();
            System.out.println(findKthFromTail(head, k).val);
        }


    }

    public static ListNode findKthFromTail(ListNode listNode, int k){
        if(listNode == null || k <= 0){
            return null;
        }
        ListNode pre = listNode;
        ListNode last = listNode;
        for (int i = 1; i < k; i++) {
            if(pre.next != null){
                pre = pre.next;
            }else{
                return null;
            }
        }
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public void addNode(int d) {
        ListNode N = new ListNode(d);
        if (head == null) {
            head = N;
            return;  *//*由于每次是增加一个节点，所以对头结点进行初始化之后就要退出函数*//*
        }
        ListNode temp = head;  *//*一般一个链表的头结点是不能动的，因此需要把头结点赋值给一个临时变量
		//这样在对链表进行访问的时候，就可以用这个临时变量进行逐个的访问，不对头结点产生影响*//*
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = N;
    }*/
}
