package datastructure450.string;

// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

public class LongestCommonSubSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcsBetterSolution(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }

    // O(n*n) time complexity and O(n*n) space complexity
    private static int lcsBetterSolution(char[] s1, char[] s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    // O(2^n) time complexity
    private static int lcs(char[] s1, char[] s2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (s1[n - 1] == s2[m - 1])
            return 1 + lcs(s1, s2, n - 1, m - 1);
        else
            return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }
}
