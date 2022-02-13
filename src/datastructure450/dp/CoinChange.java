package datastructure450.dp;

// https://www.geeksforgeeks.org/coin-change-dp-7/

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int sum = 5;
        System.out.println(coinChange(arr, arr.length, sum));
        System.out.println(coinChangeDP(arr, arr.length, sum));
        System.out.println(coinChangeDPSpaceOptimized(arr, arr.length, sum));
    }

    // O(n*sum) time complexity and O(sum) space complexity
    private static int coinChangeDPSpaceOptimized(int[] arr, int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= sum; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[sum];
    }

    // O(n*sum) time complexity and O(n*sum) space complexity
    private static int coinChangeDP(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1])
                    dp[i][j] += dp[i][j - arr[i - 1]];
            }
        }
        return dp[n][sum];
    }

    // O(n^sum) time complexity and O(n) space complexity for recursion stack
    private static int coinChange(int[] arr, int n, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;
        return coinChange(arr, n - 1, sum) + coinChange(arr, n, sum - arr[n - 1]);
    }
}
