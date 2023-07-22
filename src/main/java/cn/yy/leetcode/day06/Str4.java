package cn.yy.leetcode.day06;

public class Str4 {
    public static void main(String[] args) {
        String www = "aba";
        System.out.println(reverseStr(www, 2));
    }
/*
给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。

如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
    public static String reverseStr(String s,int k) {
        if (s.length()<=k){
            return reverse(s);
        }
        StringBuilder r = new StringBuilder();
        for (int i=0;i<s.length();i+=2*k){
            String pre = reverse(s.substring(i, i + k));
            if (i+3*k>=s.length()){
                r.append(pre).append(s.substring(i + k));
                break;
            }
            r.append(pre).append(s, i + k, i+2 * k);
        }
        return r.toString();
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i=0,j=chars.length-1;i<j;i++,j--){
            swap(chars,i,j);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

}
