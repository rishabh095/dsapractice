package com.dsa.flipkart;

//https://leetcode.com/problems/coin-change-2/

public class CoinChange2 {
    public static void main(String[] args) {
        int amount=5;
        int[] coins={1,2,5};
        System.out.println(change(amount,coins,coins.length));
        System.out.println(changeDP(amount,coins));
    }

    private static int changeDP(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=coins[i-1])
                    dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }

    private static int change(int amount, int[] coins,int length) {
        if(amount==0)
            return 1;
        if(amount<0)
            return 0;
        if (length <=0 && amount >= 1)
            return 0;
        return change(amount,coins,length-1)+change(amount-coins[length-1],coins,length);
    }
}
