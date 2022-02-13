package datastructure450.backtracking;

// https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/

public class LongestPossibleRouteInAMatrixWithHurdles {
    static int R, C;

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        R = mat.length;
        C = mat[0].length;
        findLongestPath(mat, 0, 0, 1, 7);
    }

    private static void findLongestPath(int[][] mat, int sourceRow, int sourceCol, int destinationRow,
                                        int destinationCol) {
        boolean[][] visited = new boolean[R][C];

        LongestPathPair p = findLongestPathUtil(mat, visited, sourceRow, sourceCol, destinationRow, destinationCol);
        if (p.found)
            System.out.println(p.value);
        else
            System.out.println("Not Reachable");
    }

    private static LongestPathPair findLongestPathUtil(int[][] mat, boolean[][] visited, int row,
                                                       int col, int destinationRow, int destinationCol) {
        if (row == destinationRow && col == destinationCol)
            return new LongestPathPair(true, 0);
        if (row < 0 || row >= R || col < 0 || col >= C || visited[row][col] || mat[row][col] == 0)
            return new LongestPathPair(false, Integer.MAX_VALUE);
        visited[row][col] = true;
        int res = Integer.MIN_VALUE;
        LongestPathPair solution = findLongestPathUtil(mat, visited, row + 1, col, destinationRow, destinationCol);
        if (solution.found)
            res = Math.max(res, solution.value);
        solution = findLongestPathUtil(mat, visited, row - 1, col, destinationRow, destinationCol);
        if (solution.found)
            res = Math.max(res, solution.value);
        solution = findLongestPathUtil(mat, visited, row, col + 1, destinationRow, destinationCol);
        if (solution.found)
            res = Math.max(res, solution.value);
        solution = findLongestPathUtil(mat, visited, row, col - 1, destinationRow, destinationCol);
        if (solution.found)
            res = Math.max(res, solution.value);
        visited[row][col] = false;
        if (res != Integer.MIN_VALUE)
            return new LongestPathPair(true, res + 1);
        else
            return new LongestPathPair(false, Integer.MAX_VALUE);
    }
}
