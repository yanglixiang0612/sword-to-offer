package com.offer.one;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}



public class Test25 {
    //问题：(复杂链表的复制) 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    //返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）.
	/*思路：1.遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面;
		   2.重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
           3.拆分链表，将链表拆分为原链表和复制后的链表.
	*/
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        //1
        RandomListNode pCur = pHead;
        while(pCur != null) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }

        //2
        pCur = pHead;
        while(pCur != null) {
            if(pCur.random != null) {
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }

        //3
        RandomListNode head = pHead.next;
        RandomListNode tmp = head;
        pCur = pHead;
        while(pCur.next != null) {
            tmp = pCur.next;
            pCur.next = tmp.next;
            pCur = tmp;
        }
        return head;
    }
}
