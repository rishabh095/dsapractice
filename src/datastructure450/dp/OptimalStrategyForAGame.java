package datastructure450.dp;

// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        int[] arr = {8, 15, 3, 7};//{2,2,2,2};//{ 20, 30, 2, 2, 2, 10 };// {5, 3, 7, 10};//
        System.out.println(optimalSolution(arr, arr.length));
        System.out.println(optimalSolutionOtherSolution(arr, 0, arr.length - 1));
        System.out.println(optimalSolutionDP(arr, arr.length));
    }

    // O(n*n) time complexity and O(n*n) space complexity
    private static int optimalSolutionDP(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
            }
        }
        return dp[0][n - 1];
    }

    // exponential time complexity O(4^n)
    private static int optimalSolutionOtherSolution(int[] arr, int i, int j) {
        if (i == j)
            return arr[i];
        if (j == i + 1)
            return Math.max(arr[i], arr[j]);
        return Math.max(arr[i] + Math.min(optimalSolutionOtherSolution(arr, i + 2, j), optimalSolutionOtherSolution(arr, i + 1, j - 1)),
                arr[j] + Math.min(optimalSolutionOtherSolution(arr, i, j - 2), optimalSolutionOtherSolution(arr, i + 1, j - 1)));
    }

    // O(2^n) time complexity
    private static int optimalSolution(int[] arr, int n) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return optimalSolutionUtil(arr, 0, n - 1, sum);
    }

    private static int optimalSolutionUtil(int[] arr, int i, int j, int sum) {
        if (j == i + 1)
            return Math.max(arr[i], arr[j]);
        return Math.max(sum - optimalSolutionUtil(arr, i + 1, j, sum - arr[i]),
                sum - optimalSolutionUtil(arr, i, j - 1, sum - arr[j]));
    }
}
