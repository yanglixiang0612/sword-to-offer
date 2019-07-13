package com.heima.test;

import java.util.Scanner;

public class Test02 {

    /*问题：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
    则经过替换之后的字符串为We%20Are%20Happy。*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = input.nextLine();
        StringBuffer str = new StringBuffer(s);
        System.out.println(replaceSpace(str));
    }
    //方法一：
	/*
	问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
	问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
	       从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下；
	       从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
	*/
    public static String replaceSpace(StringBuffer str) {
        int spaceNum = 0;                                //计算空格数
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int indexold = str.length() - 1;                //indexold为替换前str的下标
        int newlength = str.length() + 2 * spaceNum;    //newlength为转换后str的长度
        int indexnew = newlength - 1;                   //indexnew为转换后str的下标
        str.setLength(newlength);                       //使str原来的长度扩大到转换后的长度，防止下标越界
        for(;indexold >= 0;--indexold) {  //此处--indexold与indexold--一样
            if(str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else {
                str.setCharAt(indexnew--, str.charAt(indexold));  //此处--indexnew与indexnew--不同
            }
        }
        return str.toString();
    }
    //方法二：
    public static String replaceSpace1(StringBuffer str) {
        String s = str.toString();
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                sb.append("%20");
            }else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
