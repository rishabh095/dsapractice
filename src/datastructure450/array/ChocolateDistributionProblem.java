package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;
        System.out.println(findMinDiff(arr, arr.length, m));
    }

    private static int findMinDiff(int[] arr, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (n < m)
            return -1;
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - m; i++) {
            int diff = arr[i + m - 1] - arr[i];
            res = Math.min(res, diff);
        }
        return res;
    }
}
