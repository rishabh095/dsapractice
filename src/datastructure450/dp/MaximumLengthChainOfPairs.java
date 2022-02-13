package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/

import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class MaximumLengthChainOfPairs {
    public static void main(String[] args) {
        Pair[] arr = new Pair[4];
        arr[0] = new Pair(5, 24);
        arr[1] = new Pair(15, 25);
        arr[2] = new Pair(27, 40);
        arr[3] = new Pair(50, 60);
        System.out.println(maxChainLength(arr, arr.length));
    }

    // O(n*n) time complexity and O(n) space complexity
    private static int maxChainLength(Pair[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];
        return max;
    }
}
