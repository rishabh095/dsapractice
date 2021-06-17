package com.dsa.sort;

import java.util.Random;

public class KthSmallerElement {
    static Random random=new Random();
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 11, 6, 26};
        int k = 6;
        System.out.println(kthSmallerElement(arr, k));
    }

    private static int kthSmallerElement(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int p = partition(arr, left, right);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                right = p - 1;
            else
                left = p + 1;
        }
        return -1;
    }

    private static int partition(int[] arr, int left, int right) {
        randomNumber(arr, left, right);
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void randomNumber(int[] arr, int left, int right) {
        int pos=random.nextInt(right-left+1)+left;
        System.out.println(pos+" ");
        swap(arr, pos, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
