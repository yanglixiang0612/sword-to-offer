package com.offer.two;

public class Test16 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(8);
        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(8);
        Test16 t = new Test16();
        ListNode newList = t.merge(list1, list2);
        while(newList != null){
            System.out.print(newList.val + " ");
            newList = newList.next;
        }

    }

    public  ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }
        return head.next;
    }

    public ListNode merge2(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode h = new ListNode(-1);
        ListNode head = h;               //head暂存新建的头节点，合并之后返回head.next，就是题目给的头节点
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        if(list1 != null) {
            head.next = list1;			//把未结束的链表连接到合并后的链表尾部
        }
        if(list2 != null) {
            head.next = list2;
        }
        return h.next;
    }

    public ListNode merge1(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = merge1(list1.next, list2);
            return list1;
        }else{
            list2.next = merge1(list1, list2.next);
            return list2;
        }
    }

}
