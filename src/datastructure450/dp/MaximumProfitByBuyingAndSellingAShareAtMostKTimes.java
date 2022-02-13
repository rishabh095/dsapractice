package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

public class MaximumProfitByBuyingAndSellingAShareAtMostKTimes {
    public static void main(String[] args) {
        int[] arr = {2, 30, 15, 10, 8, 25, 80};//{10, 22, 5, 75, 65, 80};
        int k = 2;
        System.out.println(maxProfit(arr, arr.length, k));
        System.out.println(maxProfitBetterSolution(arr, arr.length, k));
    }

    // O(k*n) time complexity and O(k*n) space complexity
    private static int maxProfitBetterSolution(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(dp[i - 1][j - 1] - arr[j - 1], prevDiff);
                dp[i][j] = Math.max(prevDiff + arr[j], dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }

    // O(k*n^2) time complexity and O(k*n) space complexity
    private static int maxProfit(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int maxSoFar = 0;
                for (int m = 0; m < j; m++)
                    maxSoFar = Math.max(maxSoFar, arr[j] - arr[m] + dp[i - 1][m]);
                dp[i][j] = Math.max(maxSoFar, dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}
