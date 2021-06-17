package com.dsa.flipkart;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//{2, 3, 1, 1, 4};
        System.out.println(jumpCountUsingRecursion(arr,arr.length));
        System.out.println(jumpCountUsingDP(arr, arr.length));
        System.out.println(jumpCountBetterSolution(arr, arr.length));
    }

    private static int jumpCountBetterSolution(int[] arr, int n) {
        if (n == 0 || n == 1)
            return 0;
        int next = arr[0], max = arr[0];
        int jumps = 1;
        for (int i = 0; i < n; i++) {
            if (i + arr[i] > next)
                next = i + arr[i];
            if (max == i && i != n - 1) {
                max = next;
                jumps++;
            }
            if (max >= n - 1)
                break;
        }
        return jumps;
    }

    private static int jumpCountUsingDP(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i) {
                    if (dp[j] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    static int jumpCountUsingRecursion(int[] nums, int n) {
        if (n == 1)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (i + nums[i] >= n - 1) {
                int sub_res = jumpCountUsingRecursion(nums, i + 1);
                if (sub_res != Integer.MAX_VALUE)
                    res = Math.min(res, sub_res+1);
            }
        }
        return res;
    }
}
