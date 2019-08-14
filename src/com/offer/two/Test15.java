package com.offer.two;

import java.util.Scanner;

public class Test15 {

    static ListNode head = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test15 t = new Test15();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                t.addNode(arr[i]);          //借助一个方法实现链表的键盘录入
            }
            System.out.println(reverseList(head).val);
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void addNode(int d){
        ListNode listNode = new ListNode(d);
        if(head == null){
            head = listNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = listNode;
    }
}
