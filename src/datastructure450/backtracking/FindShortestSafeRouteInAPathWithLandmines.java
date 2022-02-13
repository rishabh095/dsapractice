package datastructure450.backtracking;

// https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/

import java.util.Arrays;

public class FindShortestSafeRouteInAPathWithLandmines {
    static int R, C;
    static int minDistance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1}};
        R = mat.length;
        C = mat[0].length;
        minDistance = Integer.MAX_VALUE;
        findShortestPath(mat);
        if (minDistance != Integer.MAX_VALUE)
            System.out.println(minDistance);
        else
            System.out.println("No solution");
    }

    // O(R * 4^(R*C)) time complexity and O(R*C) space complexity
    private static void findShortestPath(int[][] mat) {
        boolean[][] visited = new boolean[R][C];
        markUnsafeCell(mat);
        for (int i = 0; i < R; i++) {
            if (mat[i][0] == 1) {
                for (boolean[] row : visited)
                    Arrays.fill(row, false);
                findShortestPathUtil(mat, visited, i, 0, 0);
                if (minDistance == C - 1)
                    break;
            }
        }
    }

    private static void findShortestPathUtil(int[][] mat, boolean[][] visited, int row, int col, int dist) {
        if (col == C - 1) {
            minDistance = Math.min(dist, minDistance);
            return;
        }
        if (dist > minDistance)
            return;
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int nextRow = row + dx[k];
            int nextCol = col + dy[k];
            if (isValid(nextRow, nextCol)) {
                if (isSafe(mat, visited, nextRow, nextCol))
                    findShortestPathUtil(mat, visited, nextRow, nextCol, dist + 1);
            }
        }
        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] mat, boolean[][] visited, int row, int col) {
        return mat[row][col] == 1 && !visited[row][col];
    }

    private static void markUnsafeCell(int[][] mat) {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (mat[row][col] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = row + dx[k];
                        int nextCol = col + dy[k];
                        if (isValid(nextRow, nextCol))
                            mat[nextRow][nextCol] = -1;
                    }
                }
            }
        }
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (mat[row][col] == -1)
                    mat[row][col] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
