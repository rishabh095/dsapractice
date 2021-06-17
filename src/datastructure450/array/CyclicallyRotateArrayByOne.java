package datastructure450.array;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1#

public class CyclicallyRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        rotate(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) time complexity
    private static void rotate(int[] arr, int n) {
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--)
            arr[i] = arr[i - 1];
        arr[0] = temp;
    }
}
