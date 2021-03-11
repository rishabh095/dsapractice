package com.dsa.leetcode;

// 322. Coin Change
// https://leetcode.com/problems/coin-change/

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeEfficientSolution(coins, amount));
    }

    // O(i * j) time complexity and O(n) space complexity
    private static int coinChangeEfficientSolution(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int res = dp[i - coins[j]];
                    if (res != Integer.MAX_VALUE && res + 1 < dp[i])
                    dp[i] = res + 1;
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }

    //time complexity is exponential (O(n^n))
    private static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int subRes = coinChange(coins, amount - coins[i]);
                if (subRes != Integer.MAX_VALUE && subRes + 1 < res)
                    res = subRes + 1;
            }
        }
        return res;
    }
}
