package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
// Kadane's Algorithm
public class LargestSumContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSubArraySum(arr, arr.length));
    }

    private static int maxSubArraySum(int[] arr, int n) {
        int max = 0, sumSoFar = 0;
        for (int num : arr) {
            sumSoFar += num;
            if (sumSoFar < 0)
                sumSoFar = 0;
            max = Math.max(max, sumSoFar);
        }
        return max;
    }
}
