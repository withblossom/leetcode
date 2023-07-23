package cn.yy.leetcode.day13;

import java.util.Arrays;

public class Solution1 {

    /*
    老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
示例 2:

输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
     */

    public static int candy(int[] ratings){
        int[] candies = new int[ratings.length];
        //先使所有孩子获得1个糖果
        Arrays.fill(candies,1);
        //检查大小
        //先从左到右，右边大于左边，则给右边加1个
        for (int i=1;i< ratings.length;i++){
            if (ratings[i]> ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        //从右到左
        for (int i= ratings.length-2;i>=0;i--){
            //保证第i个小孩的糖果数量既大于左边的也大于右边的
            if (ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
