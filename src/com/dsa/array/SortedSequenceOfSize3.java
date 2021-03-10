package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.
        Example 1:
        Input:
        N = 5
        A[] = {1,2,1,1,3}
        Output: 1
        Explanation: a sub-sequence 1 2 3 exist.
        Example 2:

        Input:
        N = 3
        A[] = {1,1,3}
        Output: 0
        Explanation: no such sub-sequence exist.
        Your Task:
        Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector/ArrayList/array (depending on the language cpp/Java/Python), if no such element is present then return the empty vector of size 0.
*/
public class SortedSequenceOfSize3 {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(33, 24, 92, 74, 100, 72, 72, 97, 54, 77, 95, 52, 11, 95, 29);
        ArrayList<Integer> numbers = find3Numbers(array, array.size());
        System.out.printf("numbers " + numbers);
    }

    private static ArrayList<Integer> find3Numbers(List<Integer> array, int n) {
        int max = n - 1;
        int min = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int[] smaller = new int[n];
        int[] greater = new int[n];
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (array.get(i) <= array.get(min)) {
                min = i;
                smaller[i] = -1;
            } else
                smaller[i] = min;
        }
        greater[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (array.get(i) >= array.get(max)) {
                max = i;
                greater[i] = -1;
            } else
                greater[i] = max;
        }
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(array.get(smaller[i]));
                result.add(array.get(i));
                result.add(array.get(greater[i]));
                return result;
            }
        }
        return result;
    }
}
