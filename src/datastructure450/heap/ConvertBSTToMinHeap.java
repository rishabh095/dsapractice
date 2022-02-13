package datastructure450.heap;

// https://www.geeksforgeeks.org/convert-bst-min-heap/

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToMinHeap {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        preOrderPrint(root);
        convertToMinHeap(root);
        System.out.println();
        preOrderPrint(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void convertToMinHeap(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        inOrderToMinHeap(root, arr);
    }

    static int index = 0;

    private static void inOrderToMinHeap(TreeNode root, List<Integer> arr) {
        if (root != null) {
            root.val = arr.get(index++);
            inOrderToMinHeap(root.left, arr);
            inOrderToMinHeap(root.right, arr);
        }
    }

    private static void inOrder(TreeNode root, List<Integer> arr) {
        if (root != null) {
            inOrder(root.left, arr);
            arr.add(root.val);
            inOrder(root.right, arr);
        }
    }

    private static void preOrderPrint(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
    }
}
