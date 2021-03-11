package com.dsa.array;

/*
Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Example 1:
Input:
n = 1
A[] = {1}
Output: 1
Explanation: Since its the only
element hence its the only equilibrium
point.

Example 2:
Input:
n = 5
A[] = {1,3,5,2,2}
Output: 3
Explanation: For second test case
equilibrium point is at position 3
as elements before it (1+3) =
elements after it (2+2).
 ]
Your Task:
The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. Return -1 if no such point exists.

*/
public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 2};//{1};
        System.out.println(equilibriumPoint(array, array.length));
        System.out.println(equilibriumPointEfficientSolution(array, array.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int equilibriumPointEfficientSolution(int[] array, int n) {
        int preSum = 0;
        for (int i = 0; i < n; i++)
            preSum += array[i];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            preSum -= array[i];
            if (sum == preSum)
                return i + 1;
            sum += array[i];
        }
        return -1;
    }

    // O(n) time complexity and O(n) space complexity
    private static int equilibriumPoint(int[] array, int n) {
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 0;
        for (int i = 1; i < n; i++)
            leftSum[i] = leftSum[i - 1] + array[i - 1];
        rightSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--)
            rightSum[i] = rightSum[i + 1] + array[i + 1];
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i])
                return i + 1;
        }
        return -1;
    }
}
