package com.dsa.array;

import java.util.Arrays;

/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it. In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... (considering the increasing lexicographical order).
Example 1:
Input:
n = 5
arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5
Explanation: Array elements after
sorting it in wave form are
2 1 4 3 5.

Example 2:
Input:
n = 6
arr[] = {2,4,7,8,9,10}
Output: 4 2 8 7 10 9
Explanation: Array elements after
sorting it in wave form are
4 2 8 7 10 9.
Your Task:
The task is to complete the function convertToWave() which converts the given array to wave array.

 */
public class WaveArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(convertToWave(array, array.length)));
    }

    // O(n) time complexity
    private static int[] convertToWave(int[] array, int n) {
        /* int i=1;
        while(i<n){
            int temp=array[i];
            array[i]=array[i-1];
            array[i-1]=temp;
            i=i+2;
        }*/
        for (int i = 0; i < n - 1; i = i + 2) {
            swap(array, i, i + 1);
        }
        return array;
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
