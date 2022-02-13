package datastructure450.dp;

// https://www.geeksforgeeks.org/friends-pairing-problem/

import java.util.Arrays;

public class FriendsPairingProblem {
    static int[] dpForRecursive;

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countFriendsPairingsDP(n));
        dpForRecursive = new int[n + 1];
        Arrays.fill(dpForRecursive, -1);
        System.out.println(countFriendsPairingsDPRecursive(n));
        System.out.println(countFriendsPairingsBetterSolution(n));
    }

    //  formula is similar to fibonacci number
    // O(n) time complexity and O(1) space complexity
    private static int countFriendsPairingsBetterSolution(int n) {
        int a = 1, b = 2, c = 0;
        if (n < 3)
            return n;
        for (int i = 3; i <= 4; i++) {
            c = b + (i - 1) * a;
            a = b;
            b = c;
        }
        return c;
    }

    // O(n) time complexity and O(n) space complexity
    private static int countFriendsPairingsDPRecursive(int n) {
        if (dpForRecursive[n] != -1)
            return dpForRecursive[n];
        if (n <= 2)
            return dpForRecursive[n] = n;
        else
            return dpForRecursive[n] = countFriendsPairingsDPRecursive(n - 1) +
                    (n - 1) * countFriendsPairingsDPRecursive(n - 2);
    }

    // O(n) time complexity and O(n) space complexity
    private static int countFriendsPairingsDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
}
