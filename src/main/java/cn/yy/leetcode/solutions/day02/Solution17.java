package cn.yy.leetcode.solutions.day02;

/*
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。
 */


public class Solution17 {


    //双指针
    //j 指向有效位置后一个，i指向当前位置
    public boolean backspaceCompare(String s, String t) {
        return re(s).equals(re(t));
    }

    //'#'相当于删除，这个函数用于解析字符串
    // 返回解析后的字符串
    public static String re(String s) {
        char[] chars = s.toCharArray();
        // j指向有效数据末尾
        int j = 0;
        int i = 0;
        //跳过一开始的'#'
        while (chars[i] == '#') {
            i++;
        }
        for (; i < s.length(); i++) {
            //碰到“删除号”
            if (chars[i] == '#') {
                //j指向有效数据末尾,若j为0，则表示没有有效数据,就没必要删除
                if (j != 0){
                    j--;
                }
            } else {
                //将有效数据移到数组前端，j+1
                chars[j++] = chars[i];
            }
        }
        return new String(chars, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(re("a##c"));
        System.out.println(re("#a#c"));
    }
}
