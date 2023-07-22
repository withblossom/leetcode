package cn.yy.leetcode.day06;

import java.util.Arrays;

public class Str3 {
    public static void main(String[] args) {
        String www = "abcdefg";
        System.out.println(reverseLeftWords(www, 2));
    }
/*

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
    public static String reverseLeftWords(String s,int k) {
        if (s.length()==0||s.length()==1){
            return s;
        }
        String pre = reverse(s.substring(0,k));
        System.out.println(pre);
        String suf = reverse(s.substring(k));
        System.out.println(suf);
        return reverse(pre+suf);
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i=0,j=chars.length-1;i<j;i++,j--){
            swap(chars,i,j);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

}
