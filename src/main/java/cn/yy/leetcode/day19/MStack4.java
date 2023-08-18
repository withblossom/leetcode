package cn.yy.leetcode.day19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MStack4 {
    /*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */

    public static int trap1(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int volumn = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                //若栈中还有元素，则原来未弹栈时，栈中元素与外面元素(height[i]) 形成一个凹
                //此时可求雨水体积
                if (!stack.isEmpty()) {
                    int dis = i - stack.peek() - 1;
                    int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                    if (h > 0)
                        volumn += h * dis;
                }
            }
            stack.push(i);
        }
        return volumn;
    }

    public static int trap2(int[] height) {
        if (height.length <= 2) return 0;
        int volumn = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lheight = height[i];
            int rheight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                lheight = Math.max(lheight, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                rheight = Math.max(rheight, height[j]);
            }
            int h = Math.min(lheight, rheight) - height[i];
            if (h > 0) volumn += h;
        }
        return volumn;
    }

    public static int trap3(int[] height) {
        int volumn = 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        // 记录每个柱子左边柱子最大高度
        maxL[0] = height[0];
        for (int i = 1; i < maxL.length; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }
        // 记录每个柱子右边柱子最大高度
        maxR[maxR.length - 1] = height[height.length - 1];
        for (int i = maxR.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(maxL[i], maxR[i]) - height[i];
            if (temp > 0) volumn += temp;
        }
        return volumn;
    }

    public static void main(String[] args) {
        System.out.println(trap1(new int[]{3, 0, 1, 0, 2}));
        System.out.println(trap2(new int[]{3, 0, 1, 0, 2}));
        System.out.println(trap3(new int[]{3, 0, 1, 0, 2}));
    }
}

