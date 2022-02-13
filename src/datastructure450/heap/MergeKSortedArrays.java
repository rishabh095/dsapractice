package datastructure450.heap;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class HeapArray implements Comparable<HeapArray> {
    int val;
    int arrayPosition;
    int valuePosition;

    public HeapArray(int val, int arrayPosition, int valuePosition) {
        this.val = val;
        this.arrayPosition = arrayPosition;
        this.valuePosition = valuePosition;
    }

    @Override
    public int compareTo(HeapArray array) {
        return val - array.val;
    }
}

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {2, 2, 3, 4},
                {5, 5, 6, 6}, {7, 8, 9, 9}};
        System.out.println(mergeKArrays(arr));
    }

    // O(n log k) time complexity where n is total no of elements and O(k) space complexity
    private static List<Integer> mergeKArrays(int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<HeapArray> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            pq.add(new HeapArray(arr[i][0], i, 0));
        while (!pq.isEmpty()) {
            HeapArray current = pq.poll();
            ans.add(current.val);
            int currentArrPos = current.arrayPosition;
            int currentValuePos = current.valuePosition;
            if (currentValuePos + 1 < arr[currentArrPos].length)
                pq.add(new HeapArray(arr[currentArrPos][currentValuePos + 1], currentArrPos, currentValuePos + 1));
        }
        return ans;
    }
}
