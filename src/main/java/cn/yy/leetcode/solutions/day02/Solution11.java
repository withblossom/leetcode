package cn.yy.leetcode.solutions.day02;

/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：
输入: s = "abcdefg", k = 2
输出: "cdefgab"

示例 2：
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

限制：
1 <= k < s.length <= 10000
 */
public class Solution11 {

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        //整体翻转,把前n个数放后面去
        reverse(chars, 0, chars.length);
        //把前chars.length - n 个字符再翻转（回正）
        reverse(chars, 0, chars.length - n);
        //把后 n 个字符再翻转（回正）
        reverse(chars, chars.length - n, chars.length);
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
