package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1

import java.util.Arrays;

public class MinimizeTheHeightsII {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        int k = 2;
        int n = arr.length;
        System.out.println(getMinDiff(arr, n, k));
    }

    private static int getMinDiff(int[] arr, int n, int k) {
        if (n == 1 || n == 0)
            return 0;
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        if (small > big) {
            int temp = small;
            small = big;
            big = temp;
        }
        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;
            if (subtract >= small || add <= big)
                continue;
            if (subtract - big <= add - small)
                small = subtract;
            else
                big = add;
        }
        return Math.min(ans, big - small);
    }
}
