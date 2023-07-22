package cn.yy.leetcode.day05;

import cn.yy.leetcode.day04.LinkedNode;

/*
    给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class HashTable1 {
    public static void main(String[] args) {
        System.out.println(isAnagram("aees", "eaea"));
    }

    public static boolean isAnagram(String s,String b) {
        if (s.length()!=b.length()){
            return false;
        }
        int[] arr=new int[Math.max(s.length(), 26)];
        for (int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for (int i=0;i<b.length();i++){
            arr[b.charAt(i)-'a']--;
        }
        for (int j : arr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}

