package datastructure450.dp;

import java.util.Arrays;

public class SortOnColors {
    public static void main(String[] args) {
        int[] arr = {2,0,1};//{2, 0, 2, 1, 1, 0};
        int[] arr1 = {2,2,1,1,0};
        int[] arr2 = {2,1,0,2,1,0,2};
        int[] arr3 = {0,1,2};
        sortOnColors(arr, arr.length);
        sortOnColors(arr1, arr1.length);
        sortOnColors(arr2, arr2.length);
        sortOnColors(arr3, arr3.length);
    }
/*
low=0, mid=0, high=5
[0,0,2,1,1,2]  low=0, mid=0,high=4
[0,0,2,1,1,2]  low=1, mid=1,high=4
[0,0,2,1,1,2]  low=2, mid=2,high=4
[0,0,1,1,2,2]  low=2, mid=2,high=3
[0,0,1,1,2,2]  low=2, mid=3,high=3
 */
    private static void sortOnColors(int[] arr, int n) {
        int low = 0, high = n - 1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] == 1)
                mid++;
            else {
                swap(arr, mid, high);
                //mid++;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
