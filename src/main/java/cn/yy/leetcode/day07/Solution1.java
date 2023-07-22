package cn.yy.leetcode.day07;//package cn.yy.leetcode.Solution;

import java.util.LinkedList;

/*
给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Solution1 {
    public static void main(String[] args) {
//        String adaadddda = "ad";
//        System.out.println(longestPalindrome1(adaadddda));

    }


    public static String longestPalindrome1(String s) {

        int max = Integer.MIN_VALUE;
        int count=0;
        String max_s ="";
        StringBuilder temp = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();
        for (int i =0;i<s.length();i++){
            if (list.isEmpty()){
                list.push(s.charAt(i));
                continue;
            }
            if (list.peek()==s.charAt(i)){
                count++;
                temp.append(list.poll());
            }else {
                list.push(s.charAt(i));
                if (count>max){
                    max_s= temp.toString();
                    max=count;
                }
                count=0;
                temp = new StringBuilder();
            }
        }
        char[] chars = max_s.toCharArray();
        for (int i=0,j=chars.length-1;i<j;i++,j--){
            char tempc=chars[i];
            chars[i]=chars[j];
            chars[j]=tempc;
        }
        String s1 = new String(chars);
        if (list.size()==1){
            s1+=list.pop();
        }
        s1+=max_s;
        return s1;
    }
}