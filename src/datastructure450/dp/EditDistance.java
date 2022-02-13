package datastructure450.dp;

// https://www.geeksforgeeks.org/edit-distance-dp-5/

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
        System.out.println(editDistanceDP(str1, str2, str1.length(), str2.length()));
    }

    // O(n*m) time complexity and O(n*m) space complexity
    private static int editDistanceDP(String str1, String str2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n][m];
    }

    // O(3^n) time complexity
    private static int editDistance(String str1, String str2, int n, int m) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;
        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            return editDistance(str1, str2, n - 1, m - 1);

        return 1 + Math.min(editDistance(str1, str2, n, m - 1),
                Math.min(editDistance(str1, str2, n - 1, m),
                        editDistance(str1, str2, n - 1, m - 1)));
    }
}
