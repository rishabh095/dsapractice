package datastructure450.dp;

// https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/

public class LongestCommonSubsequenceOfThreeStrings {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "geeksfor";
        String str3 = "geeksforgeeks";
        System.out.println(findLCS(str1, str2, str3, str1.length(), str2.length(), str3.length()));
    }

    // O(n*m*o) time complexity and O(n*m*o) space complexity
    private static int findLCS(String str1, String str2, String str3, int n, int m, int o) {
        int[][][] dp = new int[n + 1][m + 1][o + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= o; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)
                            && str1.charAt(i - 1) == str3.charAt(k - 1))
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    else
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }
        return dp[n][m][o];
    }
}
