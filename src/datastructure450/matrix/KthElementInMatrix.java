package datastructure450.matrix;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/

import java.util.PriorityQueue;

public class KthElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++)
            pq.add(new Element(0, i, matrix[0][i]));
        for (int i = 0; i < k - 1; i++) {
            Element e = pq.poll();
            if (e.row < matrix.length - 1)
                pq.add(new Element(e.row + 1, e.col, matrix[e.row + 1][e.col]));
        }
        return pq.peek().value;
    }
}
