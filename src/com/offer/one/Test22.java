package com.offer.one;

import java.util.ArrayList;

class TreeNode2{
    int val;
    TreeNode2 left = null;
    TreeNode2 right = null;
    public TreeNode2(int val){
        this.val = val;
    }
}

public class Test22 {
    //问题：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    //思路：二叉树的层次遍历么，借助一个队列就可以了, 用arraylist模拟一个队列来存储相应的TreeNode.
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode2 root){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode2> queue = new ArrayList<>();
        if(root == null) {
            return list;
        }
        queue.add(root);
        while(queue.size() != 0) {
            TreeNode2 temp = queue.remove(0);          //remove(0)删除queue的第一个元素并将其返回，模拟了队列的弹出操作
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
