package datastructure450.array;

// https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/

import java.util.Arrays;

public class ElementsThatAppearMoreThanNDivideKTimes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int k = 4;
        findElement(arr, arr.length, k);
        System.out.println();
        int[] arr1 = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        findElementWithBinarySearch(arr1, arr1.length, k);
    }

    private static void findElementWithBinarySearch(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i = 0;
        while (i < n) {
            int x = upperBound(arr, n, arr[i]);
            if ((x - i) > n / k)
                System.out.print(arr[i] + " ");
            i = x;
        }
    }

    private static int upperBound(int[] arr, int n, int val) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // (O log n) + O(n) for traversal => (O log n) time complexity
    private static void findElement(int[] arr, int n, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while ((i + 1) < n
                    && arr[i] == arr[i + 1]) {
                cnt++;
                i++;
            }
            if (cnt > (n / k)) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}