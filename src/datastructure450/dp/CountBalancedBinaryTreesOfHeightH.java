package datastructure450.dp;

// https://www.geeksforgeeks.org/count-balanced-binary-trees-height-h/

public class CountBalancedBinaryTreesOfHeightH {
    public static void main(String[] args) {
        int height = 3;
        System.out.println(countBalancedBinaryTree(height));
        System.out.println(countBalancedBinaryTreeDP(height));
    }

    //formula explanation
    /*
    [(h-1),(h-2)] , [(h-2),(h-1)] , [(h-1),(h-1)]
    possible heights are these and any one can be from 3
    count(h)= (h-1) * (h-2) + (h-2) * (h-1) + (h-1) * (h-1)
            = 2 * (h-1) * (h-2) + (h-1) * (h-1)
            = (h-1) * [ 2 * (h-2) + (h-1) ]

     */

    // O(3^n) time complexity
    private static int countBalancedBinaryTree(int height) {
        if (height == 0 || height == 1)
            return 1;
        return countBalancedBinaryTree(height - 1) * (2 * countBalancedBinaryTree(height - 2) +
                countBalancedBinaryTree(height - 1));
    }

    // O(n) time complexity and O(n) space complexity
    private static int countBalancedBinaryTreeDP(int height) {
        int[] dp = new int[height + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= height; i++)
            dp[i] = dp[i - 1] * (2 * dp[i - 2] + dp[i - 1]);
        return dp[height];
    }
}
