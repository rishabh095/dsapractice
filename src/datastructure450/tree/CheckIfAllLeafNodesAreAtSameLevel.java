package datastructure450.tree;

public class CheckIfAllLeafNodesAreAtSameLevel {
    static boolean flag;
    static int level;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(19);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        flag = false;
        level = 0;
        System.out.println(isSameLeafLevel(root, 0));
    }

    private static boolean isSameLeafLevel(TreeNode root, int currentLevel) {
        if (root == null)
            return true;
        if (isLeaf(root)) {
            if (!flag) {
                level = currentLevel;
                flag = true;
            } else {
                if (level == currentLevel)
                    return true;
                else
                    return false;
            }
        }
        return isSameLeafLevel(root.left, currentLevel + 1) &&
                isSameLeafLevel(root.right, currentLevel + 1);
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
