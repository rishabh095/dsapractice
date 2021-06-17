package com.dsa.sort;

public class IntersectionOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1={2,10,20,20,30};
        int[] arr2={3,10,20,40};
        intersection(arr1, arr1.length,arr2,arr2.length);
    }

    private static void intersection(int[] arr1, int n1, int[] arr2, int n2) {
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(arr1[i]<arr2[j])
                i++;
            else if(arr1[i]>arr2[j])
                j++;
            else{
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }
    }
}
