package datastructure450.heap;

// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2,5,4,6,8};//{1, 3, -1, -3, 5, 3, 6, 7};//{12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        System.out.println(Arrays.toString(arr));
        maxOfWindowOfK(arr, arr.length, k);
        System.out.println();
        System.out.println(Arrays.toString(maxOfWindowOfKBetterSolution(arr, arr.length, k)));
    }

    // O(n) time complexity and O(k) space complexity
    private static int[] maxOfWindowOfKBetterSolution(int[] arr, int n, int k) {
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        for (i = k; i < n; i++) {
            res[i - k] = arr[q.peek()];
            System.out.print(arr[q.peek()] + " ");
            while (!q.isEmpty() && q.peek() <= i - k)
                q.removeFirst();
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        res[i - k] = arr[q.peek()];
        System.out.print(arr[q.peek()] + " ");
        return res;
    }

    // O(N*K) time complexity and O(1) space complexity
    private static void maxOfWindowOfK(int[] arr, int n, int k) {
        int j, max;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }
}
