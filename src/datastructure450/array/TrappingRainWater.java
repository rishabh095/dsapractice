package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(trappingWater(arr, arr.length));
        System.out.println(trappingWaterBetterSolutionWithExtraSpace(arr, arr.length));
        System.out.println(trappingWaterBetterSolutionWithOutExtraSpace(arr, arr.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int trappingWaterBetterSolutionWithOutExtraSpace(int[] arr, int n) {
        int start = 0, end = n - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (start <= end) {
            if (arr[start] < arr[end]) {
                if (arr[start] > leftMax)
                    leftMax = arr[start];
                res += leftMax - arr[start];
                start++;
            } else {
                if (arr[end] > rightMax)
                    rightMax = arr[end];
                res += rightMax - arr[end];
                end--;
            }
        }
        return res;
    }

    // O(n) time complexity and O(n) space complexity
    private static int trappingWaterBetterSolutionWithExtraSpace(int[] arr, int n) {
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(arr[i], left[i - 1]);
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(arr[i], right[i + 1]);
        for (int i = 0; i < n; i++)
            res += Math.min(left[i], right[i]) - arr[i];
        return res;
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int trappingWater(int[] arr, int n) {
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = arr[0];
            for (int j = 0; j < i; j++)
                leftMax = Math.max(leftMax, arr[j]);
            int rightMax = arr[i];
            for (int j = i + 1; j < n; j++)
                rightMax = Math.max(rightMax, arr[j]);
            res += Math.min(leftMax, rightMax) - arr[i];
        }
        return res;
    }
}
