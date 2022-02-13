package datastructure450.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInAStreamOfIntegers {
    public static void main(String[] args) {
        int arr[] = {12, 15, 10, 5, 8, 7, 16};

        printMedians(arr, arr.length);
    }

    private static void printMedians(int[] arr, int n) {
        PriorityQueue<Integer> greaterPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> smallerPQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        smallerPQ.add(arr[0]);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            if (smallerPQ.size() > greaterPQ.size()) {
                if (smallerPQ.peek() > x) {
                    greaterPQ.add(smallerPQ.poll());
                    smallerPQ.add(x);
                } else
                    greaterPQ.add(x);
                System.out.print(((double) (smallerPQ.peek() + greaterPQ.peek()) / 2) + " ");
            } else {
                if (greaterPQ.peek() < x) {
                    greaterPQ.add(x);
                    smallerPQ.add(greaterPQ.poll());
                } else
                    smallerPQ.add(x);
                System.out.print(smallerPQ.peek() + " ");
            }
        }
    }
}
