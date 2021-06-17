package com.dsa.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {50, 20, 40, 60, 10, 30, 5};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[i + left];
        for (int i = 0; i < n2; i++)
            rightArray[i] = arr[i + mid + 1];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] < rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        }
        while (i < n1)
            arr[k++] = leftArray[i++];
        while (j < n2)
            arr[k++] = rightArray[j++];
    }
}
