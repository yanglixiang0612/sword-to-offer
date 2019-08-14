package com.offer.two;

import java.util.List;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}

public class Test14 {

    static ListNode head=null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test14 t = new Test14();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                t.addNode(arr[i]);          //键盘录入链表
            }
            //temp = head;
           /* while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }*/
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
            return;  /*由于每次是增加一个节点，所以对头结点进行初始化之后就要退出函数*/
        }
        ListNode temp = head;  /*一般一个链表的头结点是不能动的，因此需要把头结点赋值给一个临时变量
		//这样在对链表进行访问的时候，就可以用这个临时变量进行逐个的访问，不对头结点产生影响*/
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = N;
    }

}
