package datastructure450.dp;

// https://www.geeksforgeeks.org/longest-common-substring-dp-29/

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "OldSite:GeeksforGeeks.org";
        String str2 = "NewSite:GeeksQuiz.com";
        System.out.println(longestCommonSubstring(str1,str2,str1.length(),str2.length()));
    }

    // O(n*m) time complexity and O(n*m) time complexity
    private static int longestCommonSubstring(String str1, String str2, int n1, int n2) {
        int[][] dp=new int[n1+1][n2+1];
        int result=0;
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result=Math.max(result,dp[i][j]);
                }
            }
        }
        return result;
    }
}
