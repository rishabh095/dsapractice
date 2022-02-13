package datastructure450.dp;

// https://www.geeksforgeeks.org/count-subsequences-product-less-k/

public class CountAllSubsequencesHavingProductLessThanK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};//{1, 2, 3, 4};//{4, 8, 7, 2};//
        int k = 8;//10;//50;
        System.out.println(productSubSeqCountDP(arr, arr.length, k));
        //contiguous subarrays
        //https://leetcode.com/problems/subarray-product-less-than-k/
        System.out.println(productSubSeqCountBetterSolution(arr, arr.length, k));
    }

    //O(n) time complexity and O(1) space complexity
    private static int productSubSeqCountBetterSolution(int[] arr, int n, int k) {
        int ans = 0, left = 0, product = 1;
        for (int right = 0; right < n; right++) {
            product *= arr[right];
            while (product >= k)
                product /= arr[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    //O(k*n) time complexity and O(k*n) space complexity
    private static int productSubSeqCountDP(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j - 1] <= i && arr[j - 1] > 0)
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
            }
        }
        return dp[k][n];
    }
}
