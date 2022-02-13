package datastructure450.dp;

// https://www.geeksforgeeks.org/minimum-removals-array-make-max-min-k/

import java.util.Arrays;

public class MinimumRemovalsFromArrayToMakeMaxMinusMinLessThanEqualK {
    static int[][] dp;

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 9, 10, 11, 12, 17, 20};
        int k = 4;
        System.out.println(removals(arr, arr.length, k));
        System.out.println(removalsBinarySearch(arr, arr.length, k));
        System.out.println(removalsAnotherSolution(arr, arr.length, k));
    }

    // O(n log n) time complexity and O(n) space complexity
    private static int removalsAnotherSolution(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = n - 1;
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = i;
            int j = dp[i - 1];
            while (j != i && arr[i] - arr[j] > k)
                j++;
            dp[i] = Math.min(dp[i], j);
            ans = Math.min(ans, n - (i - j + 1));
        }
        return ans;
    }

    // O(n log n) time complexity and O(1) space complexity
    private static int removalsBinarySearch(int[] arr, int n, int k) {
        int ans = n - 1;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int j = findIndex(arr[i], i + 1, n - 1, k, arr);
            if (j != -1)
                ans = Math.min(ans, n - (j - i + 1));
        }
        return ans;
    }

    private static int findIndex(int num, int start, int end, int k, int[] arr) {
        int index = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] - num <= k) {
                index = mid;
                start = mid + 1;
            } else
                end = mid;
        }
        return index;
    }

    // O(n*n) time complexity and O(n*n) space complexity
    private static int removals(int[] arr, int n, int k) {
        if (n == 1)
            return 0;
        Arrays.sort(arr);
        dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countRemovals(arr, 0, n - 1, k);
    }

    private static int countRemovals(int[] arr, int i, int j, int k) {
        if (i >= j)
            return 0;
        else if (arr[j] - arr[i] <= k)
            return 0;
        else if (dp[i][j] != -1)
            return dp[i][j];
        else if (arr[j] - arr[i] > k)
            dp[i][j] = 1 + Math.min(countRemovals(arr, i + 1, j, k), countRemovals(arr, i, j - 1, k));
        return dp[i][j];
    }
}
