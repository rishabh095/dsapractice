package com.dsa.leetcodemaychallenge;

// https://leetcode.com/problems/ones-and-zeroes/

public class OnesAndZeroes {
    public static void main(String[] args) {
        String[] strs={"10","0001","111001","1","0"};
        int m=5,n=3;
        System.out.println(findMaxForm(strs,m,n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int ones=0,zeros=0;
            for(char c:str.toCharArray()){
                if(c=='0')
                    zeros++;
                else
                    ones++;
            }
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
