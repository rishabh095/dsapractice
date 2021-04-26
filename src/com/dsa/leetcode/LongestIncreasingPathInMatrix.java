package com.dsa.leetcode;

// Longest Increasing Path in a Matrix
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInMatrix {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPathNaive(matrix));
        System.out.println(longestIncreasingPathEfficientSolution(matrix));
    }

    //O(m*n) but calculating path for every position even if already done hence time limit exceeded.
    private static int longestIncreasingPathNaive(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfsNaive(matrix, m, n, i, j);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }

    private static int dfsNaive(int[][] matrix, int m, int n, int i, int j) {
        int max = 1;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j])
                max = Math.max(max, 1 + dfsNaive(matrix, m, n, x, y));
        }
        return max;
    }

    //O(m*n) used dp array to remember calculated path for every position.
    private static int longestIncreasingPathEfficientSolution(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int longestPath = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfs(matrix, m, n, i, j, dp);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }


    private static int dfs(int[][] matrix, int m, int n, int i, int j, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int max = 1;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j])
                max = Math.max(max, 1 + dfs(matrix, m, n, x, y, dp));
        }
        return dp[i][j] = max;
    }
}
