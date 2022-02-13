package datastructure450.dp;

// https://leetcode.com/problems/maximum-length-of-pair-chain/

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maximumLengthDP(arr, arr.length));
        System.out.println(maximumLengthBetterSolution(arr, arr.length));
    }

    // O(n log n) time complexity and O(1) space complexity
    private static int maximumLengthBetterSolution(int[][] arr, int n) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int index = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > arr[index][0]) {
                ans++;
                index = i;
            }
        }
        return ans;
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int maximumLengthDP(int[][] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][0] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
