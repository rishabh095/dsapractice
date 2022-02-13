package datastructure450.dp;

// https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/

public class InterleavedStrings {
    public static void main(String[] args) {
        String a = "AB";
        String b = "CD";
        String c = "ACBD";
        // if a and b don't have common character
        System.out.println(isInterleaved(a, b, c));
        String x = "XY";//"XXY";
        String y = "X";//"XXZ";
        String z = "XXY";//"XXZXXXY";
        // if a and b don't have common character
        System.out.println(isInterleavedDP(x, y, z));
        System.out.println(isInterleavedRecursive(x, y, z, x.length(), y.length(), z.length()));
    }

    // O(2^n) time complexity
    private static boolean isInterleavedRecursive(String x, String y, String z, int n1, int n2, int n3) {
        if (n1 == x.length() && n2 == y.length() && n3 == z.length())
            return true;
        if (n3 == z.length() || (n1 == x.length() && n2 == y.length()))
            return false;
        if (n1 == x.length())
            return y.charAt(n2) == z.charAt(n3) && isInterleavedRecursive(x, y, z, n1, n2 + 1, n3 + 1);
        if (n2 == y.length())
            return x.charAt(n1) == z.charAt(n3) && isInterleavedRecursive(x, y, z, n1 + 1, n2, n3 + 1);
        return ((x.charAt(n1) == z.charAt(n3) && isInterleavedRecursive(x, y, z, n1 + 1, n2, n3 + 1)) ||
                (y.charAt(n2) == z.charAt(n3) && isInterleavedRecursive(x, y, z, n1, n2 + 1, n3 + 1)));
    }

    // O(n*m) time complexity and O(n*m) space complexity
    private static boolean isInterleavedDP(String x, String y, String z) {
        int m = x.length();
        int n = y.length();
        if (n + m != z.length())
            return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0) {
                    if (y.charAt(j - 1) == z.charAt(j - 1))
                        dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    if (x.charAt(i - 1) == z.charAt(i - 1))
                        dp[i][j] = dp[i - 1][j];
                } else if (x.charAt(i - 1) == z.charAt(i + j - 1) &&
                        y.charAt(j - 1) != z.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (x.charAt(i - 1) != z.charAt(i + j - 1) &&
                        y.charAt(j - 1) == z.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (x.charAt(i - 1) == z.charAt(i + j - 1) &&
                        y.charAt(j - 1) == z.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    // This solution will work only if 2 character is same in a and b
    // O(m+n) time complexity and O(1) space complexity
    private static boolean isInterleaved(String a, String b, String c) {
        if (a.length() + b.length() != c.length())
            return false;
        int i = 0, j = 0, k = 0;
        while (k != c.length()) {
            if (i < a.length() && a.charAt(i) == c.charAt(k))
                i++;
            else if (j < b.length() && b.charAt(j) == c.charAt(k))
                j++;
            else
                return false;
            k++;
        }
        if (i < a.length() || j < b.length())
            return false;
        return true;
    }
}
