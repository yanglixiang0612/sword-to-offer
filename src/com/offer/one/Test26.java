package com.offer.one;

public class Test26 {

    //问题：(二叉搜索树与双向链表) 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
	/*思路：(递归)左-右-根
		1.将左子树构造成双链表，并返回链表头节点。
		2.定位至左子树双链表最后一个节点。
		3.如果左子树链表不为空的话，将当前root追加到左子树链表。
		4.将右子树构造成双链表，并返回链表头节点。
		5.如果右子树链表不为空的话，将该链表追加到root节点之后。
		6.根据左子树链表是否为空确定返回的节点。
	 */
    public TreeNode Convert(TreeNode root) {                //递归不好理解！
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = Convert(root.left);					// 1.将左子树构造成双链表，并返回链表头节点
        TreeNode p = left;
        while(p != null && p.right != null) {				// 2.定位至左子树双链表最后一个节点
            p = p.right;
        }
        if(p != null) {										// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
            p.right = root;
            root.left = p;
        }
                                                            //（先右子树构造成双链表，再连追加root节点！！！）
        TreeNode right = Convert(root.right);				// 4.将右子树构造成双链表，并返回链表头节点
        if(right != null) {								    // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
            right.left = root;
            root.right = right;
        }
        return left != null? left : root;      //倒数第二次循环时，left不变，p.right = root (p.right != null)
    }

    //法二：
    /*private TreeNode pLast = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;

        // 如果左子树为空，那么根节点root为双向链表的头节点
        TreeNode head = Convert(root.left);
        if (head == null)
            head = root;

        // 连接当前节点root和当前链表的尾节点pLast
        root.left = pLast;
        if (pLast != null)
            pLast.right = root;
        pLast = root;

        Convert(root.right);

        return head;
    }*/
}
