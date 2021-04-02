package com.dsa.recursion;

public class MaximumNumberOfCutRope {
    public static void main(String[] args) {
        int length = 23;//5;
        //int a = 2, b = 5, c = 1;
        int a = 12, b = 9, c = 11;
        System.out.println(maxCuts(length, a, b, c));
    }

    // O(3^n)
    private static int maxCuts(int length, int a, int b, int c) {
        if (length == 0)
            return 0;
        if (length < 0)
            return -1;
        int result = Math.max(maxCuts(length - a, a, b, c),
                Math.max(maxCuts(length - b, a, b, c),
                        maxCuts(length - c, a, b, c)));
        if (result == -1)
            return -1;
        return result + 1;
    }
}
