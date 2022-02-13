package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "AABEBCDD";//"axxxy";
        System.out.println(longestRepeatingSubsequence(str));
        System.out.println(printLongestRepeatingSubsequence(str));
    }

    // O(n*n) time complexity and O(n*n) space complexity
    private static String printLongestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=n,j=n;
        while(i>0 && j>0){
            if(dp[i][j]==dp[i-1][j-1]+1){
                sb.append(str.charAt(i-1));
                i--;
                j--;
            }else if(dp[i][j]==dp[i-1][j])
                i--;
            else
                j--;
        }
        return sb.reverse().toString();
    }

    // O(n*n) time complexity and O(n*n) space complexity
    private static int longestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
