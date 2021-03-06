package com.offer.two;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Test17 {

    public static void main(String[] args) {
        
    }
    
    public boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTree1HasTree2(root1, root2);
            }
            if(!result){
                result = hasSubTree(root1.left, root2);
            }
            if(!result){
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HasTree2(TreeNode node1, TreeNode node2) {
        if(node2 == null){
            return true;
        }
        if(node1 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return doesTree1HasTree2(node1.left, node2.left) && doesTree1HasTree2(node1.right, node2.right);
    }
}
