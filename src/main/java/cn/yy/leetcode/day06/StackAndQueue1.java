package cn.yy.leetcode.day06;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class StackAndQueue1 {
    public static void main(String[] args) {
        Stack1 queue = new Stack1();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peak());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peak());
        System.out.println(queue.peak());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}

class Stack1{

    public Deque<Integer> queue = new ArrayDeque<>();
    public Deque<Integer> fallQueue = new ArrayDeque<>();

    public void push(Integer val){
        queue.push(val);
    }
    public Integer pop(){
        Integer r;
        if (!queue.isEmpty()){
            while (true){
                r= queue.pollLast();
                if (!queue.isEmpty()) {
                    fallQueue.push(r);
                }else {
                    swap();
                    return r;
                }
            }
        }
        return null;
    }
    private void swap(){
        Deque<Integer> temp=queue;
        queue=fallQueue;
        fallQueue=temp;
    }
    public Integer peak(){
        Integer r = pop();
        if (r==null){
            return null;
        }
        queue.push(r);
        return r;
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}

class Queue1{

    public Deque<Integer> inStack = new ArrayDeque<>();
    public Deque<Integer> outStack = new ArrayDeque<>();

    public void push(Integer val){
        inStack.push(val);
    }
    public Integer pop(){
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.poll();
    }
    public Integer peak(){
        Integer pop = pop();
        outStack.push(pop);
        return outStack.peek();
    }
    public boolean isEmpty(){
        return inStack.isEmpty()&& outStack.isEmpty();
    }
}
