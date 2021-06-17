package datastructure450.array;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1

public class MergeTwoSortedArraysWithOutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {7, 9, 9, 10, 11, 11, 13, 14, 17, 19};// {1, 3, 5, 7};
        int n = arr1.length;
        int[] arr2 = {1, 1, 4, 5, 8, 11, 13, 16, 19, 19};//{0, 2, 6, 8, 9};
        int m = arr2.length;
        int a=3,b=5;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        //mergeNaive(arr1, arr2, n, m);
        //mergeUsingSort(arr1, arr2, n, m);
        mergeBestSolution(arr1, arr2, n, m);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // O(n+m) time complexity and O(1) space complexity
    private static void mergeBestSolution(int[] arr1, int[] arr2, int n, int m) {
        /*int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, i, i + gap);
                }
            }
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                if (j < m) {
                    for (j = 0; j + gap < m; j++) {
                        if (arr2[j] > arr2[j + gap]) {
                            swap(arr2, j, j + gap);
                        }
                    }
                }
            }
        }*/
        int max = Math.max(arr1[n - 1], arr2[m - 1]);
        max++;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m && k < (n + m)) {
            int e1 = arr1[i] % max;
            int e2 = arr2[j] % max;
            if (e1 <= e2) {
                // Update element by adding
                // multiplication with new number
                if (k < n)
                    arr1[k] += (e1 * max);
                else
                    arr2[k - n] += (e1 * max);
                i++;
            } else {
                // Update element by adding
                // multiplication with new number
                if (k < n)
                    arr1[k] += (e2 * max);
                else
                    arr2[k - n] += (e2 * max);
                j++;
            }
            k++;
        }
        // Process those elements which are
        // left in array a
        while (i < n) {
            int el = arr1[i] % max;
            if (k < n)
                arr1[k] += (el * max);
            else
                arr2[k - n] += (el * max);

            i++;
            k++;
        }
        // Process those elements which are
        // left in array a
        while (j < m) {
            int el = arr2[j] % max;
            if (k < n)
                arr2[k] += (el * max);
            else
                arr2[k - n] += (el * max);
            j++;
            k++;
        }
        // Finally update elements by dividing
        // with maximum element
        for (int in = 0; in < n; in++)
            arr1[in] = arr1[in] / max;
        // Finally update elements by dividing
        // with maximum element
        for (int in = 0; in < m; in++)
            arr2[in] = arr2[in] / max;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    // O(n log n + m log m)=>O((n+m) log(n+m)) time complexity and O(1) space complexity
    private static void mergeUsingSort(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0, k = n - 1;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // O(n*m) time complexity and O(1) space complexity
    private static void mergeNaive(int[] arr1, int[] arr2, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {
            int last = arr1[n - 1];
            int j;
            for (j = n - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j != n - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
