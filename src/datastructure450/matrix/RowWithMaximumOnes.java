package datastructure450.matrix;

// https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/

public class RowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1}, {0, 1, 1, 1},
                {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(matrix, matrix.length, matrix[0].length));
        System.out.println(rowWithMax1sBetterInAverageCase(matrix, matrix.length, matrix[0].length));
        System.out.println(rowWithMax1sBetterSolution(matrix, matrix.length, matrix[0].length));
    }

    // O(m + n ) where m is no. of Row and n is no. of column.
    private static int rowWithMax1sBetterSolution(int[][] matrix, int R, int C) {
        int maxRowIndex = 0, j = C - 1;
        for (int i = 0; i < R; i++) {
            while (j >= 0 && matrix[i][j] == 1) {
                j--;
                maxRowIndex = i;
            }
        }
        if (maxRowIndex == 0 && matrix[0][C - 1] == 0)
            return -1;
        return maxRowIndex;
    }

    // O(m log n ) where m is no. of Row and n is no. of column.
    private static int rowWithMax1sBetterInAverageCase(int[][] matrix, int R, int C) {
        int i, index = 0;
        int maxRowIndex = -1;
        int max = firstIndex(matrix[0], 0, C - 1);
        for (i = 1; i < R; i++) {
            if (max != -1 && matrix[i][C - max] == 1)
                index = firstIndex(matrix[i], 0, C - max);
            if (index != -1 && C - index > max) {
                max = C - index;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    // O(m log n ) where m is no. of Row and n is no. of column.
    private static int rowWithMax1s(int[][] matrix, int R, int C) {
        int maxRowIndex = -1, max = -1;
        int i, index;
        for (i = 0; i < R; i++) {
            index = firstIndex(matrix[i], 0, C - 1);
            if (index != -1 && C - index > max) {
                max = C - index;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    private static int firstIndex(int[] matrix, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || matrix[mid - 1] == 0) && matrix[mid] == 1)
                return mid;
            else if (matrix[mid] == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
