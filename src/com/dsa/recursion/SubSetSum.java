package com.dsa.recursion;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 5};
        int sum = 25;
        System.out.println(countSubSetSum(arr, arr.length, sum));
    }

    //O(2^n)
    private static int countSubSetSum(int[] arr, int n, int sum) {
        if (n == 0)
            return (sum == 0) ? 1 : 0;
        return countSubSetSum(arr, n - 1, sum) + countSubSetSum(arr, n - 1, sum - arr[n - 1]);
    }
}
