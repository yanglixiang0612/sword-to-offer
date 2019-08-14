package com.offer.one;

public class Test16 {
    //问题：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

    /*法一：思路：首先要考虑特殊情况，当两个链表都为空时，其结果为空；当其中一个为空时，结果为另一个。
    然后考虑正常情况（两个都不为空时），找出两个链表中头节点值小者为合并后链表的头节点，
    再然后以头节点值小的链表的下一个节点为该链表的头节点与另一个链表头节点比较，较小者加
    到合并链表的尾部，以此类推，直到某一个链表为空，将另一个链表加到合并链表尾部。
    */
    public ListNode Merge(ListNode list1, ListNode list2) {
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

    //法二：递归：得到两个链表中值较小的头结点并把它连接到已经合并的链表之后，两个链表剩余的结点依然是排序的，
    //因此，合并的步骤和之前的步骤是一样的，这是典型的递归过程。
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
