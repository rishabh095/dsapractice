package datastructure450.dp;

// https://practice.geeksforgeeks.org/problems/cutted-segments1642/1

public class MaximizeTheCutSegments {
    public static void main(String[] args) {
        int n = 11, x = 2, y = 3, z = 5;
        System.out.println(findMaxCuts(n, x, y, z));
        System.out.println(findMaxCutsDP(n, x, y, z));
    }

    // O(n) time complexity and O(n) space complexity
    private static int findMaxCutsDP(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - x >= 0)
                dp[i] = Math.max(dp[i], dp[i - x]);
            if (i - y >= 0)
                dp[i] = Math.max(dp[i], dp[i - y]);
            if (i - z >= 0)
                dp[i] = Math.max(dp[i], dp[i - z]);
            if (dp[i] != -1)
                dp[i]++;
        }
        return dp[n] == -1 ? 0 : dp[n];
    }

    // O(3^n) time complexity and O(n) space complexity
    private static int findMaxCuts(int n, int x, int y, int z) {
        if (n == 0)
            return 0;
        if (n < -1)
            return -1;
        int result = Math.max(findMaxCuts(n - x, x, y, z),
                Math.max(findMaxCuts(n - y, x, y, z), findMaxCuts(n - z, x, y, z)));
        if (result == -1)
            return -1;
        return 1 + result;
    }
}
