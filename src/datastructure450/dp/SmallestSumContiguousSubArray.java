package datastructure450.dp;

// https://www.geeksforgeeks.org/smallest-sum-contiguous-subarray/

public class SmallestSumContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {3,  2, 1, 7};//{-4, -3, -1, -5};//{3, -4, 2, -3, -1, 7, -5};
        System.out.println(minimumSubArraySum(arr, arr.length));
    }

    private static int minimumSubArraySum(int[] arr, int n) {
        int minSoFar = 0, min = Integer.MAX_VALUE;
        for (int num : arr) {
            minSoFar += num;
            min = Math.min(min, minSoFar);
            if (minSoFar > 0)
                minSoFar = 0;
        }
        return min;
    }
}
