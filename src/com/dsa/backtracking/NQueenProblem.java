package com.dsa.backtracking;

import java.util.Arrays;

public class NQueenProblem {
    static int[][] board;

    public static void main(String[] args) {
        int n = 4;
        board = new int[n][n];
        solveNQueenProblem(n);
    }

    // O(n!) (factorial n) worst case time complexity
    private static void solveNQueenProblem(int n) {
        if (!solveProblem(0, n))
            System.out.println("No Solution exists");
        else
            printBoard(board);
    }

    private static boolean solveProblem(int col, int n) {
        if (col == n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, n)) {
                board[i][col] = 1;
                if (solveProblem(col + 1, n))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
