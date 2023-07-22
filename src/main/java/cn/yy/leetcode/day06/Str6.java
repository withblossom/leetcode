package cn.yy.leetcode.day06;

public class Str6 {
    public static void main(String[] args) {
        String s = " wdwd wd   w ";
        StringBuilder builder = removeSpace(s);
        reverseEachWord(builder);
        System.out.println(builder.toString());
    }

    /*
        给定一个字符串，逐个翻转字符串中的每个单词。

     */
//    public static String reverseWords(String s) {
//        s = reverse(s);
//        int start = 0,end=s.length()-1;
//        while (s.charAt(start)==' '){
//            start++;
//        }
//        while (s.charAt(end)==' '){
//            end--;
//        }
//        StringBuilder builder = new StringBuilder();
//        int i=start+1;
//        while (start<=end){
//            if (i<end&&s.charAt(i)!=' '){
//                i++;
//            }
//            if (s.charAt(i)==' ') {
//                builder.append(reverse(s.substring(start, i)));
//                start=i+1;
//                builder.append(' ');
//            }else {
//                builder.append(reverse(s.substring(start)));
//                break;
//            }
//
//        }
//        return builder.toString();
//    }

    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start=0,end=1;
        while (start<=sb.length()-1){
            while (end<=sb.length()-1&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
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
