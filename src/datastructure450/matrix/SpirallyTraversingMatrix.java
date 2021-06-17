package datastructure450.matrix;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpirallyTraversingMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder(arr, arr.length, arr[0].length));
    }

    // O(R*C) or O(n) time complexity -> where n is the total no of elements in matrix
    private static List<Integer> spiralOrder(int[][] matrix, int R, int C) {
        ArrayList<Integer> result = new ArrayList<>();
        if (R == 0)
            return result;
        int top = 0, bottom = R - 1, left = 0, right = C - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;
            for (int j = top; j <= bottom; j++)
                result.add(matrix[j][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
            }
            bottom--;
            if (left <= right) {
                for (int j = bottom; j >= top; j--)
                    result.add(matrix[j][left]);
            }
            left++;
        }
        return result;
    }
}
