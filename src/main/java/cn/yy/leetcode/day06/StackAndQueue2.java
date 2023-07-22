package cn.yy.leetcode.day06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackAndQueue2 {
    public static void main(String[] args) {

        System.out.println(isValid("[]{}()"));
    }

    public static boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                list.push(')');
            } else if (c == '[') {
                list.push(']');
            } else if (c == '{') {
                list.push('}');
            } else if (list.isEmpty() || list.peek() != c) {
                return false;
            } else {
                list.pop();
            }
        }
        return list.isEmpty();
    }
}

