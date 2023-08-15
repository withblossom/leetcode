package cn.yy.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        String s = "2*(5+123)";
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int start = 0;
        int index = indexOf(s, 0);
        while (index != -1) {
            String s1 = s.substring(start, index);
            if (!"".equals(s1)) {
                queue.addLast(s1);
            }
            char c = s.charAt(index);
            if (stack.isEmpty()) {
                stack.push(c + "");
            } else if (c == '(') {
                stack.push(c + "");
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (!pop.equals("(")) {
                        queue.addLast(pop);
                    } else {
                        break;
                    }
                }
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty()) {
                    String peek = stack.peek();
                    if (!"(".equals(peek)) {
                        queue.addLast(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(c + "");
            } else {
                while (!stack.isEmpty()) {
                    String peek = stack.peek();
                    if ("-".equals(peek) || "+".equals(peek)) {
                        queue.addLast(peek);
                    } else {
                        break;
                    }
                }
                stack.push(c + "");
            }
            start = index + 1;
            index = indexOf(s, start);
        }
        if (start < s.length()) {
            queue.addLast(s.substring(start));
        }
        while (!stack.isEmpty()) {
            queue.addLast(stack.pop());
        }
        System.out.println(queue);
    }

    public static int indexOf(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                return i;
            }
        }
        return -1;
    }
}
