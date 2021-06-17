package com.dsa.sort;

import java.util.Arrays;

public class QuickSortUsingLomutoPartition {
    public static void main(String[] args) {
        int[] arr={8,4,7,9,3,10,5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(right>left){
            int p=partition(arr,left,right);
            quickSort(arr,left,p-1);
            quickSort(arr,p+1,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot=arr[right];
        int i=left-1;
        for(int j=left;j<=right;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[right];
        arr[right]=temp;
        return i+1;
    }
}
