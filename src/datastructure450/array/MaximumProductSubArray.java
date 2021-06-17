package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1#

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr, arr.length));
    }

    // O(n) time complexity O(1) space complexity
    private static int maxProduct(int[] arr, int n) {
        int maxProduct = arr[0], minVal = arr[0], maxVal = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
            maxProduct = Math.max(maxVal, maxProduct);
        }
        return maxProduct;
    }
}
