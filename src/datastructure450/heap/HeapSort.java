package datastructure450.heap;

// https://www.geeksforgeeks.org/heap-sort/

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // O(n log n) time complexity
    private static void heapSort(int[] arr, int n) {
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
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
