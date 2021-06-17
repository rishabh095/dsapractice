package com.dsa.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50,20,40,60,10,30};
        System.out.println(Arrays.toString(arr));
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr,int n) {
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }
}
