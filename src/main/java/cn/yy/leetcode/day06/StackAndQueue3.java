package cn.yy.leetcode.day06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class StackAndQueue3 {
    public static void main(String[] args) {
        int[] nums={5,4,3,2,1,2,3,4,5};
        int[] ints = maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];
        int ind=0;
        Queue3 queue3 = new Queue3(k);
        for (int i=0;i<k;i++){
            queue3.push(nums[i]);
        }
        r[ind++]= queue3.front();
        for (int i=k;i< nums.length;i++){
            queue3.push(nums[i]);
            r[ind++]= queue3.front();
        }
        return r;
    }

}

class Queue3{

    int k;
    Deque<Integer> queue = new ArrayDeque<>(k);

    public Queue3(int k) {
        this.k = k;
    }

    public void push(Integer val){
        if (queue.isEmpty()) {
            queue.push(val);
        }else {
            while (!queue.isEmpty()&&val>= queue.peekLast()){
                queue.pop();
            }
            if (queue.size()==k){
                queue.pop();
            }
            queue.addLast(val);
        }
    }
    public Integer front(){
        return queue.peek();
    }
}



