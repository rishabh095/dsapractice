package datastructure450.heap;

import java.util.Random;

public class KSmallestLargestElement {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 2;
        System.out.println(kSmallest(arr, 0, arr.length - 1, k));
        System.out.println(kLargest(arr, 0, arr.length - 1, k));
    }

    private static int kLargest(int[] arr, int start, int end, int k) {
        while (start <= end) {
            int p = partitionForGreater(arr, start, end);
            if (p == k-1)
                return arr[p];
            else if (p > k-1)
                end = p - 1;
            else
                start = p + 1;
        }
        return -1;
    }

    private static int partitionForGreater(int[] arr, int start, int end) {
        randomNumber(arr, start, end);
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] > pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static int kSmallest(int[] arr, int start, int end, int k) {
        while (start <= end) {
            int p = partitionForSmaller(arr, start, end);
            if (p == k-1)
                return arr[p];
            else if (p > k-1)
                end = p - 1;
            else
                start = p + 1;
        }
        return -1;
    }

    private static int partitionForSmaller(int[] arr, int start, int end) {
        randomNumber(arr, start, end);
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void randomNumber(int[] arr, int start, int end) {
        int pos = random.nextInt(end - start + 1) + start;
        swap(arr, end, pos);
    }

    private static void swap(int[] arr, int end, int pos) {
        int temp = arr[pos];
        arr[pos] = arr[end];
        arr[end] = temp;
    }

}
