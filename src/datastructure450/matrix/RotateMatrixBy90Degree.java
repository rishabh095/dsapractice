package datastructure450.matrix;

import java.util.Arrays;

// https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int[] ar : arr)
            System.out.println(Arrays.toString(ar));
        System.out.println("---------After Rotate----------");
        rotate(arr, arr.length);
        for (int[] ar : arr)
            System.out.println(Arrays.toString(ar));
    }

    private static void rotate(int[][] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - j - 1][i];
                arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
                arr[j][n - i - 1] = temp;
            }
        }
    }
}
