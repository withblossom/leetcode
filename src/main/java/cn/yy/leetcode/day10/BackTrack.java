package cn.yy.leetcode.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BackTrack {



    static List<List<Integer>> lists = new LinkedList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    static List<String> lists1 = new LinkedList<>();
    static StringBuilder builder = new StringBuilder();

    public static void backtracking(int n,int k,int start)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                {
        if (list.size()==k){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=start;i<=n-(k - list.size())+1;i++){
            list.addLast(i);
            backtracking(n,k,i+1);
            list.removeLast();
        }
    }

    public static void combinationSum3(int n,int k,int start){
        if (list.size()==k){
            if (n==0) {
                lists.add(new LinkedList<>(list));
            }
            return;
        }
        for (int i=start;i<=9-(k-list.size())+1;i++){
            if (n-i<0){
                return;
            }
            list.addLast(i);
            combinationSum3(n-i,k,i+1);
            list.removeLast();
        }
    }

    static final String[] letterMap = {
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
    public static void letterCombinations(String str,int index){
        if (builder.length()== str.length()){
            lists1.add(builder.toString());
            return;
        }
        for (int i=index;i<str.length();i++){
            int digit = Character.digit(str.charAt(i), 36);
            for (char c1 : letterMap[digit].toCharArray()) {
                builder.append(c1);
                letterCombinations(str,i+1);
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }

    public static void combinationSum(int[] nums,int target,int start){
        if (target==0){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=start;i<nums.length;i++) {
            int num = nums[i];
            if (target-num<0){
                continue;
            }
            list.addLast(num);
            combinationSum(nums,target-num,i);
            list.removeLast();
        }
    }

    public static void combinationSum2(int[] nums,int target,int start){
        if (target==0){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=start;i< nums.length;i++){
            if (target-nums[i]<0){
                return;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            list.addLast(nums[i]);
            combinationSum2(nums,target-nums[i],i+1);
            list.removeLast();
        }
    }

    static List<List<String>> lists2 = new LinkedList<>();
    static LinkedList<String> list2 = new LinkedList<>();

    public static void partition(String str,int start){
        if (start>=str.length()){
            lists2.add(new LinkedList<>(list2));
            return;
        }
        for (int i=start;i<str.length();i++){
            if (isSymmetric(str, start, i)) {
                String s = str.substring(start, i + 1);
                list2.addLast(s);
                partition(str, i + 1);
                list2.removeLast();
            }
        }
    }

    public static List<List<String>> partition(String str){
        partition(str,0);
        return lists2;
    }

    private static boolean isSymmetric(String str, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        letterCombinations("23",0);
//        System.out.println(lists1);

//        combinationSum(new int[]{2,3,6,7},7,0);
//        System.out.println(lists);

//        combinationSum(new int[]{1,1,2},3,0);
//        System.out.println(lists);

//        partition("aba",0);
//        System.out.println(lists2);
        String wd = "w";
        System.out.println(wd.substring(1));

    }


}
