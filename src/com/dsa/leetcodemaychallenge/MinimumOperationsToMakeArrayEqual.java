package com.dsa.leetcodemaychallenge;

// https://leetcode.com/problems/minimum-operations-to-make-array-equal/

public class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        int n=3;
        System.out.println(minOperations(n));
        System.out.println(minOperationsBetterSolution(n));
    }

    private static int minOperationsBetterSolution(int n) {
        if(n %2 !=0){
            int mid=(n-1)/2;
            return mid*(mid+1);
        }else{
            int mid=n/2;
            return mid*mid;
        }
    }

    private static int minOperations(int n) {
        int noOfOperations=0;
        for(int i=0;i<n/2;i++)
            noOfOperations+=n-(2*i+1);
        return noOfOperations;
    }
}
