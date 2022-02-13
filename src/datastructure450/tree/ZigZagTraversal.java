package datastructure450.tree;

// https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        zigzagView(root);
        System.out.println();
        zigzagViewOtherSolution(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void zigzagViewOtherSolution(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    root = deque.removeLast();
                } else {
                    root = deque.removeFirst();
                }
                System.out.print(root.val + " ");
                if (level % 2 == 0) {
                    if (root.left != null)
                        deque.addFirst(root.left);
                    if (root.right != null)
                        deque.addFirst(root.right);
                } else {
                    if (root.right != null)
                        deque.addLast(root.right);
                    if (root.left != null)
                        deque.addLast(root.left);

                }
            }
            level++;
        }
    }

    // O(n) time complexity and O(n) space complexity
    private static void zigzagView(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                System.out.print(root.val + " ");
                if (root.left != null)
                    stack2.add(root.left);
                if (root.right != null)
                    stack2.add(root.right);
            }
            while (!stack2.isEmpty()) {
                root = stack2.pop();
                System.out.print(root.val + " ");
                if (root.right != null)
                    stack1.add(root.right);
                if (root.left != null)
                    stack1.add(root.left);
            }
        }
    }
}
