package com.dsa.leetcode;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]};
        printBoard(board);
        System.out.println();
        solve(board);
    }

    private static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row-1 || j == col-1) {
                    if (board[i][j] == 'O')
                        dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
        printBoard(board);
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length)
            return;
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
