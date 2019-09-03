package com.offer.two;

import java.util.ArrayList;

public class Test33 {
    public static void main(String[] args) {
        Test33 t = new Test33();
        System.out.println(t.findUglyNumber(10));
    }

    //丑数
    public int findUglyNumber(int index){
        if(index <= 0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(list.size() < index){
            int n2 = list.get(i2) * 2;
            int n3 = list.get(i3) * 3;
            int n5 = list.get(i5) * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            list.add(min);
            if(min == n2){
                i2++;
            }
            if(min == n3){
                i3++;
            }
            if(min == n5){
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }


}
