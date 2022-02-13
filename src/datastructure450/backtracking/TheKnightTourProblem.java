package datastructure450.backtracking;

// https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/

import java.util.Arrays;

public class TheKnightTourProblem {
    static int SIZE = 8;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2 };//{2, 2, 1, 1, -2, -2, -1, -1};
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };//{1, -1, 2, -2, 1, -1, 2, -2};

    public static void main(String[] args) {
        int[][] solution = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                solution[i][j] = -1;
        }
        solution[0][0] = 0;
        if (!knightTourProblemUtil(solution, 0, 0, 1))
            System.out.println("No Solution exists");
        else {
            System.out.println("solution ");
            for (int[] row : solution)
                System.out.println(Arrays.toString(row));
        }
    }

    // O(8^(N*N)) time complexity
    private static boolean knightTourProblemUtil(int[][] solution, int row, int col, int move) {
        if (move == SIZE * SIZE)
            return true;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isSafe(solution, nextRow, nextCol)) {
                solution[nextRow][nextCol] = move;
                if (knightTourProblemUtil(solution, nextRow, nextCol, move + 1))
                    return true;
                else
                    solution[nextRow][nextCol] = -1;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] solution, int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && solution[row][col] == -1;
    }
}
