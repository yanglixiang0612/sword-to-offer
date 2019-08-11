//问题：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。    (https://www.cnblogs.com/gl-developer/p/6438311.html)
package com.offer.one;

import java.util.ArrayList;

//ListNode类
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {

        this.val = val;
    }
}
public class Test03 {

    //法一1：解题思路：创建两个ArrayList，一个用来根据传进来的ListNode参数新建
    //一个完整的ArrayList，另一个用来存储反转后的ArrayList。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if(listNode == null) {
            System.out.print("输入链表为null");
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return	result;
    }

    //法一2：
    public static void printListFromTailToHeadByArrayList(ListNode node){
        if(node==null) {
            System.out.print("输入链表为null");
        }
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while(node!=null){
            arrayList.add(node.val);
            node=node.next;
        }
        for(int i=arrayList.size()-1;i>=0;i--){
            System.out.print(arrayList.get(i)+",");
        }
    }

    //法二：递归   思路： (https://blog.csdn.net/qq_29519041/article/details/81487151)
    //递归的点在printListFromTailToHaed(listNode.next)这个节点，那么在最后一次
    //递归方法返回以后，每一层的递归方法都会做一个arrayList.add(lizxstNode.val)这
    //个操作，从最后一次到第一次，逆向的调用了后面的方法。因为之前的递归点已经返回了。这个
    //你用栈的模型考虑下.

    //递归的小问题：当链表非常长时，就会使递归的层级很深，从而有可能导致函数调用栈溢出。显
    //示用栈基于循环实现代码的鲁棒性要好一些。
/*package com.heima.test;

import java.util.ArrayList;

    public class Test {

        public static void main(String[] args) {
            ListNode node1=new ListNode(1);
            ListNode node2=new ListNode(2);
            ListNode node3=new ListNode(3);
            ListNode node4=new ListNode(4);
            node1.next=node2;
            node2.next=node3;
            node3.next=node4;

            ArrayList<Integer> list = printListFromTailToHead1(node1);    //递归1
            for (int i = 0; i <= list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            System.out.println("-------");

            printListReverseinglyByRecursion(node1);                     //递归2
        }*/

        /*//递归1:
        static ArrayList<Integer> arrayList = new ArrayList<>();
        public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
            if(listNode != null){
                printListFromTailToHead1(listNode.next);
                arrayList.add(listNode.val);      //到最后一个节点的时候开始存储数据到arrayList中，从尾到头储存
            }
            return arrayList;
        }

        //递归2: 因为栈的本质就是一个递归，所以递归也可以实现链表倒着输出，即每访问到一个结点的时候，
        //先递归输出它后面的结点，再输出该结点自身，这样链表的结果就反过来了。
        public static void printListReverseinglyByRecursion(ListNode listNode){
            if(listNode!=null){
                if(listNode.next!=null){
                    printListReverseinglyByRecursion(listNode.next);
                }
                System.out.print(listNode.val + " ");
            }else{
                System.out.println("输入的链表为空");
            }
        }


    }*/


    //法三1：利用栈实现的思路  (https://www.jianshu.com/p/c56415d5dd98)
    /*public class Solution2 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> temp = new Stack<>(); //建立一个栈
            ArrayList<Integer> newList = new ArrayList<>();
            ListNode t = listNode;
            //将数据都先存入栈中
            while(t != null){
                temp.push(t.val);
                t = t.next;
            }
            //遍历栈
            while(!temp.isEmpty()){
                newList.add(temp.pop());
            }
            return newList;
        }

        //法三2：通过使用栈结构，遍历链表，把先遍历的节点的值推入栈中，遍历结束后通过弹出栈内元素实现逆序打印.
        public static void printListReversinglyByStack(ListNode listNode){
            if(listNode == null){                                 //如果为空，直接返回
                return;
            }
            Stack<Integer> stack = new Stack<Integer>();          //借助于栈
            while(listNode!=null){
                stack.push(listNode.val);                         //将数据放入栈中
                listNode = listNode.next;                         //指针域指向下一个指针
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");              //借助于栈输出
            }
        }
    }*/
}
