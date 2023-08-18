package cn.yy.leetcode.solutions.day03;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

进阶：

你能在线性时间复杂度内解决此题吗？
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution26 {


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ints = new int[nums.length - k + 1];
        int index = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>(nums.length);
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addFirst(nums[i]);
        }
        ints[index++] = deque.getLast();
        for (int i = k; i < nums.length; i++) {
            if (deque.getLast() == nums[i - k]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && nums[i] > deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addFirst(nums[i]);
            ints[index++] = deque.getLast();
        }
        return ints;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        //存放结果的数组
        int[] ints = new int[nums.length - k + 1];
        //ints 中索引
        int index = 0;
        //优先队列（会自动按照你给的规则排序，这里是降序），存放int[2]{当前值，当前索引}
        PriorityQueue<int[]> queue = new PriorityQueue<>(2 * k, (o1, o2) -> -Integer.compare(o1[0], o2[0]));
        //前k 个数入队列
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        //先取第一个
        ints[index++] = queue.peek()[0];
        //接下来窗口右移
        for (int i = k; i < nums.length; i++) {
            //入列当前元素
            queue.add(new int[]{nums[i], i});
            //判断最大值是否在窗口左侧
            //是的话 就得去掉
            while (!queue.isEmpty()) {
                int[] ele = queue.peek();
                // index 还可以是左窗口索引，
                // 左窗口右移会产生一个最大值，结果数组就会多一个值
                if (ele[1] < index) {
                    queue.remove();
                } else {
                    break;
                }
            }
            //取值
            ints[index++] = queue.peek()[0];
        }
        return ints;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 5, 4, 3, 3, 6, 7}, 3)));
    }
}
