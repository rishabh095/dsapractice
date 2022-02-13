package datastructure450.backtracking;

// https://www.geeksforgeeks.org/partition-problem-dp-18/

public class PartitionSumProblem {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 9, 12};
        System.out.println(isPartitionSum(arr, arr.length));
        System.out.println(isPartitionSumDP(arr, arr.length));
    }

    // O(sum * n) time complexity and O(sum * n) space complexity
    private static boolean isPartitionSumDP(int[] arr, int n) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        if (sum % 2 != 0)
            return false;
        boolean[][] dp = new boolean[sum / 2 + 1][n + 1];
        for (int i = 0; i < n; i++)
            dp[0][i] = true;
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1])
                    dp[i][j] = dp[i][j - 1] || dp[i - arr[j - 1]][j - 1];
            }
        }
        return dp[sum / 2][n];
    }

    // O(2^n) time complexity
    private static boolean isPartitionSum(int[] arr, int n) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        if (sum % 2 != 0)
            return false;
        if (sum == 0)
            return true;
        return partitionSum(arr, n, sum / 2);
    }

    private static boolean partitionSum(int[] arr, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
        if (arr[n - 1] > sum)
            partitionSum(arr, n - 1, sum);
        return partitionSum(arr, n - 1, sum) || partitionSum(arr, n - 1, sum - arr[n - 1]);
    }
}
