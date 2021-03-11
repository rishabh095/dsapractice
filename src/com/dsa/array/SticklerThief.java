package com.dsa.array;

/*
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.
Example 1:
Input:
n = 6
a[] = {5,5,10,100,10,5}
Output: 110
Explanation: 5+100+5=110

Example 2:
Input:
n = 3
a[] = {1,2,3}
Output: 4
Explanation: 1+3=4
Your Task:
Complete the function FindMaxSum() which takes an array arr[] and n as input which returns the maximum money he can get following the rules

*/

public class SticklerThief {
    public static void main(String[] args) {
        int[] array = {5, 5, 10, 100, 10, 5};
        System.out.println(FindMaxSumNoConsecutiveEfficientSolution(array, array.length));
        System.out.println(FindMaxSumNoConsecutiveDP(array, array.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int FindMaxSumNoConsecutiveEfficientSolution(int[] array, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return array[0];
        if (n == 2)
            return Math.max(array[0], array[1]);
        int exclude = array[0];
        int excludeMax = Math.max(array[0], array[1]);
        int currMax = 0;
        for (int i = 2; i < n; i++) {
            currMax = Math.max(array[i] + exclude, excludeMax);
            exclude = excludeMax;
            excludeMax = currMax;
        }
        return currMax;
    }

    // DP approach
    // O(n) time complexity and O(n) space complexity
    private static int FindMaxSumNoConsecutiveDP(int[] array, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return array[0];
        if (n == 2)
            return Math.max(array[0], array[1]);
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);
        return dp[n - 1];
    }
}
