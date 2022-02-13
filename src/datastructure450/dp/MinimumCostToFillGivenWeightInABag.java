package datastructure450.dp;

// https://www.geeksforgeeks.org/minimum-cost-to-fill-given-weight-in-a-bag/

import java.util.ArrayList;
import java.util.List;

public class MinimumCostToFillGivenWeightInABag {
    public static void main(String[] args) {
        int[] cost = {10, 4, 3, 4, 8};
        int weight = 5;
        System.out.println(MinimumCost(cost, cost.length, weight));
        System.out.println(MinimumCostSpaceOptimized(cost, weight));
    }

    // O(n*w) time complexity and O(n) space complexity
    private static int MinimumCostSpaceOptimized(int[] cost, int weight) {
        int[] dp = new int[weight + 1];
        dp[0] = 0;
        for (int i = 1; i <= weight; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j < cost.length && cost[j] != -1)
                    minCost = Math.min(minCost, cost[j] + dp[i - j - 1]);
            }
            dp[i] = minCost;
        }
        return dp[weight];
    }

    // O(n*w) time complexity and O(n*w) space complexity
    private static int MinimumCost(int[] cost, int n, int weight) {
        List<Integer> values = new ArrayList<>();
        List<Integer> weigths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                values.add(cost[i]);
                weigths.add(i + 1);
            }
        }
        n = values.size();
        int[][] dp = new int[n + 1][weight + 1];
        for (int i = 0; i <= weight; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (weigths.get(i - 1) > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], values.get(i - 1) + dp[i][j - weigths.get(i - 1)]);
            }
        }
        return dp[n][weight] == Integer.MAX_VALUE ? -1 : dp[n][weight];
    }
}
