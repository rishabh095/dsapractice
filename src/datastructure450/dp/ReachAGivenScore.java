package datastructure450.dp;

// https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/

public class ReachAGivenScore {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(noOfWays(n));
    }

    private static int noOfWays(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] += dp[i - 3];
        for (int i = 5; i <= n; i++)
            dp[i] += dp[i - 5];
        for (int i = 10; i <= n; i++)
            dp[i] += dp[i - 10];
        return dp[n];
    }
}
