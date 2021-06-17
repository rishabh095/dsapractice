package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#

public class MinimumNumberOfJumpsToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumJumpsRecursive(arr, arr.length));
        System.out.println(minimumJumpsDP(arr, arr.length));
        System.out.println(minimumJumpsBestSolution(arr, arr.length));
    }

    // O(n) time complexity
    private static int minimumJumpsBestSolution(int[] arr, int n) {
        if (n == 0 || n == 1)
            return 0;
        int jumps = 1;
        int next = arr[0], max = arr[0];
        for (int i = 0; i < n; i++) {
            if (i + arr[i] > next)
                next = i + arr[i];
            if (max == i && i != n - 1) {
                jumps++;
                max = next;
            }
            if (max >= n - 1)
                break;
        }
        return jumps;
    }

    // O(n*n) time complexity
    private static int minimumJumpsDP(int[] arr, int n) {
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

    // O(n*n) time complexity
    private static int minimumJumpsRecursive(int[] arr, int n) {
        if (n == 1)
            return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] >= n - 1) {
                int subResult = minimumJumpsRecursive(arr, i + 1);
                if (subResult != Integer.MAX_VALUE)
                    result = Math.min(result, subResult + 1);
            }
        }
        return result;
    }
}
