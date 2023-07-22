package cn.yy.leetcode.day06;

public class Str5 {
    public static void main(String[] args) {
        String s = " wdwd wd w";
        System.out.println(replaceSpace(s));
    }

    /*
        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

     */
    public static String replaceSpace(String s) {

        int len=s.length();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                len+=2;
            }
        }
        StringBuilder builder = new StringBuilder(len);
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                builder.append("%20");
            }else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
