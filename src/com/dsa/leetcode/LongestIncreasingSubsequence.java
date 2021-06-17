package com.dsa.leetcode;

// Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLISDPSolution(arr));
        System.out.println(lengthOfLISDPWithBinarySearchSolution(arr));
    }

    // O(n log n) time complexity
    private static int lengthOfLISDPWithBinarySearchSolution(int[] arr) {
        if (arr.length == 0)
            return 0;
        int[] tail = new int[arr.length];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[len - 1])
                tail[len++] = arr[i];
            else {
                int c = ceiling(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    private static int ceiling(int[] tail, int start, int end, int val) {
        while (end > start) {
            int m = start + (end - start) / 2;
            if (tail[m] >= val)
                end = m;
            else
                start = m + 1;
        }
        return end;
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int lengthOfLISDPSolution(int[] arr) {
        if (arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxSum = 1;
        for (int i = 1; i < arr.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    maxVal = Math.max(maxVal, dp[j]);
            }
            dp[i] = maxVal + 1;
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    // O(2^n) time complexity
    private static int lengthOfLIS(int[] arr) {
        return lengthOfLIS(arr, Integer.MIN_VALUE, 0);
    }

    private static int lengthOfLIS(int[] arr, int prev, int currPos) {
        if (currPos == arr.length)
            return 0;
        int taken = 0;
        if (arr[currPos] > prev)
            taken = 1 + lengthOfLIS(arr, arr[currPos], currPos + 1);
        int notTaken = lengthOfLIS(arr, prev, currPos + 1);
        return Math.max(taken, notTaken);
    }
}
