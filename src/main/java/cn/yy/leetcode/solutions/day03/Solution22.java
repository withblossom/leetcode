package cn.yy.leetcode.solutions.day03;

/*
使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
 */


import java.util.ArrayDeque;
import java.util.EmptyStackException;

public class Solution22 {


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}

class MyStack {

    public ArrayDeque<Integer> nowStack;
    public ArrayDeque<Integer> tempStack;

    public MyStack() {
        nowStack = new ArrayDeque<>();
        tempStack = new ArrayDeque<>();
    }

    public void push(int x) {
        nowStack.addFirst(x);
    }

    public int pop() {
        while (!nowStack.isEmpty()){
            Integer val = nowStack.removeLast();
            if (nowStack.isEmpty()){
                switchData();
                return val;
            }
            tempStack.addFirst(val);
        }
        return nowStack.pop();
    }

    public int top() {
        while (!nowStack.isEmpty()){
            Integer val = nowStack.removeLast();
            tempStack.addFirst(val);
            if (nowStack.isEmpty()){
                switchData();
                return val;
            }
        }
        return nowStack.getFirst();
    }

    public void switchData() {
        ArrayDeque<Integer> temp = nowStack;
        nowStack = tempStack;
        tempStack = temp;
    }

    public boolean empty() {
        return nowStack.isEmpty();
    }
}