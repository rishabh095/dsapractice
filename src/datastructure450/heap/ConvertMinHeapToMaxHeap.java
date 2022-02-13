package datastructure450.heap;

// https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/

import java.util.Arrays;

public class ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        convertMaxHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // O(n log n) time complexity and O(1) space complexity
    private static void convertMaxHeap(int[] arr, int n) {
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(arr, n, i);
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
