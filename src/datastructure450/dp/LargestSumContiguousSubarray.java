package datastructure450.dp;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = {-10, -8, -3, -4, -2, -2};
        System.out.println(maxSubArraySum(arr, arr.length));
    }

    // Kadane's Algorithm
    // O(n) time complexity and O(1) space complexity
    private static int maxSubArraySum(int[] arr, int n) {
        int maxSoFar = 0, max = Integer.MIN_VALUE;
        for (int num : arr) {
            maxSoFar += num;
            max = Math.max(max, maxSoFar);
            if (maxSoFar < 0)
                maxSoFar = 0;
        }
        return max;
    }
}
