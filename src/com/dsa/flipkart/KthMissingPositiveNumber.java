package com.dsa.flipkart;

// https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        int k=7;
        System.out.println(findKthPositive(arr,k));
    }

    private static int findKthPositive(int[] arr, int k) {
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]-mid-1<k)
                start=mid+1;
            else
                end=mid-1;
        }
        return start+k;
    }
}
