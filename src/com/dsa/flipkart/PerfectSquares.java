package com.dsa.flipkart;

import java.util.Arrays;

// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public static void main(String[] args) {
        int n=12;
        System.out.println(numSquares(n));
    }

    private static int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return leastNumber(n,dp);
    }

    private static int leastNumber(int n, int[] dp) {
        if(dp[n] !=-1)
            return dp[n];
        if(n==0)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int curr=leastNumber(n-i*i,dp)+1;
            min=Math.min(min,curr);
        }
        return dp[n]=min;
    }
}
