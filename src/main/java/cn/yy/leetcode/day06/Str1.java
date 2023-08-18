package cn.yy.leetcode.day06;

public class Str1 {
    public static void main(String[] args) {
        System.out.println(strStr("aabaabaaf", "aaf"));
    }

    /*
    实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
如果不存在，则返回  -1。
     */
    public static int strStr(String hayStack,String needle){
        if (needle.length()==0){
            return 0;
        }
        if (hayStack.length()<needle.length()){
            return -1;
        }
//        aabaabaaf
//        aabaaf
        int[] next = new int[needle.length()];
        getNext(next,needle);
        int j=0;
        for (int i=0;i<hayStack.length();i++){
            while (j>0&&hayStack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if (hayStack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static void getNext(int[] next,String needle){
        int j=0;
        next[j]=0;
        for (int i=1;i<needle.length();i++){
            while (j>0&&needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if (needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i]=j;
        }
    }
}
