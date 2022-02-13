package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

public class MaximumProfitByBuyingAndSellingAShareAtMostTwice {
    public static void main(String[] args) {
        int[] arr = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(maxProfit(arr, arr.length));
        System.out.println(maxProfitBetterSolution(arr, arr.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int maxProfitBetterSolution(int[] arr, int n) {
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 0)
                maxProfit += arr[i] - arr[i - 1];
        }
        return maxProfit;
    }

    // O(n) time complexity and O(n) space complexity
    private static int maxProfit(int[] arr, int n) {
        int[] dp = new int[n];
        int maxProfit = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxProfit)
                maxProfit = arr[i];
            dp[i] = Math.max(dp[i + 1], maxProfit - arr[i]);
        }
        int minProfit = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minProfit)
                minProfit = arr[i];
            dp[i] = Math.max(dp[i - 1], dp[i] + (arr[i] - minProfit));
        }
        return dp[n - 1];
    }
}
