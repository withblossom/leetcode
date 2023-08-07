package cn.yy.leetcode.solutions.day07;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution73 {

    static String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    static List<String> list = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    // "345"
    public List<String> letterCombinations(String digits) {
        list.clear();
        if ("".equals(digits)) {
            return list;
        }
        letterCombinationsT(digits.toCharArray());
        return list;
    }

    public void letterCombinationsT(char[] chars) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }
        String letter = letterMap[chars[builder.length()] - '0'];
        for (int i = 0; i < letter.length() ; i++) {
            builder.append(letter.charAt(i));
            letterCombinationsT(chars);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {

    }
}


