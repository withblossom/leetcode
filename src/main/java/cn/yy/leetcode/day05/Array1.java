package cn.yy.leetcode.day05;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] ints = {-1, 1, 2,2,2,2, 4};
        System.out.println(Arrays.toString(binarySearchArray(ints, 2)));
    }

    public static int binarySearch(int[] arr,int val){
        return binarySearchSingle(arr,val,0,arr.length);
    }
    public static int[] binarySearchArray(int[] arr,int val){
        return binarySearchArray(arr,val,0,arr.length);
    }
    public static int binarySearchSingle(int[] arr,int val,int left,int right){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if (val>arr[mid]){
            return binarySearchSingle(arr,val,mid+1,right);
        }
        if (val<arr[mid]){
            return binarySearchSingle(arr,val,left,mid);
        }
        return mid;
    }

    public static int[] binarySearchArray(int[] arr,int val,int left,int right){
        int[] r = new int[arr.length];
        Arrays.fill(r,-1);
        if (left>right){
            return r;
        }
        int mid=(left+right)/2;
        if (val>arr[mid]){
            return binarySearchArray(arr,val,mid+1,right);
        }
        if (val<arr[mid]){
            return binarySearchArray(arr,val,left,mid);
        }
        int le=mid-1,ri=mid+1;
        while (ri<=right&&val==arr[ri]){
            ri++;
        }
        while (le>=left&&val==arr[le]){
            le--;
        }
        for (int t=le+1,i=0;t<ri;t++,i++){
            r[i]=t;
        }
        return r;
    }
}
