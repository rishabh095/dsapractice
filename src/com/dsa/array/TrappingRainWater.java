package com.dsa.array;

/*
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.

Example 1:
Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10

Example 2:
Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above
block of height 4 is 3 units and above
block of height 0 is 7 units. So, the
total unit of water trapped is 10 units.

Example 3:
Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.

*/
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = {3, 0, 0, 2, 0, 4};
        System.out.println(trappingWater(array, array.length));
        System.out.println(trappingWaterBetterSolution(array, array.length));
        System.out.println(trappingWaterEfficientSolution(array, array.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int trappingWaterEfficientSolution(int[] array, int n) {
        int result = 0;
        int start = 0, end = n - 1;
        int leftMax = 0, rightMax = 0;
        while (start <= end) {
            if (array[start] < array[end]) {
                if (array[start] > leftMax)
                    leftMax = array[start];
                result += leftMax - array[start];
                start++;
            } else {
                if (array[end] > rightMax)
                    rightMax = array[end];
                result += rightMax - array[end];
                end--;
            }
        }
        return result;
    }

    // O(n) time complexity and O(n) space complexity
    private static int trappingWaterBetterSolution(int[] array, int n) {
        int result = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = array[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], array[i]);
        right[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], array[i]);
        for (int i = 0; i < n; i++)
            result += Math.min(left[i], right[i]) - array[i];
        return result;
    }

    // the idea is we will find the left max height and right max height to every i and
    // subtract arr[i] from minimum of left and right and add to the result
    // O(n * n) time complexity and O(1) space complexity
    private static int trappingWater(int[] array, int n) {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = array[i];
            for (int j = 0; j < i; j++)
                left = Math.max(left, array[j]);
            int right = array[i];
            for (int j = i + 1; j < n; j++)
                right = Math.max(right, array[j]);
            result += Math.min(left, right) - array[i];
        }
        return result;
    }
}
