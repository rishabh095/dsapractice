package com.dsa.array;

import java.util.Arrays;

/*

Given an array A[] of size N, construct a Product Array P (of same size N) such that P[i] is equal to the product of all the elements of A except A[i].
Example 1:
Input:
N = 5
A[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation:
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Example 2:

Input:
N = 2
A[] = {12,0}
Output:
0 12

Your Task:
You do not have to read input. Your task is to complete the function productExceptSelf() that takes array A[] and N as input parameters and returns a list of N integers denoting the product array P. If the array has only one element the returned list should should contains one value i.e {1}
Note: Try to solve this problem without using the division operation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

*/

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int[] array = {10, 3, 5, 6, 2};//{1, 0};
        System.out.println(Arrays.toString(productExceptSelfWithExtraSpace(array, array.length)));
        System.out.println(Arrays.toString(productExceptSelfEfficientSolution(array, array.length)));
        System.out.println(Arrays.toString(productExceptSelf(array, array.length)));
    }

    // O(n) time complexity and O(n) space complexity
    private static int[] productExceptSelfWithExtraSpace(int[] array, int n) {
        int[] resultArray = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++)
            leftProduct[i] = array[i - 1] * leftProduct[i - 1];
        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            rightProduct[i] = array[i + 1] * rightProduct[i + 1];
        for (int i = 0; i < n; i++)
            resultArray[i] = leftProduct[i] * rightProduct[i];
        return resultArray;
    }

    // O(n) time complexity and O(n) space complexity
    private static int[] productExceptSelfEfficientSolution(int[] array, int n) {
        int[] resultArray = new int[n];
        int temp = 1;
        //resultArray[0] = 1;
        for (int i = 0; i < n; i++) {
            resultArray[i] = temp;
            temp *= array[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            resultArray[i] *= temp;
            temp *= array[i];
        }
        return resultArray;
    }

    // O(n) time complexity and O(n) space complexity
    private static int[] productExceptSelf(int[] array, int n) {
        int productOfAllElements = 1;
        int flag = 0;
        for (int num : array) {
            if (num == 0)
                flag++;
            else
                productOfAllElements *= num;
        }
        int[] resultArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag > 1)
                resultArray[i] = 0;
            else if (flag == 0)
                resultArray[i] = productOfAllElements / array[i];
            else if (flag == 1 && array[i] != 0)
                resultArray[i] = 0;
                //else if(flag== 1 && array[i] == 0)
            else
                resultArray[i] = productOfAllElements;
        }
        return resultArray;
    }
}
