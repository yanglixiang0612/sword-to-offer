package com.offer.two;

import java.util.Scanner;
import java.util.Stack;

public class Test21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arr1 = new int[m];
            int[] arr2 = new int[n];
            for (int i = 0; i < m; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextInt();
            }
            Test21 t = new Test21();
            boolean b = t.isPopOrder(arr1, arr2);
            System.out.println(b);

        }

    }


    public boolean isPopOrder(int[] pushA, int[] popA){
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int popIndex = 0;

        //保证先进后出的情况下，在入栈过程中可随时出栈（不用等栈满了再出栈）
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while(!s.empty() && s.peek() == popA[popIndex]){
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }

}
