package com.dsa.array;

/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
Example 1:
Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which
is a contiguous subarray.

Example 2:
Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1
of element (-1)

Your Task:
You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes arr and N as input parameters and returns the sum of subarray with maximum sum.
*/

public class ContiguousSubArrayWithMaximumSum {
    public static void main(String[] args) {
        int[] array = {-1, -2, -3, -4};//{1, 2, 3, -2, 5};
        System.out.println(maxSubArraySum(array, array.length));
    }

    // Kadane's Algorithm
    // O(n) time complexity and O(1) space complexity
    private static int maxSubArraySum(int[] array, int n) {
        int maxSumEnding = 0, maxSumSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSumEnding += array[i];
            maxSumSoFar = Math.max(maxSumEnding, maxSumSoFar);
            if (maxSumEnding < 0)
                maxSumEnding = 0;
        }
        return maxSumSoFar;
    }
}
