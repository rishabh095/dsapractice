package com.dsa.flipkart;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

public class SumAllOddLengthSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubArrays(arr));
    }

    private static int sumOddLengthSubArrays(int[] arr) {
        return sum(arr, 0, arr.length - 1);
    }

    private static int sum(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];
        int sum = 0, runningSum = 0;
        for (int i = start; i <= end; i++) {
            runningSum += arr[i];
            if((i-start+1) %2 ==1)
                sum+=runningSum;
        }
        return sum+sum(arr,start+1,end);
    }
}
