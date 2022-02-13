package datastructure450.backtracking;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeProblem {
    static List<String> result;
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(maze, maze.length));
    }

    // O(4^(m*n)) time complexity and O(m*n) space complexity
    private static List<String> findPath(int[][] maze, int n) {
        result = new ArrayList<>();
        visited = new boolean[n][n];
        findPathUtil(maze, n, 0, 0, "");
        return result;
    }

    private static void findPathUtil(int[][] maze, int n, int row, int col, String path) {
        if (!isSafe(maze, row, col))
            return;
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }
        visited[row][col] = true;
        if (isSafe(maze, row + 1, col)) {
            path += 'D';
            findPathUtil(maze, n, row + 1, col, path);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(maze, row, col - 1)) {
            path += 'L';
            findPathUtil(maze, n, row, col - 1, path);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(maze, row, col + 1)) {
            path += 'R';
            findPathUtil(maze, n, row, col + 1, path);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(maze, row - 1, col)) {
            path += 'U';
            findPathUtil(maze, n, row - 1, col, path);
            path = path.substring(0, path.length() - 1);
        }
        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze.length &&
                !visited[row][col] && maze[row][col] == 1;
    }
}
