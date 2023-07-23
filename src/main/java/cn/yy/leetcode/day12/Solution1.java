package cn.yy.leetcode.day12;

import java.util.Arrays;

public class Solution1 {

    /*
    假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值  g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

示例  1:

输入: g = [1,2,3], s = [1,1]
输出: 1 解释:你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。所以你应该输出 1。
示例  2:

输入: g = [1,2], s = [1,2,3]
输出: 2
解释:你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。你拥有的饼干数量和尺寸都足以让所有孩子满足。所以你应该输出 2.
提示：

1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1
     */

    //g[]  胃口， s[]  饼干
    public static int findContentChildren(int[] g,int[] s){
        //升序排列
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        //从头遍历饼干
        for (int j=0;i< g.length&&j< s.length;j++){
            //最小的饼干是否满足最小的胃口
            //不满足饼干换大一点的
            if (s[j]>=g[i]){
                i++;
            }
        }
        return i;
    }
    public static int findContentChildren1(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int i=s.length-1;
        //从尾遍历胃口
        for (int j= g.length-1;j>=0&&i>=0;j--){
            //最大的饼干是否满足最大的胃口
            //不满足胃口换小一点的
            if (s[i]>=g[j]){
                i--;
            }
        }
        return s.length-i-1;
    }
    public static void main(String[] args) {
        System.out.println(findContentChildren1(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren1(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
