package cn.yy.leetcode.solutions.day01;

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1： 输入：s = "We are happy."
输出："We%20are%20happy."
 */
public class Solution9 {
    public static String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' '){
                builder.replace(i,i+1,"%20");
            }
        }
        return builder.toString();
    }

    public static String replaceSpace1(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                len+=2;
            }
            len++;
        }
        char[] chars = new char[len];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                chars[--len] = '0';
                chars[--len] = '2';
                chars[--len] = '%';
            }else {
                chars[--len] = s.charAt(i);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpace("wd wdw  wdwd "));
        System.out.println(replaceSpace1("w "));
    }
}
