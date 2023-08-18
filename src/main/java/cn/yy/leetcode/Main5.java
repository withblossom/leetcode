package cn.yy.leetcode;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        System.out.println(test("{0},{1}", new Object[]{"wdw","wwww"}));

    }

    public static String test(String template,Object[] args){
        int newLen = template.length();
        for (Object arg : args) {
            newLen = newLen + (arg+"").length() - 3;
        }
        char[] chars = new char[newLen];
        int index = 0;
        int aI  =  0;
        char[] charArray = template.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '{') {
                char[] array = (args[aI++] + "").toCharArray();
                System.arraycopy(array,0,chars,index,array.length);
                index += array.length;
                while (c!='}'){
                    c = charArray[++i];
                }
            }else {
                chars[index++] = c;
            }
        }
        return new String(chars);
    }
}
