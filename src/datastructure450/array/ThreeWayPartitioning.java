package datastructure450.array;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 9, 3, 6, 8, 11, 4};
        int a = 4, b = 7;
        System.out.println(Arrays.toString(arr));
        threeWayPartition(arr, a, b);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) time complexity and O(1) time complexity
    private static void threeWayPartition(int[] arr, int a, int b) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] < a) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] > b) {
                swap(arr, mid, high);
                high--;
            } else
                mid++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
