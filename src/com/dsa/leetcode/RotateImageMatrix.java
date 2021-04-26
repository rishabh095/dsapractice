package com.dsa.leetcode;

import java.util.Arrays;

public class RotateImageMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        printBoard(matrix);
        System.out.println();
        rotate(matrix);
        System.out.println();
        int[][] matrix1={{1,2,3},{4,5,6},{7,8,9}};
        rotateOtherSolution(matrix1);
    }

    private static void rotateOtherSolution(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
        printBoard(matrix);
    }

    private static void reverse(int[][] matrix) {
        int row=matrix.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<row/2;j++){
                int temp=matrix[i][row-j-1];
                matrix[i][row-j-1]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }

    private static void transpose(int[][] matrix) {
        int row=matrix.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    private static void rotate(int[][] matrix) {
        int row=matrix.length;
        for(int i=0;i<(row+1)/2;i++){
            for(int j=0;j<row/2;j++){
                int temp=matrix[row-j-1][i];
                matrix[row-j-1][i]=matrix[row-i-1][row-j-1];
                matrix[row-i-1][row-j-1]=matrix[j][row-i-1];
                matrix[j][row-i-1]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        printBoard(matrix);
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
