package com.heima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test24 {
    //问题：(二叉树中和为某一值的路径) 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始
    //往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前).
	/*思路:核心思想：递归，回溯法（求解多个合法路径）
	思路：
    	1.判断根节点是否为null； 是：返回null；
    	2.集合list添加根节点的值；
    	3.target减去根节点的值；
    	4.判断target是否等于0，当前节点的左右孩子节点是否为null； 是：集合listAll添加集合list（找到一条路径）；
    	5.在根节点的左孩子节点下寻找；
    	6在根节点的右孩子节点下寻找；
    	7.集合list移除最后一个元素，回溯到最近父节点，继续寻找下一条路径；

	 */
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode2 root,int target) {
        help(root, target);
        Collections.sort(listAll, new Comparator<ArrayList<Integer>>() {      //排序
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return listAll;
    }

    public void help(TreeNode2 root, int target){
        if(root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        //return listAll;
    }
}
