package com.offer.two;


class RandomListNode{
    int val;
    RandomListNode random = null;
    RandomListNode next = null;
    public RandomListNode(int val){
        this.val = val;
    }
}
public class Test25 {
    public static void main(String[] args) {

    }

    //复杂链表的复制
    public RandomListNode clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }

        //1
        RandomListNode pCur = pHead;
        while(pCur != null){
            RandomListNode node = new RandomListNode(pCur.val);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }

        //2
        pCur = pHead;
        while(pCur != null){
            if(pCur.random != null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }

        //3
        RandomListNode head = pHead.next;
        RandomListNode temp = head;
        pCur = pHead;
        while(pCur.next != null){
            temp = pCur.next;
            pCur.next = temp.next;
            pCur = temp;
        }
        return  head;

    }
}
