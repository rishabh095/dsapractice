package com.dsa.array;

/*
Given N non-negative integers a1,a2,....an where each represents a point at coordinate (i, ai). N vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,0). Find two lines, which together with x-axis forms a container, such that it contains the most water.

Example 1:
Input:
N = 4
a[] = {1,5,4,3}
Output: 6
Explanation: 5 and 3 are distance 2 apart.
So the size of the base = 2. Height of
container = min(5, 3) = 3. So total area
= 3 * 2 = 6.

Example 2:
Input:
N = 5
a[] = {3,1,2,4,5}
Output: 12
Explanation: 5 and 3 are distance 4 apart.
So the size of the base = 4. Height of
container = min(5, 3) = 3. So total area
= 4 * 3 = 12.

Your Task :
You only need to implement the given function maxArea. Do not read input, instead use the arguments given in the function and return the desired output.

*/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 3};
        System.out.println(maxAreaNaiveSolution(array, array.length));
        System.out.println(maxAreaEfficientSolution(array, array.length));
    }

    // Two pointer approach
    // O(n*n) time complexity and O(1) space complexity
    private static int maxAreaEfficientSolution(int[] array, int n) {
        int result = 0;
        int start = 0, end = n - 1;
        while (start < end) {
            result = Math.max(result, Math.min(array[start], array[end]) * (end - start));
            if (array[start] < array[end])
                start++;
            else
                end--;
        }
        return result;
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int maxAreaNaiveSolution(int[] array, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                result = Math.max(result, Math.min(array[i], array[j]) * (j - i));
        }
        return result;
    }
}
