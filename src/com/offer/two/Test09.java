package com.offer.two;

import java.util.Scanner;

public class Test09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入台阶数：");
        int n = sc.nextInt();
        System.out.println("跳法数：");
        System.out.println(jumpFloor2(n));
    }

    public static int jumpFloor(int target){
        return (int)Math.pow(2, target - 1);
    }

    public static int jumpFloor2(int target){
        if(target <= 0){
            return -1;
        }
        if(target == 1){
            return 1;
        }
        return 2 * jumpFloor2(target - 1);

    }

}
