package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

import java.util.Arrays;

public class LargestSquareFormedInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        printMaxSubSquare(matrix);
        System.out.println(maxSubSqaure(matrix));
    }

    private static int maxSubSqaure(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sub = new int[n][m];
        int maxsize = 0;
        for (int i = 0; i < m; i++) {
            sub[0][i] = matrix[0][i];
            maxsize = Math.max(maxsize, sub[0][i]);
        }
        for (int i = 0; i < n; i++) {
            sub[i][0] = matrix[i][0];
            maxsize = Math.max(maxsize, sub[i][0]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1)
                    sub[i][j] = Math.min(sub[i - 1][j - 1],
                            Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
                else
                    sub[i][j] = 0;
                maxsize = Math.max(maxsize, sub[i][j]);
            }
        }
        return maxsize;
    }

    private static void printMaxSubSquare(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] sumMatrix = new int[R][C];
        for (int i = 0; i < R; i++)
            sumMatrix[i][0] = matrix[i][0];
        for (int i = 0; i < C; i++)
            sumMatrix[0][i] = matrix[0][i];
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 1)
                    sumMatrix[i][j] = 1 + Math.min(sumMatrix[i][j - 1],
                            Math.min(sumMatrix[i - 1][j], sumMatrix[i - 1][j - 1]));
                else
                    sumMatrix[i][j] = 0;
            }
        }
        for (int[] row : sumMatrix)
            System.out.println(Arrays.toString(row));
        int maxOfSumMatrix = sumMatrix[0][0], iMax = 0, jMax = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maxOfSumMatrix < sumMatrix[i][j]) {
                    maxOfSumMatrix = sumMatrix[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        int count = 0;
        for (int i = iMax; i > iMax - maxOfSumMatrix; i--) {
            for (int j = jMax; j > jMax - maxOfSumMatrix; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            count++;
            System.out.println();
        }
        System.out.println(count);
    }
}
