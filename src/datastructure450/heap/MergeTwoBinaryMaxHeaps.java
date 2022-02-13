package datastructure450.heap;

// https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1

import java.util.Arrays;

public class MergeTwoBinaryMaxHeaps {
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 6, 2};
        int[] arr2 = {12, 7, 9};
        mergeHeaps(arr1, arr2, arr1.length, arr2.length);
    }

    // O(n log n) time complexity
    private static void mergeHeaps(int[] arr1, int[] arr2, int n1, int n2) {
        int n = n1 + n2;
        int[] result = new int[n];
        for (int i = 0; i < n1; i++)
            result[i] = arr1[i];
        for (int i = 0; i < n2; i++)
            result[i + n1] = arr2[i];
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(result, n, i);
        System.out.println(Arrays.toString(result));
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
