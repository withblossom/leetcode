package cn.yy.leetcode.solutions.day03;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */


import java.util.*;
import java.util.stream.Stream;

public class Solution27 {


    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map 在存放 元素 -》出现的频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 优点队列，按照频率大到小排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1[1],o2[1])));
        // 将map 中数据塞入 队列中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        // 取前 k 个
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = queue.poll()[0];
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 22, 3, 4, 3, 1,3}, 2)));
        PriorityQueue<Integer> queue = new PriorityQueue<>(3,Comparator.comparing(Integer::intValue));
        queue.add(1);
        queue.add(3);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
    }
}
