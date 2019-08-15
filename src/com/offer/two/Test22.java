package com.offer.two;

import java.util.ArrayList;

public class Test22 {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printTreeFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null){
            return null;
        }
        queue.add(root);
        while(queue.size() != 0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

}
