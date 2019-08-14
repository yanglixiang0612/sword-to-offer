package com.offer.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Test19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println();

             for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(i == 0 || i == 1){
                        System.out.print(arr[i][j] + "     ");
                    }else if(i == 2 || i == 3) {
                        if (i == 2 && j == 0){
                            System.out.print(arr[i][j] + "     ");
                        }else{
                            System.out.print(arr[i][j] + "    ");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();

            Test19 t = new Test19();
            ArrayList<Integer> list = t.printMatrix(arr);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return list;
        }
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(top < down || left < right){
            for (int j = left; j <= right && top <= down; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= down && left <= right; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int j = right; j >= left && top <= down; j--) {
                list.add(matrix[down][j]);
            }
            down--;
            for (int i = down; i >= top && left <= right; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
