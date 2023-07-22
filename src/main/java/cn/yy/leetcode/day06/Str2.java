package cn.yy.leetcode.day06;

import java.util.Arrays;

public class Str2 {
    public static void main(String[] args) {
        String www = "abcdefg";
        System.out.println(reverse(www));

    }

    /*
    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     */
    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i=0,j=chars.length-1;i<j;i++,j--){
            swap(chars,i,j);
        }
        return Arrays.toString(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
