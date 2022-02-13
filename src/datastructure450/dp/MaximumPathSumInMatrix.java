package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-path-sum-matrix/

public class MaximumPathSumInMatrix {
    static int R, C;

    public static void main(String[] args) {
        int[][] matrix = {{10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };
        R = matrix.length;
        C = matrix[0].length;
        System.out.println(findMaxPath(matrix));
    }

    // O(R*C) time complexity and O(1) space complexity
    private static int findMaxPath(int[][] matrix) {
        int res = -1;
        for (int i = 0; i < C; i++)
            res = Math.max(res, matrix[0][i]);
        for (int i = 1; i < R; i++) {
            res = -1;
            for (int j = 0; j < C; j++) {
                if (j > 0 && j < C - 1)
                    matrix[i][j] += Math.max(matrix[i - 1][j], Math.max(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                else if (j > 0)
                    matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i - 1][j - 1]);
                else
                    matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i - 1][j + 1]);
                res = Math.max(res, matrix[i][j]);
            }
        }
        return res;
    }
}
