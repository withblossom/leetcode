package cn.yy.leetcode.day12;

import java.util.Arrays;

public class Solution1 {

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
