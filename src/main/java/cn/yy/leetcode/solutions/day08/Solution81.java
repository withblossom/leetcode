package cn.yy.leetcode.solutions.day08;

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution81 {

    static List<String> list = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        list.clear();
        restoreIpAddresses(new StringBuilder(s), 3, 0);
        return list;
    }

    public static void restoreIpAddresses(StringBuilder s, int k, int start) {
        if (k == 0) {
            if (isValid(s,start,s.length())) {
                list.add(s.toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isValid(s,start,i+1)) {
                s.insert(i + 1, '.');
                restoreIpAddresses(s, k - 1, i + 2);
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }
    public static boolean isValid(StringBuilder s, int start, int end) {
        if (start >= end) {
            return false;
        }
        if (s.charAt(start) == '0' && start + 1 != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            num=num*10+(c-'0');
            if (num>255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(restoreIpAddresses("25525511135"));
//        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("2736786374048"));
    }
}

