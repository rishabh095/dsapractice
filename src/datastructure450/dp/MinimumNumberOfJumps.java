package datastructure450.dp;

import java.util.Arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumStepsRecursive(arr, arr.length));
        System.out.println(minimumStepsDP(arr, arr.length));
        System.out.println(minimumStepsBestSolution(arr, arr.length));
    }

    // // O(n) time complexity and O(1) space complexity
    private static int minimumStepsBestSolution(int[] arr, int n) {
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

    // O(n^2) time complexity and O(n) space complexity
    private static int minimumStepsDP(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
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

    // O(n^n) time complexity
    private static int minimumStepsRecursive(int[] arr, int n) {
        if (n == 1)
            return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] >= n - 1) {
                int subResult = minimumStepsRecursive(arr, i + 1);
                if (subResult != Integer.MAX_VALUE)
                    result = Math.min(result, subResult + 1);
            }
        }
        return result;
    }
}
