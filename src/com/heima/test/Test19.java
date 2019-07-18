package com.heima.test;

import java.util.ArrayList;

public class Test19 {
    //问题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10
    //11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	/*思路：顺时针打印就是按圈数循环打印，一圈包含两行或者两列，在打印的时候会出现某一圈中只包含一行，要判断从左向右打印和从右向左打
	     印的时候是否会出现重复打印，同样只包含一列时，要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况。
	 */
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return list;
        }
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(top <= down || left <= right) {
            for(int j = left; j <= right && top <= down; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            for(int i = top; i <= down && left <= right; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for(int j = right; j >= left && top <= down; j--) {
                list.add(matrix[down][j]);
            }
            down--;
            for(int i = down; i >= top && left <= right; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
