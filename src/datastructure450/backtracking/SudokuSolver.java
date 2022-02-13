package datastructure450.backtracking;

// https://www.geeksforgeeks.org/sudoku-backtracking-7/
// https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1

import java.util.Arrays;

public class SudokuSolver {
    static int SIZE = 9;

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        if (solveSudoku(grid, 0, 0))
            printSolution(grid);
        else
            System.out.println("No solution exists");
    }

    private static void printSolution(int[][] grid) {
        for (int[] row : grid)
            System.out.println(Arrays.toString(row));
    }

    private static boolean solveSudoku(int[][] grid, int row, int col) {
        if (row == SIZE - 1 && col == SIZE)
            return true;
        if (col == SIZE) {
            row++;
            col = 0;
        }
        if (grid[row][col] != 0)
            return solveSudoku(grid, row, col + 1);
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solveSudoku(grid, row, col + 1))
                    return true;
            }
            grid[row][col] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int i = 0; i <= 8; i++) {
            if (grid[row][i] == num)
                return false;
        }
        for (int i = 0; i <= 8; i++) {
            if (grid[i][col] == num)
                return false;
        }
        int startRow = row - row % 3;
        int colStart = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + colStart] == num)
                    return false;
            }
        }
        return true;
    }
}