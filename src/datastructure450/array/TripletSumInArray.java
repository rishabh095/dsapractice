package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1

import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 13;
        System.out.println(tripletSum(arr, arr.length, sum));
    }

    // O(n*n) time complexity
    private static boolean tripletSum(int[] arr, int n, int sum) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, high = n - 1;
            while (start < high) {
                if (arr[i] + arr[start] + arr[high] == sum)
                    return true;
                else if (arr[i] + arr[start] + arr[high] > sum)
                    high--;
                else
                    start++;
            }
        }
        return false;
    }
}
