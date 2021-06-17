package com.dsa.sort;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr={0,1,2,1,1,2,0};
        System.out.println(Arrays.toString(arr));
        sort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int n) {
        int low=0,high=n,mid=0;
        while(mid<=high){
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
