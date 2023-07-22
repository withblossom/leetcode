package cn.yy.leetcode.day06;

import java.util.*;
import java.util.stream.Collectors;

public class StackAndQueue4 {
    public static void main(String[] args) {
        int[] nums={5,11,11,11,22,22};
        int[] ints = topKFrequent2(nums, 2);
        System.out.println(Arrays.toString(ints));


    }

    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(k,(o1, o2) -> -Integer.compare(o1[1],o2[1]));

        for (Integer key : map.keySet()) {
            int[] d = new int[2];
            d[0]=key;
            d[1]=map.get(key);
            queue.add(d);
        }
        int[] r = new int[k];
        for (int i=0;i<k;i++){
            r[i]=queue.poll()[0];
        }
        return r;
    }

}



