package com.dsa.gfg;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/?category[]=Arrays&category[]=Arrays&problemStatus=unsolved&difficulty[]=-1&page=1&sortBy=accuracy&query=category[]ArraysproblemStatusunsolveddifficulty[]-1page1sortByaccuracycategory[]Arrays

public class KLargestElement {
    public static void main(String[] args) {
        int[] arr={12, 5, 787, 1, 23};
        int k=2;
        System.out.println(Arrays.toString(kLargest(arr,k)));
    }

    // O(n log k) where k is the size of Min Heap.
    private static int[] kLargest(int[] arr,int k) {
        int[] resultArray=new int[k];
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            minHeap.add(arr[i]);
        for(int i=k;i<arr.length;i++){
            if(minHeap.peek()<arr[i]){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        while(!minHeap.isEmpty()){
            k--;
            resultArray[k]= minHeap.poll();
        }
        return resultArray;
    }
}
