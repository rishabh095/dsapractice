package com.dsa.array;


/*Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
        Example 1:
        Input:
        N = 2
        A[] = {1, 10}
        Output:
        1
        Explanation:
        A[0]<=A[1] so (j-i) is 1-0 = 1.
        Example 2:

        Input:
        N = 9
        A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
        Output:
        6
        Explanation:
        In the given array A[1] < A[7]
        satisfying the required
        condition(A[i] <= A[j]) thus giving
        the maximum difference of j - i
        which is 6(7-1).*/

import java.util.Arrays;

public class MaximumIndexDiff {
    public static void main(String[] args) {
        int[] arr = {82, 63, 44, 74, 82, 99, 82};//{34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiffNaive(arr, arr.length));
        System.out.println(maxIndexDiffEfficient(arr, arr.length));
    }

    //O(n) time complexity and O(n) space complexity
    private static int maxIndexDiffEfficient(int[] arr, int n) {
        int result=-1;
        int[] leftMin=new int[n];
        int[] rightMax=new int[n];
        leftMin[0]=arr[0];
        for(int i=1;i<n;i++)
            leftMin[i]=Math.min(leftMin[i-1],arr[i]);
        rightMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(rightMax[i+1],arr[i]);
        int i=0,j=0;
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMax));
        while (i<n && j<n){
            if(leftMin[i]<=rightMax[j]){
                result=Math.max(result,j-i);
                j++;
            }else
                i++;
        }
        return result;
    }

    // O(n * n) time complexity
    private static int maxIndexDiffNaive(int[] arr, int n) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] <= arr[j])
                    result = Math.max(result, j - i);
            }
        }
        if(result == Integer.MIN_VALUE)
            return 0;
        return result;
    }
}
