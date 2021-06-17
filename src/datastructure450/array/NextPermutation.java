package datastructure450.array;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr={2,1,8,7,6,5};//{1,1,5};//{3,2,1};//{1,2,3};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) time complexity
    private static void nextPermutation(int[] arr) {
        int i= arr.length-2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        if(i>=0){
            int j=arr.length-1;
            while(j>=0 && arr[i]>=arr[j])
                j--;
            swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }
}
