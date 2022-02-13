package datastructure450.dp;

// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(findLCS(str1, str2, str1.length(), str2.length()));
        System.out.println(findLCSDP(str1, str2, str1.length(), str2.length()));
        System.out.println(findLCSDPSpaceOptimized(str1, str2, str1.length(), str2.length()));
    }

    // O(n*m) time complexity and O(m) time complexity
    private static int findLCSDPSpaceOptimized(String str1, String str2, int n, int m) {
        int[][] dp = new int[2][m + 1];
        int binaryIndex = 0;
        for (int i = 1; i <= n; i++) {
            binaryIndex = i & 1;
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[binaryIndex][j] = 1 + dp[1 - binaryIndex][j - 1];
                else
                    dp[binaryIndex][j] = Math.max(dp[1 - binaryIndex][j], dp[binaryIndex][j - 1]);
            }
        }
        return dp[binaryIndex][m];
    }

    // O(n*m) time complexity and O(n*m) time complexity
    private static int findLCSDP(String str1, String str2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    // O(2^n) time complexity and O(1) time complexity
    private static int findLCS(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            return 1 + findLCS(str1, str2, n - 1, m - 1);
        else
            return Math.max(findLCS(str1, str2, n - 1, m), findLCS(str1, str2, n, m - 1));
    }
}
