package com.offer.two;

public class Test10 {

    public static void main(String[] args) {
        System.out.println(rectCover(7));
    }

    public static int rectCover(int target){
        int preTwo = 1;
        int preOne = 2;
        int num = 0;
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        for (int i = 3; i <= target; i++) {
            num = preTwo + preOne;
            preTwo = preOne;
            preOne = num;
        }
        return num;
    }
}
