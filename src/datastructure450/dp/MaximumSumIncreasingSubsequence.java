package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumLIS(arr, arr.length));
        System.out.println(maxSumLISDPWithBinarySearchSolution(arr, arr.length));
    }

    // O(n log n) time complexity and O(n) time complexity
    private static int maxSumLISDPWithBinarySearchSolution(int[] arr, int n) {
        int[] tail = new int[n];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1])
                tail[len++] = arr[i];
            else {
                int ceil = findCeiling(tail, 0, len - 1, arr[i]);
                tail[ceil] = arr[i];
            }
        }
        int sum = 0;
        for (int num : tail)
            sum += num;
        return sum;
    }

    private static int findCeiling(int[] tail, int start, int end, int num) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (tail[mid] >= num)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int maxSumLIS(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = arr[i];
        int maxSum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < arr[i] + dp[j])
                    dp[i] = arr[i] + dp[j];
            }
        }
        for (int num : dp) {
            if (maxSum < num)
                maxSum = num;
        }
        return maxSum;
    }
}
