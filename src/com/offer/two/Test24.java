package com.offer.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test24 {
    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    ArrayList<Integer> list  = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        help(root, target);
        Collections.sort(listAll, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return listAll;
    }

    public void help(TreeNode root, int target) {
        if(root == null){
            return;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);
    }
}
