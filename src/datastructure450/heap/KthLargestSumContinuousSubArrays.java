package datastructure450.heap;

// https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestSumContinuousSubArrays {
    public static void main(String[] args) {
        int[] arr = {20, -5, -1};//{10, -10, 20, -40};
        int k = 7;
        System.out.println(kthLargestSum(arr, arr.length, k));
    }

    private static int kthLargestSum(int[] arr, int n, int k) {
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        System.out.println(Arrays.toString(prefixSum));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int x = prefixSum[j] - prefixSum[i - 1];
                if (pq.size() < k)
                    pq.add(x);
                else if (pq.peek() < x) {
                    pq.poll();
                    pq.add(x);
                }
            }
        }
        return pq.poll();
    }
}
