package com.itheima.bean;

import java.util.Scanner;

public class Test005 {

    //(贝壳笔试)输入这个字符串最少需要按键多少次(aAAbB)

    /*方法一：
    flag1表示前一个字符的状态，true表示小写，false表示大写。
    flag2记录现在这个字符的状态，true表示小写，false表示大写。
    如果flag1！=flag2，则count++。
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int len = 0;
            int count = 0;
            boolean flag1 = true;
            boolean flag2 = true;
            String s = sc.nextLine();
            len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if(ch >= 'a' && ch <= 'z'){
                    flag2 = true;
                }else{
                    flag2 = false;
                }
                if(flag1 != flag2){
                    count++;
                    flag1 = flag2;
                }
            }
            System.out.println(count + len);
            System.out.println(count);
        }
    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int ans = line.length();
            boolean flag = false;

            for (Character ch : line.toCharArray()) {
                if (ch.isUpperCase(ch) && !flag) {
                    ans++;
                    flag = true;
                } else if(ch.isLowerCase(ch) && flag) {
                    ans++;
                    flag = false;
                }
            }

            System.out.println(ans);

        }
    }*/
}
