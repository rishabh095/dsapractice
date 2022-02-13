package datastructure450.dp;

// https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/

import java.util.Arrays;

public class LongestSubsequenceSuchThatDifferenceBetweenAdjacentIsOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(longestSubseqWithDiffOne(arr, arr.length));
    }

    private static int longestSubseqWithDiffOne(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j] + 1 || arr[i] == arr[j] - 1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for (int num : dp) {
            if (max < num)
                max = num;
        }
        return max;
    }
}
