package datastructure450.tree;

// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

import java.util.*;

class QueueNode {
    TreeNode node;
    int level;

    public QueueNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class DiagonalTraversalOfBinaryTree {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);*/
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        diagonalView(root);
        System.out.println();
        diagonalViewOtherSolution(root);
    }

    private static void diagonalViewOtherSolution(TreeNode root) {
        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new QueueNode(root, 0));
        while (!queue.isEmpty()) {
            QueueNode curr = queue.poll();
            map.putIfAbsent(curr.level, new ArrayList<>());
            map.get(curr.level).add(curr.node.val);
            if (curr.node.left != null)
                queue.add(new QueueNode(curr.node.left, curr.level + 1));
            if (curr.node.right != null)
                queue.add(new QueueNode(curr.node.right, curr.level));
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    //O(n) time complexity and O(n) space complexity
    private static void diagonalView(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        diagonalViewUtil(root, 0, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    private static void diagonalViewUtil(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null)
            return;
        List<Integer> levelList = map.get(level);
        if (levelList == null) {
            levelList = new ArrayList<>();
        }
        levelList.add(root.val);
        map.put(level, levelList);
        diagonalViewUtil(root.left, level + 1, map);
        diagonalViewUtil(root.right, level, map);
    }
}
