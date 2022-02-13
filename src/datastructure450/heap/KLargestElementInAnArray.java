package datastructure450.heap;

import java.util.*;

public class KLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int k = 3;
        firstKElements(arr, k);
        System.out.println();
        System.out.println(Arrays.stream(arr).sum());
    }

    // 2(k log k)+((n-k) log k) =>((n-k) log k)
    private static void firstKElements(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            q.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (q.peek() > arr[i])
                continue;
            else {
                q.poll();
                q.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++)
            System.out.print(q.poll() + " ");
    }
}
