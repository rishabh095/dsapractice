package com.dsa.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {50,20,40,60,10,30,5};
        System.out.println(Arrays.toString(arr));
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int n) {
        for(int i=0;i<n-1;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
}
