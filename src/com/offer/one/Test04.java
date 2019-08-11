package com.offer.one;

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int data){
        this.data = data;
    }
}

public class Test04 {
    //问题：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历
    //和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历
    //序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

		/*思路： 利用递归的思想，每次都让得到一个根节点，然后让根节点指向其左右节点。左右节点
		        有分别有自己的根节点。一次类推，递归到最后没有左右节点为止为出口。

		1. 前序数组中最左边的值就是树的头节点值，记为h，并用h生成头节点，记为head。然后在中
		   序数组中找到h，假设位置是i。那么在中序数组中，i左边的数组就是头节点左子树的中序数组，
		   假设长度为l，则左子树的前序数组就是前序数组中h往右长度也为l的数组。
		2. 用左子树的前序和中序数组，递归整个过程建立左子树，返回的头节点记为left。
		3. i右边的数组就是头节点右子树的中序数组，假设长度为r。前序数组中右侧等长的部分就是头节点右子树的前序数组。
		4. 用右子树的前序和中序数组，递归整个过程建立右子树，返回的头节点记为right。
		5. 把head的左孩子和右孩子分别设为left和right，返回head，过程结束。
		   如果二叉树的节点数为N，在中序数组中找到位置i的过程可以用哈希表来实现，这样整个过程时间复杂度为O(N)。*/

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre > endPre || startIn > endIn) {
            return null;
        }

        //之所以要新建是因为通过递归返回时是返回结点！也就是跳出递归后从底层往上走，
        //最后走到头结点！每层的联系都是通过结点联系。
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn;i <= endIn;i++){
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}
