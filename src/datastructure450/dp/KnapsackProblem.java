package datastructure450.dp;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] value = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        int capacity = 50;
        System.out.println(knapsackProblem(value, weight, capacity, value.length));
        System.out.println(knapsackProblemDP(value, weight, capacity, value.length));
    }

    // O(n*capacity) time complexity and O(n*capacity) space complexity
    private static int knapsackProblemDP(int[] value, int[] weight, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
            }
        }
        return dp[n][capacity];
    }

    // O(2^n) time complexity
    private static int knapsackProblem(int[] value, int[] weight, int capacity, int n) {
        if (capacity == 0 || n == 0)
            return 0;
        if (weight[n - 1] > capacity)
            return knapsackProblem(value, weight, capacity, n - 1);
        else
            return Math.max(knapsackProblem(value, weight, capacity, n - 1),
                    value[n - 1] + knapsackProblem(value, weight, capacity - weight[n - 1], n - 1));
    }
}
