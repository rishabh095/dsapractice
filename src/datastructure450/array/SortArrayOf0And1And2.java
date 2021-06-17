package datastructure450.array;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#

public class SortArrayOf0And1And2 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        System.out.println(Arrays.toString(arr));
        sortArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) time complexity
    private static void sortArray(int[] arr, int low, int high) {
        int mid=0;
        while(mid<high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid]==1)
                mid++;
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int low, int mid) {
        int temp=arr[low];
        arr[low]=arr[mid];
        arr[mid]=temp;
    }
}
