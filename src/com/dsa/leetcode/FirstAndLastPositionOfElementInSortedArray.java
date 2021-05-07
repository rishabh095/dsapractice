package com.dsa.leetcode;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(new int[]{searchRange(arr,target,true),searchRange(arr,target,false)}));
    }

    private static int searchRange(int[] arr, int target,boolean first) {
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                if(first)
                    end=mid-1;
                else
                    start=mid+1;
            }else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return ans;
    }
}
