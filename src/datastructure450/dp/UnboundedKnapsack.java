package datastructure450.dp;

// https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int weight = 100;
        int[] value = {10, 30, 20};
        int[] wt = {5, 10, 15};
        System.out.println(unboundedKnapsack(weight, value, wt, value.length));
        System.out.println(unboundedKnapsackDP(weight, value, wt, value.length));
        System.out.println(unboundedKnapsackDPSpaceOptimized(weight, value, wt, value.length));
    }

    // O(n * weight) time complexity and O(weight) space complexity
    private static int unboundedKnapsackDPSpaceOptimized(int weight, int[] value, int[] wt, int n) {
        int[] dp = new int[weight + 1];
        for (int i = 0; i <= weight; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i)
                    dp[i] = Math.max(dp[i], value[j] + dp[i - wt[j]]);
            }
        }
        return dp[weight];
    }

    // O(n * weight) time complexity and O(n * weight) space complexity
    private static int unboundedKnapsackDP(int weight, int[] value, int[] wt, int n) {
        int[][] dp = new int[n + 1][weight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weight; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i][j - wt[i - 1]]);
            }
        }
        return dp[n][weight];
    }

    // O(2^n) time complexity
    private static int unboundedKnapsack(int weight, int[] value, int[] wt, int n) {
        if (weight == 0 || n == 0)
            return 0;
        if (wt[n - 1] > weight)
            return unboundedKnapsack(weight, value, wt, n - 1);
        else
            return Math.max(unboundedKnapsack(weight, value, wt, n - 1),
                    value[n - 1] + unboundedKnapsack(weight - wt[n - 1], value, wt, n));
    }
}
