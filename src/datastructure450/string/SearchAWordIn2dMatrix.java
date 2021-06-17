package datastructure450.string;

// https://www.geeksforgeeks.org/find-count-number-given-string-present-2d-character-array/

public class SearchAWordIn2dMatrix {
    static int R, C;

    public static void main(String[] args) {
        char[][] grid = {
                {'D', 'D', 'D', 'G', 'D', 'D'},
                {'B', 'B', 'D', 'E', 'B', 'S'},
                {'B', 'S', 'K', 'E', 'B', 'K'},
                {'D', 'D', 'D', 'D', 'D', 'E'},
                {'D', 'D', 'D', 'D', 'D', 'E'},
                {'D', 'D', 'D', 'D', 'D', 'G'}};
        String str = "GEEKS";
        char[][] grid1 = {
                {'B', 'B', 'M', 'B', 'B', 'B'},
                {'C', 'B', 'A', 'B', 'B', 'B'},
                {'I', 'B', 'G', 'B', 'B', 'B'},
                {'G', 'B', 'I', 'B', 'B', 'B'},
                {'A', 'B', 'C', 'B', 'B', 'B'},
                {'M', 'C', 'I', 'G', 'A', 'M'}};
        String str1 = "MAGIC";
        System.out.println(searchString(grid, str));
        System.out.println(searchString(grid1, str1));
    }

    // (R*C) time complexity
    private static int searchString(char[][] grid, String str) {
        int count = 0;
        R = grid.length;
        C = grid[0].length;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (dfs(grid, row, col, str, 0)) {
                    count++;
                    System.out.println("found at " + row + " " + col);
                }
            }
        }
        return count;
    }

    private static boolean dfs(char[][] grid, int row, int col, String str, int index) {
        if (str.length() == index)
            return true;
        if (row >= R || row < 0 || col >= C || col < 0 || grid[row][col] != str.charAt(index))
            return false;
        return dfs(grid, row + 1, col, str, index + 1) ||
                dfs(grid, row - 1, col, str, index + 1) ||
                dfs(grid, row, col + 1, str, index + 1) ||
                dfs(grid, row, col - 1, str, index + 1);

    }
}
