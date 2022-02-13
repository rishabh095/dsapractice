package datastructure450.tree;

public class CheckIfTwoTreesAreMirror {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);

        System.out.println(isMirrorTree(a, b));
    }

    // O(n) time complexity and O(h) space complexity
    private static boolean isMirrorTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return a.val == b.val && isMirrorTree(a.left, b.right) && isMirrorTree(a.right, b.left);
    }
}
