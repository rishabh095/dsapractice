package com.dsa.flipkart;

public class UnsortedRangeInArray {
    public static void main(String[] args) {
        int[] arr={10,12,20,30,25,40,32,31,35,50,60};
        findRange(arr,arr.length);
    }

    private static void findRange(int[] arr, int n) {
        int start,end,min,max;
        for(start=0;start<n-1;start++){
            if(arr[start]>arr[start+1])
                break;
        }
        if(start==n-1){
            System.out.println("array is already sorted");
            return;
        }
        for(end=n-1;end>0;end--){
            if(arr[end]<arr[end-1])
                break;
        }
        min=arr[start];
        max=arr[start];
        for(int i=start+1;i<end;i++){
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        for(int i=0;i<start;i++){
            if(arr[i]>min){
                start=i;
                break;
            }
        }
        for(int i=n-1;i>=end+1;i--){
            if(arr[i]<max){
                end=i;
                break;
            }
        }
        System.out.println("range :"+start+" to "+end);
    }

   /* private static void findRange(int[] arr, int n) {
        int start,end,min,max;
        for(start=0;start<n-1;start++){
            if(arr[start]>arr[start+1])
                break;
        }
        if(start==n-1){
            System.out.println("already sorted");
            return;
        }
        for(end=n-1;end>0;end--){
            if(arr[end]<arr[end-1])
                break;
        }
        max=arr[start];
        min=arr[start];
        for(int i=start+1;i<=end;i++){
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        for(int i=0;i<start;i++){
            if(arr[i]>min){
                start=i;
                break;
            }
        }
        for(int i=n-1;i>=end+1;i--){
            if(arr[i]<max){
                end=i;
                break;
            }
        }
        System.out.println("range :"+start+" to "+end);
    }*/
}
