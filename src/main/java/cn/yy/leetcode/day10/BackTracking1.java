package cn.yy.leetcode.day10;

import java.util.LinkedList;
import java.util.List;

public class BackTracking1 {

    static List<String> list = new LinkedList<>();

    /*
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
     */
    public static void backTracking(StringBuilder s,int start,int dotNum){
        if (dotNum==3){
            if (isValid(s,start,s.length())){
                list.add(s.toString());
            }
            return;
        }
        for (int i=start;i<s.length();i++){
            if (isValid(s,start,i+1)){
                s.insert(i+1,'.');
                backTracking(s,i+2,dotNum+1);
                s.deleteCharAt(i+1);
            }else return;
        }
    }

    public static boolean isValid(StringBuilder s,int start,int end){
        if (start>=end){
            return false;
        }
        if (s.charAt(start)=='0'&&start+1!=end){
            return false;
        }
        for (int i=start;i<end;i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return Integer.parseInt(s.substring(start, end)) <= 255;
    }

    public static List<String> restoreIpAddresses(String s){
        backTracking(new StringBuilder(s),0,0);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("111111"));
    }
}
