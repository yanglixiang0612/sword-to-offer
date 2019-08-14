package com.offer.two;

public class Test18 {
    public static void main(String[] args) {

    }

    public  void mirror(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
    }

    public void mirror1(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirror1(root.left);
            mirror1(root.right);
        }
    }
}
