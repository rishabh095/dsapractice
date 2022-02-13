package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/

public class MaximumSubsequenceSumSuchThatNoThreeAreConsecutive {
    public static void main(String[] args) {
        int[] arr = {100, 1000, 100, 1000, 1};
        System.out.println(findMaxSum(arr, arr.length));
    }

    // O(n) time complexity and O(n) space complexity
    private static int findMaxSum(int[] arr, int n) {
        int[] dp = new int[n];
        if (n >= 1)
            dp[0] = arr[0];
        if (n >= 2)
            dp[1] = arr[0] + arr[1];
        if (n >= 3)
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        for (int i = 3; i < n; i++)
            dp[i] = Math.max(dp[i - 2] + arr[i], Math.max(dp[i - 1], arr[i] + arr[i - 1] + dp[i - 3]));
        return dp[n - 1];
    }

}
