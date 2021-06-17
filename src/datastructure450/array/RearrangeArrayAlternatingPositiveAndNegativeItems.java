package datastructure450.array;

// https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/

import java.util.Arrays;

public class RearrangeArrayAlternatingPositiveAndNegativeItems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        System.out.println(Arrays.toString(arr));
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // O(n log n) time complexity
    private static void rearrange(int[] arr, int n) {
        int positive = 0, negative = 0;
        for (int num : arr) {
            if (num < 0)
                negative++;
            else
                positive++;
        }
        Arrays.sort(arr);
        if (positive >= negative)
            rearrange(arr, negative, positive);
        else {
            reverse(arr, 0, arr.length - 1);
            rearrange(arr, positive, negative);
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void rearrange(int[] arr, int negative, int positive) {
        if (negative % 2 == 1) {
            for (int i = 1; i < negative; i++) {
                int c = arr[i];
                int d = arr[i + negative];
                arr[i] = d;
                arr[i + negative] = c;
            }
        } else {
            for (int i = 1; i <= negative; i += 2) {
                int c = arr[i];
                int d = arr[i + negative - 1];
                arr[i] = d;
                arr[i + negative - 1] = c;
            }
        }
    }
}
