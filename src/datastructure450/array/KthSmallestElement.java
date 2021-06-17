package datastructure450.array;

import java.util.Random;

//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

public class KthSmallestElement {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 4;
        System.out.println(kSmallestElement(arr, 0, arr.length - 1, k));
    }

    //O(n) time complexity (quick sort with Lomuto partition with random pivot)
    private static int kSmallestElement(int[] arr, int start, int end, int k) {
        while (start <= end) {
            int p = partition(arr, start, end);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                end = p - 1;
            else
                start = p + 1;
        }
        return -1;
    }

    private static int partition(int[] arr, int start, int end) {
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
        swap(arr, pos, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
