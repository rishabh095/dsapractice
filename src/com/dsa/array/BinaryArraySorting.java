package com.dsa.array;

import java.util.Arrays;

/*
Given a binary array A[] of size N. The task is to arrange the array in increasing order.

Note: The binary array contains only 0  and 1.

Example 1:
Input:
N = 5
A[] = {1,0,1,1,0}
Output: 0 0 1 1 1

Example 2:
Input:
N = 10
A[] = {1,0,1,1,1,1,1,0,0,0}
Output: 0 0 0 0 1 1 1 1 1 1
Your Task:
Complete the function SortBinaryArray() which takes given array as input and returns the sorted array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Challenge: Try doing it in one pass.

*/

public class BinaryArraySorting {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0};
        System.out.println(Arrays.toString(SortBinaryArray(arr, arr.length)));
    }

    private static int[] SortBinaryArray(int[] arr, int n) {
        int start = 0, end = n - 1;
        while (start < end) {
            if (arr[start] == 0)
                start++;
            else if (arr[end] == 1)
                end--;
            else if (arr[start] == 1 && arr[end] == 0) {
                swap(arr, start, end);
                start++;
                end--;
            } else
                end--;
        }
        return arr;
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
