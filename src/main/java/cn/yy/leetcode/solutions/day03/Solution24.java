package cn.yy.leetcode.solutions.day03;

/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */


import java.util.ArrayDeque;

public class Solution24 {

    public static String removeDuplicates(String s) {
        //栈
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 栈顶字符 与 待处理字符相等，消除（弹栈）
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            //不相等，入栈
            } else {
                stack.push(c);
            }
        }
        // 集合（栈）转 StringBuilder，反转，然后返回
        return stack.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .reverse()
                .toString();
    }

    public static void main(String[] args) {


    }
}
