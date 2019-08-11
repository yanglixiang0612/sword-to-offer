package com.offer.one;

class TreeNode1{
    int val;
    int data;
    TreeNode1 left = null;
    TreeNode1 right = null;
    public TreeNode1(int val){
        this.val = val;
    }
}
public class Test17 {
    //问题：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode1 root1, TreeNode1 root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {               //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
            if(root1.val == root2.val) {                   //如果找到了对应Tree2的根节点的点
                result = doesTree1HaveTree2(root1,root2);  //以这个根节点为为起点判断是否包含Tree2
            }
            if(!result) {                                  //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
                result = HasSubtree(root1.left, root2);
            }
            if(!result) {								   //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;                                     //返回结果
    }

    public boolean doesTree1HaveTree2(TreeNode1 node1, TreeNode1 node2) {
        if(node2 == null) {			                      //node2=null 表明tree2已经检测到了末尾，tree2为tree1的子结构
            return true;
        }
        if(node1 == null) {			                      //node1=null 表明tree1检测到了末尾，而tree2还没到末尾，则tree2不可能是tree1的子结构
            return false;
        }
        if(node1.val != node2.val) {                      //如果其中有一个点没有对应上，返回false
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);    //如果根节点对应的上，那么就分别去子节点里面匹配
    }
}
