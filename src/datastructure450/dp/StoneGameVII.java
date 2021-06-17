package datastructure450.dp;

// https://leetcode.com/problems/stone-game-vii/

public class StoneGameVII {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        System.out.println(stoneGameVII(arr));
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int stoneGameVII(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int prev = 0;
            int sum = arr[i];
            for (int j = i; j < n; j++) {
                if (i != j) {
                    sum += arr[j];
                    int a = sum - arr[j];
                    int b = sum - arr[i];
                    dp[j] = Math.max(a - prev, b - dp[j]);
                }
                prev = dp[j];
            }
        }
        return dp[n - 1];
    }
}
