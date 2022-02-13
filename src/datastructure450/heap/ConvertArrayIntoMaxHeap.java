package datastructure450.heap;

// https://www.geeksforgeeks.org/building-heap-from-array/

public class ConvertArrayIntoMaxHeap {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        buildHeap(arr, arr.length);
    }

    private static void buildHeap(int[] arr, int n) {
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(arr, n, i);
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = getLeft(i);
        int right = getRight(i);
        if (left < n && arr[left] > arr[i])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    private static int getParent(int i) {
        return (i - 1) / 2;
    }

    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    private static int getRight(int i) {
        return 2 * i + 2;
    }
}
