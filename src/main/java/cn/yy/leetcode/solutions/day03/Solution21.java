package cn.yy.leetcode.solutions.day03;

/*
使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
 */


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Solution21 {


    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

class MyQueue {

    public ArrayDeque<Integer> inStack;
    public ArrayDeque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        switchData();
        return outStack.pop();
    }

    public int peek() {
        switchData();
        return outStack.peek();
    }

    public void switchData() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}