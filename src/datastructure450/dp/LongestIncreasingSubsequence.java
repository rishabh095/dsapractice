package datastructure450.dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(findLIS(arr, Integer.MIN_VALUE, 0));
        System.out.println(findLISDP(arr, arr.length));
        System.out.println(findLISDPWithBinarySearchSolution(arr, arr.length));
    }

    // O(n log n) time complexity and O(n) time complexity
    private static int findLISDPWithBinarySearchSolution(int[] arr, int n) {
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
        return len;
    }

    private static int findCeiling(int[] tail, int start, int end, int num) {
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (tail[mid] >= num)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int findLISDP(int[] arr, int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxSum = 1;
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    maxVal = Math.max(maxVal, dp[j]);
            }
            dp[i] = maxVal + 1;
            maxSum = Math.max(dp[i], maxVal);
        }
        return maxSum;
    }

    // O(2^n) time complexity and O(1) space complexity
    private static int findLIS(int[] arr, int prev, int currPosition) {
        if (currPosition == arr.length)
            return 0;
        int taken = 0;
        if (arr[currPosition] > prev)
            taken = 1 + findLIS(arr, arr[currPosition], currPosition + 1);
        int notTaken = findLIS(arr, prev, currPosition + 1);
        return Math.max(taken, notTaken);
    }
}
