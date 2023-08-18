package cn.yy.leetcode.solutions.day02;

/*
给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Solution10 {

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int start = 0;
        while (i<chars.length){
            //单词前空格，跳过
            while (i<chars.length&&chars[i] == ' '){
                i++;
            }
            //碰到单词
            if (i< chars.length && chars[i] != ' '){
                //记录单词起始位置
                start = i;
                i++;
                //直接跳到单词尾部后一个
                while (i< chars.length && chars[i] != ' '){
                    i++;
                }
            }
            //空格，或者字符串尾部，翻转单词
            if (i<= chars.length){
                reverse(chars,start,i);
            }
        }
        return new String(chars);
    }
    //翻转chars数组中 [start - end） 的字符，左闭右开
    public static void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {

    }
}
