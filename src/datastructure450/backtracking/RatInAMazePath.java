package datastructure450.backtracking;

// https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/

import java.util.Arrays;

public class RatInAMazePath {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        solveMaze(maze);
    }

    // O(2^(m*n)) time complexity and O(m*n) space complexity
    private static void solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] solution = new int[n][n];
        solveMazeUtil(maze, 0, 0, solution);
        printSolution(solution);
    }

    private static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] solution) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            solution[row][col] = 1;
            return true;
        }
        if (isSafe(maze, row, col)) {
            if (solution[row][col] == 1)
                return false;
            solution[row][col] = 1;
            if (solveMazeUtil(maze, row + 1, col, solution))
                return true;
            if (solveMazeUtil(maze, row, col + 1, solution))
                return true;
            solution[row][col] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze.length &&
                maze[row][col] == 1;
    }

    private static void printSolution(int[][] solution) {
        for (int[] row : solution)
            System.out.println(Arrays.toString(row));
    }
}
