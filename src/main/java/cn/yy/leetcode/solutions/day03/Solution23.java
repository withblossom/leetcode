package cn.yy.leetcode.solutions.day03;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution23 {

    public static boolean isValid(String s) {
        //栈
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                //出现朝左的括号，需要消除
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        // 栈空，说明全部消除，返回true
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
