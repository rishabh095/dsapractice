package datastructure450.string;

// https://www.geeksforgeeks.org/edit-distance-dp-5/

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "dbb";//"sunday";
        String str2 = "fdfaccddfac";//"saturday";
        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
    }

    // O(n*m) time complexity and O(n*m) space complexity
    private static int editDistDP(String str1, String str2, int n, int m) {
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
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[n][m];
    }

    // O(3^n) time complexity
    private static int editDist(String str1, String str2, int n, int m) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;
        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            return editDist(str1, str2, n - 1, m - 1);
        else
            return 1 + Math.min(editDist(str1, str2, n - 1, m - 1),
                    Math.min(editDist(str1, str2, n, m - 1), editDist(str1, str2, n - 1, m)));
    }
}
