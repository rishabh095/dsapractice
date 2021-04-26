package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    static int[][] board;
    static List<List<String>> result;
    public static void main(String[] args) {
        int n = 4;
        board = new int[n][n];
        result=new ArrayList<>();
        solveNQueenProblem(n);
        for(List<String> str:result){
            for(String s:str)
                System.out.print(s+",");
            System.out.println();
        }
    }

    // O(n!) (factorial n) time complexity
    private static void solveNQueenProblem(int n) {
        solveProblem(0, n);
    }
    private static void solveProblem(int col, int n) {
        if (col == n) {
            printBoard(board);
            prepareList(board);
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, n)) {
                board[i][col] = 1;
                solveProblem(col + 1, n);
                board[i][col] = 0;
            }
        }
    }

    private static void prepareList(int[][] board) {
        List<String> subList=new ArrayList<>();
        for(int[] row:board){
            StringBuilder sb=new StringBuilder();
            for(int val:row){
                if(val==0)
                    sb.append(".");
                else
                    sb.append("Q");
            }
            subList.add(sb.toString());
        }
        result.add(subList);
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
